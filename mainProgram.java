package assignment2;


/**
 * The main program for running 
 * @author Zhening
 */
public class mainProgram {
	final static int row = 50;
	final static int rowSeats = 4;
	/**
	 * main program for running 
	 * @param args
	 */
	public static void main(String[] args){
		Reserve reservation = new Reserve();
		Aircraft plane = new Aircraft(row,rowSeats);
		Runnable run1 = new AutomatedProducer(plane,reservation,1);
		Runnable run2 = new AutomatedProducer(plane,reservation,2);
		Runnable run3 = new ManualProducer(plane,reservation,3);
		// Create 3 threads
		Thread t1 = new Thread(run1);
		Thread t2 = new Thread(run2);
		Thread t3 = new Thread(run3);
		
		t1.start();
		t2.start();
		t3.start();
	}
}
