import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class OptionPanel extends JPanel implements ActionListener {
	
	private Main w;
	
	public OptionPanel(Main w) {
		this.w = w;
		JPanel p = new JPanel();
		
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		p.add(Box.createVerticalStrut(300));
		
		JButton button = new JButton("Make A New Race!");
		button.addActionListener(this);
		p.add(button);
		add(p);
		
		JButton button2 = new JButton("Start A Race!");
		button2.addActionListener(this);
		p.add(button2);
		add(p);
		
		JButton button3 = new JButton("Instructions!");
		button3.addActionListener(this);
		p.add(button3);
		add(p);
	}
	
	public void actionPerformed(ActionEvent e) {
		w.changePanel("2");
	}
	
}