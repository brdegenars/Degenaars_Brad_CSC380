package service;

/**
 * Created with IntelliJ IDEA.
 * User: brdegenaars
 * Date: 8/12/13
 * Time: 4:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class Entree {

    String name;
    Double price;

    public Entree(){}

    public Entree(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
