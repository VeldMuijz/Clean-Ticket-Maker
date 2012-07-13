package main;

import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * Main application window
 * @author vm
 */
public class MainApp {

	private JFrame window;
	private static MainApp instance = new MainApp();

	/**
	 * this method initializes the application
	 */
	public void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
		}

		startup();

	}

	/**
	 * This method is used to start the application up. This sets the look and 
	 * feel and all the variables of the frame.
	 */
	public void startup() {
		/*Set the window variables. Here it is set to use the standard operating
		 * system look. */
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
		}
				//Set the title
		window = new JFrame("Clean Ticket Creator");
		window.getContentPane().setLayout(new BorderLayout());
		
		//Show the IntroScreen, this is the homescreen.
		switchPanel(new view.IntroScreen());
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1035, 465);
		window.setResizable(false);
		window.setVisible(true);

	}

	/**
	 * This method is used to switch panels. The panels are switched but keep
	 * the same header all the time.
	 * @param panel 
	 */
	public void switchPanel(JPanel panel) {
		view.Header header = new view.Header();
		//Switch to the desired panel
		window.getContentPane().removeAll();
		window.getContentPane().add(header, BorderLayout.NORTH);
		window.getContentPane().add(panel);
		window.getContentPane().validate();
		window.getContentPane().repaint();

	}

	/**
	 * Create an instance of the program.
	 * @return 
	 */
	public static MainApp getInstance() {
		return instance;
	}
}
