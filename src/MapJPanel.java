import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MapJPanel extends JPanel implements MouseListener, KeyListener, ActionListener
{
	Main m;
	ArrayList<Point> hintLocationPoints;
	
	public MapJPanel(Main m)
	{
		super(new GridBagLayout());
		
		hintLocationPoints = new ArrayList<Point>();
		
		GridBagConstraints c = new GridBagConstraints();
	    c.gridwidth = GridBagConstraints.REMAINDER;
	    c.fill = GridBagConstraints.HORIZONTAL;
		this.m = m;
		ImageIcon icon = new ImageIcon("HomesteadMap.jpg"); 
		JLabel thumb = new JLabel();
		thumb.setIcon(icon);
		add(thumb, c);
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		//g.drawImage(w, 0,0, getWidth(), getHeight(), null );
		Image background = Toolkit.getDefaultToolkit().createImage("HomesteadMap.jpg");
		g.drawImage(background, 0, 0, null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		Point hintPoint = arg0.getLocationOnScreen();
		hintLocationPoints.add(hintPoint);
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
	
}
