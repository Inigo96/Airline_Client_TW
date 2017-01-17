package controller;

import entities.*;
import remote.RMIServiceLocator;
import gui.MainWindow;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

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

	public User login(String u,String p){
		try {
			return this.rsl.getService().login(u,p);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}


	public ArrayList<Flight> searchFlight(String departureA, String arrivalA, GregorianCalendar date){
		try {
			return flightarray2ArrayList(this.rsl.getService().searchFlight(departureA,arrivalA,date));
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Reservation> getReservations(User u){
		try {
			return reservationarray2ArrayList(this.rsl.getService().getReservations(u));
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean createReservation(Flight f, User u){
		try {
			return this.rsl.getService().createReservation(f,u);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
//	public ArrayList<Object> array2ArrayList(Object[] a){
//		if(a[0] instanceof Flight){
//			ArrayList<Flight> ar= new ArrayList<>();
//			for (Flight j:a) ar.add(j);
//		}else if(a[0] instanceof Reservation){
//			ArrayList<Reservation> ar= new ArrayList<>();
//			for (Reservation j:a) ar.add(j);
//		}
//		return ar;
//	}

	public ArrayList<Flight> flightarray2ArrayList(Flight[] a){
		ArrayList<Flight> fl = new ArrayList<>();
		for (Flight j:a) fl.add(j);
		return fl;
	}

	public ArrayList<Reservation> reservationarray2ArrayList(Reservation[] a){
		ArrayList<Reservation> fl = new ArrayList<>();
		for (Reservation j:a) fl.add(j);
		return fl;
	}

	public static void main(String[] args) throws RemoteException {
		Controller controller=new Controller(args[0],args[1],args[2]);
	}
}
