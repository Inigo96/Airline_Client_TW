package controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.sms.client.gui.SMSWindow;
import es.deusto.ingenieria.sd.sms.client.remote.RMIServiceLocator;
import es.deusto.ingenieria.sd.sms.server.data.dto.TVProgramDTO;

public class Controller {

	private RMIServiceLocator rsl;

	public Controller(String[] args) throws RemoteException {
		rsl = new RMIServiceLocator();
		rsl.setService(args);
		new SMSWindow(this);
	}


}