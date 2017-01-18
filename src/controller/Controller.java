package controller;

import entities.*;
import remote.RMIServiceLocator;
import gui.MainWindow;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by inigo on 21/11/16.
 */
public class Controller {

	private RMIServiceLocator rsl;

	public Controller(String ip, String port, String serviceName) throws RemoteException {
		rsl = new RMIServiceLocator();
		rsl.setService(ip, port, serviceName);
		new MainWindow(this);
	}

	public synchronized UserDTO login(String u,String p){
		try {
			return this.rsl.getService().login(u,p);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}


	public synchronized ArrayList<FlightDTO> searchFlight(String departureA, String arrivalA, GregorianCalendar date) {
		try {
			return flightarray2ArrayList(this.rsl.getService().searchFlight(departureA,arrivalA,date));
		} catch (RemoteException e) {
			System.out.println("ERROR ");
			e.printStackTrace();
			return null;
		}
	}

	public synchronized ArrayList<ReservationDTO> getReservations(UserDTO u){
		//			return reservationarray2ArrayList(this.rsl.getService().getReservations(u));
		return (ArrayList<ReservationDTO>) login(u.getUsername(),u.getPassword()).getReservation();
	}

	public synchronized boolean createReservation(FlightDTO f, UserDTO u){

		try {
			return this.rsl.getService().createReservation(f,u);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}


	public synchronized ArrayList<FlightDTO> flightarray2ArrayList(FlightDTO[] a){
		ArrayList<FlightDTO> fl = new ArrayList<>();
		for (FlightDTO j:a) fl.add(j);
		return fl;
	}

//	public synchronized ArrayList<ReservationDTO> reservationarray2ArrayList(List<ReservationDTO> a){
//		ArrayList<ReservationDTO> fl = new ArrayList<>();
//		for (ReservationDTO j:a) fl.add(j);
//		return fl;
//	}

	public static void main(String[] args) throws RemoteException {
		Controller controller=new Controller(args[0],args[1],args[2]);
//		System.out.println(controller.searchFlight("a","b",new GregorianCalendar()).get(0).getArrivalA());
//		System.out.println(controller.searchFlight("a","b",new GregorianCalendar()).get(0).getDepartureA());
//		System.out.println(controller.searchFlight("a","b",new GregorianCalendar()).get(0).getDate());
//		System.out.println(controller.searchFlight("a","b",new GregorianCalendar()).size());
//		System.out.println(controller.searchFlight("a","b",new GregorianCalendar()).get(1).getArrivalA());
//		System.out.println(controller.searchFlight("a","b",new GregorianCalendar()).get(1).getDepartureA());
//		FlightDTO flight=controller.searchFlight("a","b",new GregorianCalendar()).get(0);
////		System.out.println(controller.login("trrf@gmail.com","gjf").getUsername());
//		UserDTO userdto = controller.login("trrf@gmail.com","gjf");
//		controller.createReservation(flight,userdto);
//		System.out.println("Reserva hecha");
//		System.out.println(userdto.getUsername());
//		userdto = controller.login("trrf@gmail.com","gjf");
//		System.out.println(controller.getReservations(userdto).get(0).getFlight());
//		System.out.println(controller.getReservations(userdto).size());
	}
}
