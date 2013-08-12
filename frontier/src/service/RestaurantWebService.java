package service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: brdegenaars
 * Date: 8/12/13
 * Time: 4:26 AM
 * To change this template use File | Settings | File Templates.
 */
@WebService(name = "RestaurantWebService", targetNamespace = "http://localhost/RestaurantWebService")
public interface RestaurantWebService {

    @WebMethod(operationName = "getRestaurants")
    public @WebResult(name = "restaurants")List<Restaurant> getRestaurants();

    @WebMethod(operationName = "placeOrder")
    public void placeOrder(@WebParam(name = "order")Order order);
}
