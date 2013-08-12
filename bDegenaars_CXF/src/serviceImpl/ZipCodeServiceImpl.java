package serviceImpl;

import service.State;
import service.ZipCodeWebService;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: brdegenaars
 * Date: 8/6/13
 * Time: 5:51 PM
 * To change this template use File | Settings | File Templates.
 */
@WebService(endpointInterface = "service.ZipCodeWebService", serviceName = "ZipCodeWebService")
public class ZipCodeServiceImpl implements ZipCodeWebService {

    private static final Map<Integer, State> STATES;

    public ZipCodeServiceImpl() {
    }

    static{
        STATES = new HashMap<Integer, State>();
        STATES.put(84111, new State("Utah", "UT"));
    }
    @Override
    public State getState(int zipCode) {
        return STATES.get(zipCode);
    }

    @Override
    public void addZipCode(State state, List<Integer> zipCodes) {
        for (int zipCode : zipCodes){
            if(!STATES.containsKey(zipCode)){
                STATES.put(zipCode, state);
            }
        }
    }
}
