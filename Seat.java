package assignment2;
/**
 * A class for seats in aircraft
 * @author Zhening
 *
 */
public class Seat{
	/**
	 * Constructs a Seat object that has two status: empty or Occupied
	 */
	private boolean status;
	
	public Seat(){
		this.status = false;
	}
	
	/**
	 * Check the status of a seat
	 * @return a String ("Empty" or "Occupied") indicating the status of the seat
	 */
	public String checkStatus(){
		if (status == false) {
			return "Empty";
		}
		else 
			return "Occupied";
	}
	
	/**
	 * Reserve a seat, change the state of a seat from empty to occupied.
	 */
	public void reserve(){
		if (status == false) {
			status = true;
		}
	}
	}	