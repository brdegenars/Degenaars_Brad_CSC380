package client;

import gen.service.client.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: brdegenaars
 * Date: 8/11/13
 * Time: 4:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class RestClient {

    final int SERVER_PORT = 8080;
    final String SERVER_HOST = "localhost";
    final String SERVER_PROTOCOL = "http";

    public RestClient(){

        HttpURLConnection connection = getServiceSchema();
        List<Restaurant> restaurants = null;
        try {
            restaurants = displayRestaurants();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        Restaurant chosenRestaurant = promptUserForRestaurant(restaurants);
        List<App> appsToOrder = promptUserForApps(chosenRestaurant);
        List<Entree> entreesToOrder = promptUserForEntree(chosenRestaurant);

        System.out.println("\nYou ordered: \n");
        for(App app : appsToOrder){
            System.out.println(app.getName());
        }
        System.out.println("And");
        for(Entree entree : entreesToOrder){
            System.out.println(entree.getName());
        }


    }

    public List<Entree> promptUserForEntree(Restaurant restaurant){

        List<Entree> entreesToOrder = new ArrayList<Entree>();
        Menu menu = restaurant.getMenu();
        Entrees entrees = menu.getEntrees();
        List<Entree> listOfEntrees = entrees.getEntree();
        Scanner scanner = new Scanner(System.in);
        boolean entreeOK = false;

        do{
            System.out.println("Would you like any entrees from " + restaurant.getName() + "? (Ex: " + listOfEntrees.get(0).getName()+ ", " + listOfEntrees.get(1).getName() + ")" +  "\n:");
            String userInput = scanner.nextLine();

            String[] desiredEntrees = userInput.split(",");

            for(String entreeName : desiredEntrees){
                entreeOK = false;

                for(Entree entree : listOfEntrees){
                    if (entreeName.trim().equalsIgnoreCase(entree.getName())){
                        entreesToOrder.add(entree);
                        entreeOK = true;
                        break;
                    }
                }
                if(!entreeOK) System.out.println("One or more of your appetizers was not on the menu.");
            }
        } while (!entreeOK);
        return entreesToOrder;
    }

    public List<App> promptUserForApps(Restaurant restaurant){

        List<App> appsToOrder = new ArrayList<App>();
        Menu menu = restaurant.getMenu();
        Apps apps = menu.getApps();
        List<App> listOfApps = apps.getApp();
        Scanner scanner = new Scanner(System.in);
        boolean appOK = false;

        do{
            System.out.println("Would you like any appetizers from " + restaurant.getName() + "? (Ex: " + listOfApps.get(0).getName()+ ", " + listOfApps.get(1).getName() + ")" +  "\n:");
            String userInput = scanner.nextLine();

            String[] desiredApps = userInput.split(",");

            for(String appName : desiredApps){
                appOK = false;

                for(App app : listOfApps){
                    if (appName.trim().equalsIgnoreCase(app.getName())){
                        appsToOrder.add(app);
                        appOK = true;
                        break;
                    }
                }
                if(!appOK) System.out.println("One or more of your appetizers was not on the menu.");
            }
        } while (!appOK);
        return appsToOrder;
    }

    public Restaurant promptUserForRestaurant(List<Restaurant> restaurants){

        String userResponse = null;
        Restaurant userSelectedRestaurant = null;
        boolean validRestaurant = false;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("Which restaurant would you like to order from? (Not case sensitive)\n: ");

            userResponse = scanner.nextLine();

            for(Restaurant restaurant : restaurants){
                if(userResponse.equalsIgnoreCase(restaurant.getName())){
                    userSelectedRestaurant = restaurant;
                    validRestaurant = true;
                }
            }

            if (!validRestaurant) System.out.println("Please enter a valid restaurant!");

        } while (!validRestaurant);

        return userSelectedRestaurant;
    }

    public List<Restaurant> displayRestaurants() throws JAXBException {

        HttpURLConnection connection = null;
        JAXBContext jaxbContext = JAXBContext.newInstance(Restaurants.class);
        InputStream response;
        Restaurants restaurants = null;
        List<Restaurant> restaurantList = null;

        try {
            connection = (HttpURLConnection)(new URL(SERVER_PROTOCOL + "://" +SERVER_HOST + ":" + SERVER_PORT + "/restaurants").openConnection());
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/xml");

            response = connection.getInputStream();

            restaurants = (Restaurants) jaxbContext.createUnmarshaller().unmarshal(response);

        } catch (MalformedURLException e) {
            System.out.println("Wrong URL");
        } catch (IOException e) {
            System.out.println("Couldn't open connection");
        }

        if (restaurants != null){
            System.out.println("\nThe following restaurants are available: \n");
            restaurantList = restaurants.getRestaurant();
            for(Restaurant restaurant : restaurantList){

                System.out.println("Restaurant name: " + restaurant.getName());
                System.out.println("Restaurant genre: " + restaurant.getGenre());
                printRestaurantMenu(restaurant);
                System.out.println("---------------------------------------------------");
            }
        }
        return restaurantList;
    }

    private void printRestaurantMenu(Restaurant restaurant) {
        System.out.println("Menu: \n");
        System.out.println("Appetizers: ");

        Menu menu = restaurant.getMenu();
        Apps apps = menu.getApps();

        for(App app: apps.getApp()){
            System.out.println(app.getName() + " (" + app.getPrice() + ")");
        }

        Entrees entrees = menu.getEntrees();
        System.out.println("\nEntrees: ");

        for (Entree entree : entrees.getEntree()){
            System.out.println(entree.getName() + " (" + entree.getPrice() + ")");
        }
    }

    private HttpURLConnection getServiceSchema() {
        HttpURLConnection urlConnection = null;
        InputStream response = null;

        try {
            urlConnection = (HttpURLConnection)(new URL("http://" + SERVER_HOST + ":" + SERVER_PORT + "/restaurants/xsd").openConnection());
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Accept", "application/xml");
            response = urlConnection.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(response);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String currentLine;
            Path path = Paths.get(".\\resources");
            Path fullPath = Paths.get(".\\resources\\Restaurants.xsd");

            if(!Files.exists(path)){

                Files.createDirectory(path);

                if (!Files.exists(fullPath)){

                    Files.createFile(fullPath);
                }
            }
            File newFile = new File(fullPath.toUri());
            PrintWriter writer = new PrintWriter(newFile);

            while ((currentLine = bufferedReader.readLine()) != null){
                writer.write(currentLine);
            }
            writer.flush();
            writer.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlConnection;
    }

    public static void main(String[] args) {
        new RestClient();
    }
}
