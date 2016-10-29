package assignment2;

import java.lang.Math;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.*;

/**
 * Construct a thread process that automatically reserve the seats
 * @author Zhening
 *
 */
public class AutomatedProducer implements Runnable{
	private Aircraft plane;
	private static final int DELAY = 200;
	private JButton[][] buttons;
	private int ID;
	final ReentrantLock alock = new ReentrantLock();
	
	/**
	 * Construct a AutomatedProducer object that implements the thread
	 * @param a the aircraft to be reserved on
	 * @param b the GUI to be displayed
	 * @param c The ID of the thread
	 */
	public AutomatedProducer(Aircraft a, Reserve b, int c){
		plane = a;
		buttons = b.getJButtons();
		ID = c;
	}
	
	/**
	 * Keep running the thread until there is no empty seat available. 
	 * Reserve the seat randomly, once reserved, set the button text to the ID of the thread
	 * Sleep for a random time to allow another thread running
	 */
	public void run(){
		try{
			alock.lock();
			while(plane.numberOfEmptySeats() > 0){
				int randomRow = ThreadLocalRandom.current().nextInt(0, plane.getRow());
				int randomRowSeat = ThreadLocalRandom.current().nextInt(0, plane.getRowSeats());
				if (plane.getSeat(randomRow,randomRowSeat).checkStatus() == "Empty"){
					plane.reserveSeat(randomRow,randomRowSeat);
					if (buttons[randomRow][randomRowSeat].getText() == ""){
						buttons[randomRow][randomRowSeat].setText(" User Id : " + ID);
					}
					
				}
				Thread.sleep((int)(Math.random()*DELAY));
			}
			
		}
		catch(InterruptedException exception){
			
		}
		finally{
			alock.unlock();
		}
	}
}