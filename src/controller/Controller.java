package controller;

import entities.*;
import remote.RMIServiceLocator;
import gui.MainWindow;

import java.rmi.RemoteException;
import java.util.Date;

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


	public Flight[] searchFlight(String departureA, String arrivalA, Date date){
		try {
			return this.rsl.getService().searchFlight(departureA,arrivalA,date);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Reservation[] getReservations(User u) throws RemoteException{
		try {
			return this.rsl.getService().getReservations(u);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean createReservation(Flight f, User u) throws RemoteException{
		try {
			return this.rsl.getService().createReservation(f,u);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
}