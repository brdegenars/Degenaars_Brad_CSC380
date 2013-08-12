package service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: brdegenaars
 * Date: 8/6/13
 * Time: 5:48 PM
 * To change this template use File | Settings | File Templates.
 */
@WebService(name = "ZipCodeService", targetNamespace = "http://localhost/ZipCodeService")
public interface ZipCodeWebService {

    @WebMethod(operationName = "getState")
    public @WebResult(name = "state") State getState(@WebParam(name = "zipCode")int zipCode);

    @WebMethod(operationName = "addZipCode")
    public void addZipCode(@WebParam(name = "state") State state, @WebParam(name = "zipCodes") List<Integer> zipCodes);
}
