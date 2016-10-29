package assignment2;

import javax.swing.JButton;

/**
 * Construct a thread process that manually reserve the seats
 * @author Zhening
 *
 */
public class ManualProducer implements Runnable {
	
	private Aircraft plane;
	private static final int DELAY = 10;
	private int ID;
	private int clicked;
	private Reserve reservation; // this is the GUI to be implemented on
	private JButton[] buttonsClicked;
	/**
	 * Construct a manual producer that implements the thread 
	 * @param a the aircraft to be reserved on
	 * @param b the GUI to be displayed
	 * @param c The ID of the thread
	 */
	public ManualProducer(Aircraft a, Reserve b, int c){
		plane = a;
		ID = c;
		reservation = b;
		clicked = 0;
		buttonsClicked = b.getButtonsClicked();
	}
	
	/**
	 * Keep running the thread until there is no empty seat available. 
	 * Check if there is clicked buttons that haven't been processed.
	 * If there is, change its text to user ID.
	 * Sleep for a random time to allow another thread running.
	 */
	public void run(){
		try{
			while(plane.numberOfEmptySeats() > 0){
				//check if there is clicked buttons that haven't been processed
				if (clicked != reservation.countOfButtonsClicked()){
					buttonsClicked[clicked].setText(" User Id: " + ID);
					clicked++;
				}
				Thread.sleep((int)(Math.random()*DELAY));
			}
		}
		catch(InterruptedException exception){
			
		}
	}
}