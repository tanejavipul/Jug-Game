package ca.utoronto.utm.jugpuzzle;

import javax.swing.*;
import java.awt.*;
/**
 * Method creates the frame and hooks the view to the model and displays it on the frame
 * 
 * 
 */
public class JugPuzzleGUIController
{
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	/**
	 * Creates the frame and hooks the view to the model
	 * 
	 * 
	 */
	public static void createAndShowGUI()  {
		// Create and hook up the Model, View and the controller
		
		// View
		JugMovesView guiViewMoves = new JugMovesView();
		JugProgressBarView[] guiViewBar = new JugProgressBarView[3];
		JugNumericView[] guiViewJug = new JugNumericView[3];
		for(int x=0; x<3 ; x++) //Can use a for loop as we used array
		{
			guiViewBar[x] = new JugProgressBarView();
			guiViewJug[x] = new JugNumericView();
		}
		
		// Model
		JugPuzzle model = new JugPuzzle();
		
		// Hook the model to the view. Can use a for loop as we used array
		for(int x=0; x<3 ; x++)
		{
			model.getJug(x).addObserver(guiViewBar[x]);
			model.getJug(x).addObserver(guiViewJug[x]);
		}
		model.addObserver(guiViewMoves);
				
		// Create the GUI controller to control the Model
		JFrame frame = new JFrame("Jug Game"); 
		
		// What happens when we close the JFrame...
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Layout components in a grid, 4 rows and 3 columns
		frame.getContentPane().setLayout(new GridLayout(4,3)); 
		
		JButton[] jugButton = new JButton[3]; // Two reference to JButton, no buttons exist yet!!
		JButton resetButton, shutdownButton;
		
		// Create the buttons 
		jugButton[0] = new JButton("Jug 1");
		jugButton[1] = new JButton("Jug 2");
		jugButton[2] = new JButton("Jug 3");
		resetButton =  new JButton("Reset");
		shutdownButton = new JButton("Shutdown");
		

		// add them to the contentPane
		frame.getContentPane().add(guiViewBar[0]);
		frame.getContentPane().add(guiViewBar[1]);
		frame.getContentPane().add(guiViewBar[2]);
		frame.getContentPane().add(jugButton[0]);
		frame.getContentPane().add(jugButton[1]);
		frame.getContentPane().add(jugButton[2]);
		frame.getContentPane().add(guiViewJug[0]); 
		frame.getContentPane().add(guiViewJug[1]);
		frame.getContentPane().add(guiViewJug[2]);
		frame.getContentPane().add(guiViewMoves);
		frame.getContentPane().add(resetButton);
		frame.getContentPane().add(shutdownButton);
		
		
		// Create button press event handlers
		JugActionListener pressed = new JugActionListener(model, frame);

		// Tell the buttons who they should call when they are pressed.
		// That is, hook up the controller to the Model.
		jugButton[0].addActionListener(pressed);
		jugButton[1].addActionListener(pressed);
		jugButton[2].addActionListener(pressed);
		resetButton.addActionListener(pressed);
		shutdownButton.addActionListener(pressed);
	
		// tell the frame to pack in all the components
		// this is done according to the layout manager
		frame.pack();

		//Shows the frame
		frame.setVisible(true);
		
	
	}

	/**
	 * This method displays a message after the game is won with total moves and some options
	 * @param moves		Takes number of moves the player took to complete the game
	 * @return Returns  What option (button) the player selected
	 */
	public int winningMessage(int moves)  
	{
		//make a new frame for the winning window
		JFrame frame = new JFrame();
		// 2 buttons
		Object[] options = {"Shutdown",
        "New Game?"};
		//get the button index that is choosed
		int x = JOptionPane.showOptionDialog(frame,
				"Congrats You Completed the Game in " + moves + " Moves!",
				"CONGRATULATIONS YOU WON!!", 
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,    
				options,  
				options[0]); 
		return x;
		
		
	}
	
	
	
	

}
