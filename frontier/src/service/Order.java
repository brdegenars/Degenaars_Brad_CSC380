package service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: brdegenaars
 * Date: 8/12/13
 * Time: 4:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class Order {

    String restaurantName;
    List<App> apps;
    List<Entree> entrees;

    public Order() {}

    public Order(String restaurantName, List<App> apps, List<Entree> entrees) {
        this.restaurantName = restaurantName;
        this.apps = apps;
        this.entrees = entrees;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public List<App> getApps() {
        return apps;
    }

    public void setApps(List<App> apps) {
        this.apps = apps;
    }

    public List<Entree> getEntrees() {
        return entrees;
    }

    public void setEntrees(List<Entree> entrees) {
        this.entrees = entrees;
    }
}
