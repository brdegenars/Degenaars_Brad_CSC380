package servlet;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;
import serviceImpl.RestaurantWebServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.xml.ws.Endpoint;

/**
 * Created with IntelliJ IDEA.
 * User: brdegenaars
 * Date: 8/12/13
 * Time: 4:52 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/services/*")
public class GetRestaurantsServlet extends CXFNonSpringJaxrsServlet {

    @Override
    protected void loadBus(ServletConfig sc){
        super.loadBus(sc);

        Bus bus = getBus();
        BusFactory.setDefaultBus(bus);
        Endpoint.publish("/RestaurantWebService", new RestaurantWebServiceImpl());
    }
}
