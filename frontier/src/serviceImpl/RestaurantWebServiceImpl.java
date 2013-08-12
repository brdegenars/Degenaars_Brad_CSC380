package serviceImpl;

import service.*;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: brdegenaars
 * Date: 8/12/13
 * Time: 4:38 AM
 * To change this template use File | Settings | File Templates.
 */
@WebService(endpointInterface = "service.RestaurantWebService", serviceName = "RestaurantWebService")
public class RestaurantWebServiceImpl implements RestaurantWebService {

    private static final Queue<Order> orders;
    private static final List<Restaurant> restaurants;

    static{
        orders = new PriorityQueue<Order>();
        restaurants = new ArrayList<Restaurant>();

        List<App> apps = new ArrayList<App>();
        apps.add(new App("Nachos", 4.99));
        apps.add(new App("Cheese Quesadilla", 3.99));

        List<Entree> entrees = new ArrayList<Entree>();
        entrees.add(new Entree("Two Tacos with Rice and Beans", 10.99));
        entrees.add(new Entree("Grande Burrito", 8.99));

        restaurants.add(new Restaurant("South of the Border", "Mexican", new Menu(apps, entrees)));

        apps.removeAll(apps);
        entrees.removeAll(entrees);

        apps.add(new App("Pot Stickers", 5.99));
        apps.add(new App("Dumplings", 4.99));

        entrees.add(new Entree("Orange Chicken", 10.99));
        entrees.add(new Entree("Mongolian Beef", 12.99));

        restaurants.add(new Restaurant("Cindy Lee's", "Chinese", new Menu(apps, entrees)));
    }

    public RestaurantWebServiceImpl() {}

    @Override
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    @Override
    public void placeOrder(@WebParam(name = "order") Order order) {
        orders.add(order);
    }
}
