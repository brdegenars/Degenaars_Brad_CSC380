package servlet;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: brdegenaars
 * Date: 8/11/13
 * Time: 8:00 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "OrderServlet", urlPatterns = "/restaurants/order/*")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String order = request.getRequestURI().replace("/restaurants/order/", "");
        String[] orderParts = order.split("/");

        String restaurantName = orderParts[0];
        String[] appetizers = null, entrees = null;

        if(orderParts.length > 1){
            appetizers = orderParts[1].split("&");
            if (orderParts.length > 2)
                entrees = orderParts[2].split("&");
        }

        Double orderTotal = determineTotal(restaurantName, appetizers, entrees);
        System.out.println("Total: " + orderTotal);

        OutputStream out = response.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
        BufferedWriter writer = new BufferedWriter(outputStreamWriter);

        writer.append(orderTotal.toString());
        writer.flush();
        outputStreamWriter.flush();
        out.flush();
        writer.close();
        outputStreamWriter.close();
        out.close();
    }

    public Double determineTotal(String givenRestaurantName, String[] givenApps, String[] givenEntrees) {

        Map<String, Double> itemsOrdered = new HashMap<>();
        double total = 0.0;

        if(givenApps == null && givenEntrees == null) return total;

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        Document xml = null;

        try{
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            String relativePath = "\\WEB-INF\\resources\\Restaurants.xml";
            File absoluteFile = new File(getServletContext().getRealPath(relativePath));
            xml = documentBuilder.parse(absoluteFile);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        if (xml != null){
            xml.getDocumentElement().normalize();
            NodeList restaurants = xml.getElementsByTagName("Restaurant");
            Node chosenRestaurant = null;

            for (int i = 0; i < restaurants.getLength(); i++){
                Node restaurant = restaurants.item(i);

                if(restaurant.getNodeType() == Node.ELEMENT_NODE){

                    Element restaurantElement = (Element) restaurant;
                    String currentRestaurantName = restaurantElement.getElementsByTagName("Name").item(0).getTextContent();
                    if (givenRestaurantName.replace("%20", " ").equalsIgnoreCase(currentRestaurantName)){
                        chosenRestaurant = restaurant;
                        break;
                    }
                }
            }

            if (chosenRestaurant != null){
                NodeList chosenRestaurantChildren = chosenRestaurant.getChildNodes();
                Node menu = chosenRestaurantChildren.item(5);
                NodeList menuItems = menu.getChildNodes();

                Node apps = menuItems.item(1);
                Node entrees = menuItems.item(3);
                NodeList listOfApps = apps.getChildNodes();

                if(givenApps != null){
                    if(givenApps.length > 0 && !givenApps[0].equals("")){

                        for(int i = 0; i < listOfApps.getLength(); i++){

                            Node app = listOfApps.item(i);

                            if(app.getNodeType() == Node.ELEMENT_NODE){
                                Element appElement = (Element) app;
                                String currentAppName = appElement.getElementsByTagName("Name").item(0).getTextContent();
                                String currentAppPrice = appElement.getElementsByTagName("Price").item(0).getTextContent();

                                for(String givenAppName : givenApps){
                                    if(givenAppName.replace("%20", " ").equalsIgnoreCase(currentAppName)){
                                        itemsOrdered.put(currentAppName, Double.parseDouble(currentAppPrice));
                                    }
                                }
                            }
                        }
                    }
                }

                if (givenEntrees != null){
                    if(givenEntrees.length > 0 && !givenEntrees[0].equals("")){
                        NodeList listOfEntrees = entrees.getChildNodes();

                        for(int i = 0; i < listOfEntrees.getLength(); i++ ){
                            Node entree = listOfEntrees.item(i);

                            if(entree.getNodeType() == Node.ELEMENT_NODE){
                                Element entreeElement = (Element) entree;
                                String currentEntreeName = entreeElement.getElementsByTagName("Name").item(0).getTextContent();
                                String currentEntreePrice = entreeElement.getElementsByTagName("Price").item(0).getTextContent();

                                for(String givenEntreeName : givenEntrees){
                                    if(givenEntreeName.replace("%20", " ").equalsIgnoreCase(currentEntreeName)){
                                        itemsOrdered.put(currentEntreeName, Double.parseDouble(currentEntreePrice));
                                    }
                                }
                            }
                        }
                    }
                }

                for(String key : itemsOrdered.keySet()){
                    total += itemsOrdered.get(key);
                }
            }
        }
        return total;
    }
}
