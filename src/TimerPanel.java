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
	
	public TimerPanel()
	{

		startTime = System.currentTimeMillis();

	}


	public long getMins()
	{

		return (System.currentTimeMillis() - startTime) / 60000 ;
	}
	
	public long getSeconds()
	{
		return ((System.currentTimeMillis() - startTime) % 60000) / 1000;
	}

}
