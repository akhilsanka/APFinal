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
	
	public TimerPanel()
	{

		startTime = System.currentTimeMillis();
		timePassed = 0;

	}


	public long getMins()
	{

		return ((System.currentTimeMillis() - startTime) + timePassed) / 60000 ;
	}
	
	public long getSeconds()
	{
		return (((System.currentTimeMillis() - startTime) + timePassed) % 60000) / 1000;
	}

	public void reset(){
		startTime = System.currentTimeMillis();
	}
	
	public void pause(){
		pauseStart = System.currentTimeMillis();
	}
	
	public void play(){
		timePassed = System.currentTimeMillis() - pauseStart;
	}
	
}
