import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JPanel;
import javax.swing.Timer;

public class TimerPanel extends JFrame implements ActionListener {
	
	private JLabel label;
	private JPanel panel, buttonPanel;
	private Timer timer; 
	private JButton resume, pause, reset;
	
	private byte msec, sec;
	private short minutes; 

	public TimerPanel()
	{		
		msec = 0;
		sec = 0;
		minutes =  0;
		
		panel = new JPanel();
		label = new JLabel("Your time: " + minutes + ":" + sec + ":" + msec, JLabel.CENTER);
		panel.add(label);
		buttonPanel = new JPanel();
		
		resume = new JButton("RESUME");
		pause = new JButton("PAUSE");
		reset = new JButton("RESET");
		buttonPanel.add(resume);
		buttonPanel.add(pause);
		buttonPanel.add(reset);
		
		resume.addActionListener(this);
		pause.addActionListener(this);
		reset.addActionListener(this);
		
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("RESUME"))
		{
			timer.start();
		}
		
		if(e.getActionCommand().equals("PAUSE"))
		{
			timer.stop();
		}
		
		if(e.getActionCommand().equals("RESET"))
		{
			timer.restart();
			msec = 0;
			sec = 0;
			minutes = 0;
			
			label.setText("Your time: " + minutes + ":" + sec + ":" + msec);
		}
		
	}

}
