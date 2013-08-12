
package gen.service.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gen.service.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PlaceOrderResponse_QNAME = new QName("http://localhost/RestaurantWebService", "placeOrderResponse");
    private final static QName _GetRestaurantsResponse_QNAME = new QName("http://localhost/RestaurantWebService", "getRestaurantsResponse");
    private final static QName _GetRestaurants_QNAME = new QName("http://localhost/RestaurantWebService", "getRestaurants");
    private final static QName _PlaceOrder_QNAME = new QName("http://localhost/RestaurantWebService", "placeOrder");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gen.service.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PlaceOrder }
     * 
     */
    public PlaceOrder createPlaceOrder() {
        return new PlaceOrder();
    }

    /**
     * Create an instance of {@link GetRestaurants }
     * 
     */
    public GetRestaurants createGetRestaurants() {
        return new GetRestaurants();
    }

    /**
     * Create an instance of {@link GetRestaurantsResponse }
     * 
     */
    public GetRestaurantsResponse createGetRestaurantsResponse() {
        return new GetRestaurantsResponse();
    }

    /**
     * Create an instance of {@link PlaceOrderResponse }
     * 
     */
    public PlaceOrderResponse createPlaceOrderResponse() {
        return new PlaceOrderResponse();
    }

    /**
     * Create an instance of {@link App }
     * 
     */
    public App createApp() {
        return new App();
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link Menu }
     * 
     */
    public Menu createMenu() {
        return new Menu();
    }

    /**
     * Create an instance of {@link Restaurant }
     * 
     */
    public Restaurant createRestaurant() {
        return new Restaurant();
    }

    /**
     * Create an instance of {@link Entree }
     * 
     */
    public Entree createEntree() {
        return new Entree();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlaceOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/RestaurantWebService", name = "placeOrderResponse")
    public JAXBElement<PlaceOrderResponse> createPlaceOrderResponse(PlaceOrderResponse value) {
        return new JAXBElement<PlaceOrderResponse>(_PlaceOrderResponse_QNAME, PlaceOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRestaurantsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/RestaurantWebService", name = "getRestaurantsResponse")
    public JAXBElement<GetRestaurantsResponse> createGetRestaurantsResponse(GetRestaurantsResponse value) {
        return new JAXBElement<GetRestaurantsResponse>(_GetRestaurantsResponse_QNAME, GetRestaurantsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRestaurants }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/RestaurantWebService", name = "getRestaurants")
    public JAXBElement<GetRestaurants> createGetRestaurants(GetRestaurants value) {
        return new JAXBElement<GetRestaurants>(_GetRestaurants_QNAME, GetRestaurants.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlaceOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/RestaurantWebService", name = "placeOrder")
    public JAXBElement<PlaceOrder> createPlaceOrder(PlaceOrder value) {
        return new JAXBElement<PlaceOrder>(_PlaceOrder_QNAME, PlaceOrder.class, null, value);
    }

}
