import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;


public class OptionPanel extends JPanel implements ActionListener {
	
	private Main w;
	private JButton button, button2, button3, button4;
	
	public OptionPanel(Main w) {
		this.w = w;
		JPanel p = new JPanel();
		p.setBackground(new Color(0,0,0,0));  // Panel is transparent
		
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));	
		p.add(Box.createVerticalStrut(300));   // Move down by 300 pixels  
		
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
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		double ratioX = getWidth() / 800.0;
		double ratioY = getHeight() / 600.0;
		
		Graphics2D g2 = (Graphics2D)g;
		
		AffineTransform af = g2.getTransform();
		
		g2.scale(ratioX,ratioY);
		
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 45));
		g.drawString("Scavenger", 305, 200);
		g.drawString("Hunt", 350, 255);
		
		g2.setTransform(af);
	}
	
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
			w.getMap().makeRace();
		}
	}
	
}