package servlet;

import gen.service.client.Restaurant;
import gen.service.client.Restaurants;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.annotation.WebServlet;
import javax.xml.bind.*;

/**
 * Created with IntelliJ IDEA.
 * User: brdegenaars
 * Date: 8/12/13
 * Time: 1:20 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/restaurants/soap/GetRestaurants")
public class SOAPServlet extends javax.servlet.http.HttpServlet {

    final static String SERVER_HOST = "localhost";
    final static int SERVER_PORT = 8080;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        InputStream input = request.getInputStream();
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Restaurant.class);
            Restaurant restaurants = (Restaurant)jaxbContext.createUnmarshaller().unmarshal(input);
            System.out.println();
        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }

    private static HttpURLConnection getServiceSchema() {
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
}
