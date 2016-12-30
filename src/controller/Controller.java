package controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.sms.client.gui.SMSWindow;
import es.deusto.ingenieria.sd.sms.client.remote.RMIServiceLocator;
import es.deusto.ingenieria.sd.sms.server.data.dto.TVProgramDTO;

public class Controller {

	private RMIServiceLocator rsl;

	public SMSController(String[] args) throws RemoteException {
		rsl = new RMIServiceLocator();
		rsl.setService(args);
		new SMSWindow(this);
	}

	public List<TVProgramDTO> getTVPrograms() {
		List<TVProgramDTO> programs = new ArrayList<>();
		// ADD YOUR CODE HERE
		try {
			for (TVProgramDTO a : rsl.getAdminService().getTVPrograms()) programs.add(a);
			//for(TVProgramDTO a : rsl.getReceiverService().getTVPrograms()) programs.add(a);
		}catch (Exception e){

		}
		return programs;
	}

	public void newTVProgram(String acronym, String description) {
		// ADD YOUR CODE HERE
		try {
			// Add your code HERE - Related to getting the service and requesting creation of TVProgram
			//rsl.getService().newTVProgram( acronym, description);
			rsl.getAdminService().newTVProgram( acronym, description);
		} catch (Exception e){
			System.err.println("$ Error sending new TV program: " + e.getMessage());
		}
	}

	public void sendMessage(String phone, String text) {
		// ADD YOUR CODE HERE
		try{
			// Add your code HERE - Related to getting the service and sending a message
			rsl.getReceiverService().receiveMessage(phone, text);


		} catch(Exception e){
			System.out.println("$ Error sending a message: " + e.getMessage());
		}
	}

	public void closeTVProgram(String acro) {

		// ADD YOUR CODE HERE

	}

	public void addMaximumNumberMessagesRestriction() {

		// ADD YOUR CODE HERE

	}

	public void addPermittedOptionsRestriction() {

		// ADD YOUR CODE HERE

	}

	public void addForbiddenWordsRestriction() {

		// ADD YOUR CODE HERE
	
	}

	public void generateReport() {

		// ADD YOUR CODE HERE

	}

	public void exit() {
		System.exit(0);
	}

	public static void main(String[] args) throws RemoteException {
		new SMSController(args);
	}
}