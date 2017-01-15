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

	public Controller(String[] args) throws RemoteException {
		rsl = new RMIServiceLocator();
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