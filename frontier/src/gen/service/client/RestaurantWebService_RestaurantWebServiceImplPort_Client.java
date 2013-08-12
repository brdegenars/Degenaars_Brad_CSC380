
package gen.service.client;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import javax.xml.namespace.QName;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2013-08-12T06:14:32.738-06:00
 * Generated source version: 2.7.6
 * 
 */
public final class RestaurantWebService_RestaurantWebServiceImplPort_Client {

    private static final QName SERVICE_NAME = new QName("http://serviceImpl/", "RestaurantWebService");

    private RestaurantWebService_RestaurantWebServiceImplPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = RestaurantWebService_Service.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        RestaurantWebService_Service ss = new RestaurantWebService_Service(wsdlURL, SERVICE_NAME);
        RestaurantWebService port = ss.getRestaurantWebServiceImplPort();  
        
        {
            System.out.println("Invoking placeOrder...");
            List<App> apps = new ArrayList<>();
            App nachos = new App();
            nachos.setName("Nachos");
            nachos.setPrice(4.99);
            apps.add(nachos);

            Entree burrito = new Entree();
            burrito.setName("Grande Burrito");
            burrito.setPrice(10.99);
            List<Entree> entrees = new ArrayList<>();
            entrees.add(burrito);
            gen.service.client.Order _placeOrder_order = new ObjectFactory().createOrder();
            _placeOrder_order.setRestaurantName("South of the Border");
            _placeOrder_order.apps = apps;
            _placeOrder_order.entrees = entrees;
            port.placeOrder(_placeOrder_order);
        }
        {
        System.out.println("Invoking getRestaurants...");
        java.util.List<gen.service.client.Restaurant> _getRestaurants__return = port.getRestaurants();
        System.out.println("getRestaurants.result=" + _getRestaurants__return);


        }

        System.exit(0);
    }

}
