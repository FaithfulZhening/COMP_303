package assignment2;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * A class for producing the GUI to be displayed
 * @author Zhening
 *
 */
public class Reserve extends JFrame {
	final static int row = 50;
	final static int rowSeats = 4;
	private JPanel instructionPanel = new JPanel(); 
	private JPanel seatsPanel = new JPanel();
	private JPanel rowPanel = new JPanel();
	private JButton[][] buttons=new JButton[row][rowSeats];
	private final JButton[] buttonClicked = new JButton[200]; // This is the clicked JButton array
	private int k = 0; // this is the count for buttonClicked
	/**
	 * Construct a Reserve class that generate the User interface 
	 */
	public Reserve() {
		setTitle("Reserve Example");
		setSize(1200, 900);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		instructionPanel.setLayout(new BorderLayout());
		rowPanel.setLayout(new GridLayout(51,1,2,2));
		seatsPanel.setLayout(new GridLayout(51,4,2,2));
		JLabel rowSeat = new JLabel("Row   ");
		rowPanel.add(rowSeat);
		JLabel A = new JLabel("A");
		JLabel B = new JLabel("B");
		JLabel C = new JLabel("C");
		JLabel D = new JLabel("D");
		JLabel space = new JLabel(" ");
		rowPanel.add(rowSeat);
		seatsPanel.add(A);
		seatsPanel.add(B);
		seatsPanel.add(space);
		seatsPanel.add(C);
		seatsPanel.add(D);
		JLabel start = new JLabel("Click to reserver your seats");
		start.setBorder(new LineBorder(Color.black));
		start.setFont(new Font(start.getName(),Font.BOLD,20));
		start.setPreferredSize(new Dimension(50,50));
		instructionPanel.add(start,BorderLayout.PAGE_START);
		for (int i =0; i < row; i ++){
			JLabel row = new JLabel((i+1) + "    ");
			rowPanel.add(row);
			for (int j = 0; j < rowSeats; j ++){
				buttons[i][j] = new JButton();
				buttons[i][j].setPreferredSize(new Dimension(40,40));
				buttons[i][j].addActionListener(new
						ActionListener(){
		    		 	public void actionPerformed(ActionEvent event){
		    		 		JButton clicked = (JButton) event.getSource();
		    		 		//If a blank button is clicked,add it to the buttonClicked array
		    		 		if (clicked.getText() == ""){
		    		 			buttonClicked[k] = clicked;
		    		 			k++;
		    		 		}  			 
		    		 	}
				});
				if (j%4 == 2){
					seatsPanel.add(Box.createRigidArea(new Dimension(10,10)));
				}	
				seatsPanel.add(buttons[i][j]);
			}
		}
		add(instructionPanel,BorderLayout.NORTH);
		add(seatsPanel,BorderLayout.CENTER);
		add(rowPanel,BorderLayout.WEST);
		setVisible(true);
		}
	 
	/**
	 * Returns the JButton 2D array of the GUI 
	 * @return JButton 2D array
	 */
	public JButton[][] getJButtons(){
		return buttons;
		}
	
	/**
	 * Returns the number of buttons clicked
	 * @return count of Clicked buttons
	 */
	public int countOfButtonsClicked(){
		return k;
	}
	
	/**
	 * Returns the clicked JButton array
	 * @return an array of clicked JButton
	 */
	public JButton[] getButtonsClicked(){
		return buttonClicked;
	}

}