package ca.utoronto.utm.jugpuzzle;

import java.awt.event.*;
import javax.swing.*;

/**
 * Class Listens to the GUI and responds accordingly to the buttons clicked
 *   
 */
public class JugActionListener implements ActionListener
{
	private JugPuzzle jugPuzzle;
	private JFrame frame;
	private boolean firstButtonClicked = false;
	private int firstJugClicked = -1;
	private Jug[] jug;
	
	JugActionListener(JugPuzzle jugPuzzle, JFrame frame) {
		this.frame = frame;
		this.jugPuzzle=jugPuzzle;
		this.jug = new Jug[3];
		for(int x=0; x<3 ; x++) //Can use a for loop as we used array
		{
			this.jug[x] = jugPuzzle.getJug(x);
		}
		System.out.println(jugPuzzle.toString());	
	}
	
	/**
	 * Performs task depending on what button is clicked
	 */
	public void actionPerformed(ActionEvent e) //can also be done just with integers like have integer be -1 when
	{										  //when the button isnt clicked

		if(e.getActionCommand() == "Jug 1")
		{
			if(firstButtonClicked == false)
			{
				firstButtonClicked = true;
				firstJugClicked = 0;
			}
			else
			{
				firstButtonClicked = false;
				jugPuzzle.move(firstJugClicked, 0);
				System.out.println(jugPuzzle.toString());	
			}
			
		}
		else if(e.getActionCommand() == "Jug 2")
		{
			
			if(firstButtonClicked == false)
			{
				firstButtonClicked = true;
				firstJugClicked = 1;
			}
			else
			{
				firstButtonClicked = false;
				jugPuzzle.move(firstJugClicked, 1);
				System.out.println(jugPuzzle.toString());	
			}
			
		}
		else if(e.getActionCommand() == "Jug 3")
		{
			
			if(firstButtonClicked == false)
			{
				firstButtonClicked = true;
				firstJugClicked = 2;
			}
			else
			{
				firstButtonClicked = false;
				jugPuzzle.move(firstJugClicked, 2);
				System.out.println(jugPuzzle.toString());
			}
			
		}
		
		
		else if(e.getActionCommand() == "Reset")
		{
			jugPuzzle.resetGame();
			System.out.println("Game Reset");
			System.out.println(jugPuzzle.toString());
			firstButtonClicked = false;
		}
		else if(e.getActionCommand() == "Shutdown")
		{
			System.exit(0);
		}
		//This is seperated from the rest as when the move happens then it can check right away if game is solved
		if (jugPuzzle.getIsPuzzleSolved())
		{
			frame.setVisible(false);
			System.out.println("Congrats you won the game in " + jugPuzzle.getMoves() +" Moves!");
			JugPuzzleGUIController winning = new JugPuzzleGUIController();
			int restartOrShutdown = winning.winningMessage(jugPuzzle.getMoves());
			if(restartOrShutdown == 1)
			{
				jugPuzzle.resetGame();
				System.out.println(jugPuzzle.toString());
				frame.setVisible(true);
			}
			else
			{
				System.exit(0);
			}	
		}		
	}	
}