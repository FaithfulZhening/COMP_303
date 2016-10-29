package assignment2;
/**
 * A class for producing Aircraft Object
 * @author Zhening
 *
 */
public class Aircraft {
	
	private int seatsAvailable;
	private Seat seats[][];
	private int numberOfRow;
	private int numberOfRowSeats;
	
	/**
	 * Construct a Aircraft object that contains seats
	 * @param row the number of rows of seats in the aircraft
	 * @param rowSeats the number of seats in a row
	 */
	public Aircraft(int row, int rowSeats){
		numberOfRow = row;
		numberOfRowSeats = rowSeats;
		seatsAvailable = row * rowSeats;
		seats = new Seat[row][rowSeats];
		for (int i =0; i < row; i ++){
			for (int j = 0; j < rowSeats; j ++){
				seats[i][j] = new Seat();
			}
		}
	}
	
	/**
	 * Get a specific seat of the aircraft
	 * @param row the row number of the specific seat
	 * @param rowSeat the position in the row of the specific seat
	 * @return a Seat object in the specific position
	 */
	public Seat getSeat(int row, int rowSeat){
		Seat a = seats[row][rowSeat];
		return a;
	}
	
	/**
	 * Reserve a seat in a specific position
	 * @param row the row number of the specific seat
	 * @param rowSeat the position in the row of the specific seat
	 */
	public void reserveSeat(int row, int rowSeat){
		Seat a = seats[row][rowSeat];
		if (a.checkStatus() == "Empty"){
			a.reserve();
			seatsAvailable -- ;
		}
	}
	
	/**
	 * Get the number of empty seats left in the aircraft
	 * @return the number of empty seats left
	 */
	public int numberOfEmptySeats(){
		return this.seatsAvailable;
	}
	
	/**
	 * Get the number of rows of the aircraft
	 * @return the number of rows
	 */
	public int getRow(){
		return this.numberOfRow;
	}
	
	/**
	 * Get the number of seats in a row of the aircraft
	 * @return the number of seats in a row
	 */
	public int getRowSeats(){
		return this.numberOfRowSeats;
	}
	
	
	
}