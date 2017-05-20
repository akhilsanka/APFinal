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

public class MapJPanelPlay extends JPanel implements MouseListener, KeyListener, ActionListener
{
	private Main m;
	private ArrayList<Point> hintLocationPoints;
	private boolean showLoc;
	
	public MapJPanelPlay(Main m)
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
	
	public MapJPanelPlay(Main m, boolean show)
	{
		super(new GridBagLayout());
		
		showLoc = show;
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
		
		if(showLoc){
			//draw all circles here
		}
		Image background = Toolkit.getDefaultToolkit().createImage("HomesteadMap.jpg");
		g.drawImage(background, 0, 0, null);
		for(int i = 0; i < hintLocationPoints.size(); i++){
			g.drawOval((int)hintLocationPoints.get(i).getX(), (int)hintLocationPoints.get(i).getY(), 5, 5);
		}
		repaint();

	}
	
	
	
	
	public ArrayList<Point> getHintLocationPoints(){
		return hintLocationPoints;
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
		System.out.println("aksdjf;");
		// TODO Auto-generated method stub
		Point hintPoint = arg0.getLocationOnScreen();
		hintLocationPoints.add(hintPoint);
		System.out.println(hintPoint);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
