package ca.utoronto.utm.jugpuzzle;
import javax.swing.*;
import java.util.*;

/**
 * Changes the JLabel Class to show much a jug is filled up by.
 *
 */
public class JugNumericView extends JLabel implements Observer 
{
	@Override
	public void update(Observable o, Object arg) {
		Jug current = (Jug)o;
		this.setText("" + current.getAmount() + " of " + current.getCapacity());	  
		this.setHorizontalAlignment(JLabel.CENTER);
	}
	 


}