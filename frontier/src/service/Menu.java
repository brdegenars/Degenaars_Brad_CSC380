package service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: brdegenaars
 * Date: 8/12/13
 * Time: 4:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class Menu {

    List<App> availableApps;
    List<Entree> availableEntrees;

    public Menu(){}

    public Menu(List<App> availableApps, List<Entree> availableEntrees) {
        this.availableApps = availableApps;
        this.availableEntrees = availableEntrees;
    }

    public List<App> getAvailableApps() {
        return availableApps;
    }

    public void setAvailableApps(List<App> availableApps) {
        this.availableApps = availableApps;
    }

    public List<Entree> getAvailableEntrees() {
        return availableEntrees;
    }

    public void setAvailableEntrees(List<Entree> availableEntrees) {
        this.availableEntrees = availableEntrees;
    }
}
