import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MapJPanel extends JPanel implements MouseListener, KeyListener, ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Main m;
	private BufferedImage image;
	private JLabel picLabel;
	private JButton home;
	private Race createdRace;
	private String name;
	private ArrayList<Hint> hints;
	
	public MapJPanel(Main m)
	{
		super(new GridBagLayout());
		
		hints = new ArrayList<Hint>();
		GridBagConstraints c = new GridBagConstraints();
	    c.gridwidth = GridBagConstraints.REMAINDER;
	    c.fill = GridBagConstraints.HORIZONTAL;
	    
	    try {
			image = ImageIO.read(new File("HomesteadMap.jpg"));
			picLabel = new JLabel(new ImageIcon(image));
			picLabel.addMouseListener(this);
			add(picLabel, c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    home = new JButton("Return to home screen");
	    home.addActionListener(this);
	    add(home, c);
		this.m = m;
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object chooseB = e.getSource();
		if(chooseB == home)
		{
			m.changePanel("1");
			createdRace = new Race(name, hints);
			createdRace.setMap();
			m.addRace(createdRace);
	    	FileIO writer = new FileIO();
			writer.writeObject(name + ".sch", createdRace);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		Point hintPoint = arg0.getLocationOnScreen();
		addHint(hintPoint);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private void addHint(Point loc) {
        JTextField field1 = new JTextField("");
        JTextField field2 = new JTextField("");
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Hint:"));
        panel.add(field1);
        panel.add(new JLabel("Answer:"));
        panel.add(field2);
        int result = JOptionPane.showConfirmDialog(null, panel, "Test",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
        	try
        	{
        		int ans = Integer.parseInt( field2.getText());
        		Hint temp = new Hint(loc, field1.getText(), ans);
        		hints.add(temp);
        	}
        	catch(NumberFormatException ex)
        	{
        		msgbox("Invalid Input, Try Again");
        	}
        } 
        else
        {
            System.out.println("Cancelled");
        }
    }
	
	public void makeRace() {
        JTextField field1 = new JTextField("");
        field1.setEditable(true);
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Enter Name of Race: "));
        panel.add(field1);
        int result = JOptionPane.showConfirmDialog(null, panel, "Test",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) 
        {
        	name = field1.getText();
        } 
        else 
        {
            m.changePanel("1");
        }
    }
	
	public void msgbox(String s){
		   JOptionPane.showMessageDialog(null, s);
		}
}
