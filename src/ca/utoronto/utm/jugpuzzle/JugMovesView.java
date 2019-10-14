package ca.utoronto.utm.jugpuzzle;

import java.util.*;

import javax.swing.JLabel;
/**
 * Changes the JLabel Class to show the Number of Moves
 * 
 *
 */
public class JugMovesView extends JLabel implements Observer 
{
	@Override
	public void update(Observable o, Object arg) {
		JugPuzzle current = (JugPuzzle)o;
		this.setText("Moves: " + current.getMoves());	  
		this.setHorizontalAlignment(JLabel.CENTER);
	}
	

 
}