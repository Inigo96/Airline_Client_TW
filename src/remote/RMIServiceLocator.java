package remote;

import es.deusto.ingenieria.sd.sms.server.remote.ITVProgramAdmin;
import es.deusto.ingenieria.sd.sms.server.remote.ITVProgramReceiver;

public class RMIServiceLocator{
	// The Cache
	private ReservationService reservationService;

    public void setService(String[] args) {
    	
    	// Add your code to get the TARGET reference HERE
        try {
            String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
            adminService = (ReservationService) java.rmi.Naming.lookup(name);

        }catch (Exception e){
            //System.out.println("//" + args[0] + ":" + args[1] + "/" + args[2]);
        }
    }

    public ReservationService getReservationService() {
    	return ReservationService;
    }

}