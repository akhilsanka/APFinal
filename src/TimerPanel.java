import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JPanel;
import javax.swing.Timer;

public class TimerPanel {

	private long startTime;
	private long pauseStart;
	private long timePassed;
	
	/**
	 * Constructs a TimerPanel object, starts the time 
	 */
	public TimerPanel()
	{

		startTime = System.currentTimeMillis();
		timePassed = 0;

	}

	/**
	 * 
	 * @return long value of the number of minutes that has passed
	 */
	public long getMins()
	{

		return ((System.currentTimeMillis() - startTime) - timePassed) / 60000 ;
	}
	
	/**
	 * 
	 * @return long value of the number of seconds that has passed 
	 */
	public long getSeconds()
	{
		return (((System.currentTimeMillis() - startTime) - timePassed) % 60000) / 1000;
	}

	/**
	 * Stops the timer and resets it to 0
	 */
	public void reset(){
		startTime = System.currentTimeMillis();
	}
	/**
	 * Pauses the timer
	 */
	public void pause(){
		pauseStart = System.currentTimeMillis();
	}
	/**
	 * Starts the timer after it has been paused
	 */
	public void play(){
		timePassed = System.currentTimeMillis() - pauseStart;
	}
	
}
