package remote;

/**
 * Created by inigo on 21/11/16.
 */
public class RMIServiceLocator {

    public IFlightManager service;

    public void setService(String ip, String puerto, String nombre) {
        try{
            String namePaymentS = "//" + ip + ":" + puerto +"/" + nombre;
            service = (IFlightManager) java.rmi.Naming.lookup(namePaymentS);
        }catch (Exception e){

        }
    }

    public IFlightManager getService(){
        return service;
    }
}
