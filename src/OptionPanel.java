
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;


public class OptionPanel extends JPanel implements ActionListener {
	
	private Main w;
	private JButton button, button2, button3, button4;

	//test 
	/**
	 * Makes an OptionPanel object which displays the different options the user can make.
	 * @param w Main class
	 */
	public OptionPanel(Main w) {
		
		super();

		
		this.w = w;
		JPanel p = new JPanel();
		
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		p.add(Box.createVerticalStrut(300));
		
		button = new JButton("Make A New Race Without Locations!");
		button.addActionListener(this);
		p.add(button);
		add(p);
		
		button4 = new JButton("Make A New Race With Locations!");
		button4.addActionListener(this);
		p.add(button4);
		add(p);
		
		button2 = new JButton("Start A Race!");
		button2.addActionListener(this);
		p.add(button2);
		add(p);
		
		button3 = new JButton("Instructions!");
		button3.addActionListener(this);
		p.add(button3);
		add(p);
	}
	/**
	 * Changes the panel based on the button pressed
	 */
	public void actionPerformed(ActionEvent e) {
		Object chooseB = e.getSource();
		if (chooseB == button){
			w.changePanel("3");
		}
		else if (chooseB == button2){
			w.changePanel("2");
		}
		else if (chooseB == button3){
			w.changePanel("4");
		}
		else if(chooseB == button4)
		{
			w.changePanel("6");
			//w.getMap().makeRace();
		}
		
	}
	
}