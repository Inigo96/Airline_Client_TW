package controller;

import gui.GUI;
import remote.Service_Locator;
import gui.GUI;

import java.rmi.RemoteException;
import java.util.Date;

/**
 * Created by inigo on 21/11/16.
 */
public class Controller {

	private Service_Locator rsl;

	public Controller(String[] args) throws RemoteException {
		rsl = new Service_Locator();
		rsl.setService(args[0], args[1], args[2]);
		new GUI(this);
	}

	boolean login(String u,String p){

	}

	boolean register(User u){

	}

	boolean editProfile(User u){

	}

	Flight[] searchFlight(String departureA, String arrivalA, Date date){

	}

	boolean bookFlight(Flight flight){

	}
}