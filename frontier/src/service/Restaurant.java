package service;

/**
 * Created with IntelliJ IDEA.
 * User: brdegenaars
 * Date: 8/12/13
 * Time: 4:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class Restaurant {

    String name, genre;
    Menu menu;

    public Restaurant(){}

    public Restaurant(String name, String genre, Menu menu) {
        this.name = name;
        this.genre = genre;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
