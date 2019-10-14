package ca.utoronto.utm.jugpuzzle;

import java.util.*;
import javax.swing.*;
import javax.swing.plaf.*;

/**
 * Changes the JProgressBar Class to show much a jug is filled up by.
 * 
 *
 */
public class JugProgressBarView extends JProgressBar implements Observer 
{
	@Override
	public void update(Observable o, Object arg) {
		Jug current = (Jug)o;
		//this.setOrientation(SwingConstants.VERTICAL); // To have the bars vertical but choose to have them horizontal
		this.setMaximum(current.getCapacity());
		this.setValue(current.getAmount());
		this.setStringPainted(true);
		this.setString("" +current.getAmount());
	}

}
