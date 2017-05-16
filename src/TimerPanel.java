import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JPanel;
import javax.swing.Timer;

public class TimerPanel extends JFrame implements ActionListener {
	
	private JLabel label;
	private Timer timer; 
	
	private int duration = 1000;
	private int counter = 10;
	
	private JButton pause, resume, restart;
	

	public TimerPanel()
	{
		super("Race Timer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		label = new JLabel("Your time: " + counter + " seconds", JLabel.CENTER);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
