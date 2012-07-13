package main;

import data.PartAndCause;
import javax.swing.SwingUtilities;

/**
 * This application is made to create 'clean' tickets for the ticketing application
 * at our workplace.
 *  
 * This Class is the Main class for the application.
 * 
 * @author vm
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		
		
		//Startup the application
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				MainApp.getInstance().startup();
			}
		});


		System.out.println("The application is started.");

	}
}
