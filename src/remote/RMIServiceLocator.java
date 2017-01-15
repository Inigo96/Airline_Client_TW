package remote;
import remote.IReservationService;

/**
 * Created by inigo on 21/11/16.
 */
public class RMIServiceLocator {

    public IReservationService service;

    public void setService(String ip, String puerto, String nombre) {
        try{
            String namePaymentS = "//" + ip + ":" + puerto +"/" + nombre;
            service = (IReservationService) java.rmi.Naming.lookup(namePaymentS);
        }catch (Exception e){

        }
    }

    public IReservationService getService(){
        return service;
    }
}
