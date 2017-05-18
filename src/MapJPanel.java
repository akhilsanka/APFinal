import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MapJPanel extends JPanel implements KeyListener, ActionListener
{
	Main m;
	
	public MapJPanel(Main m)
	{
		super(new GridBagLayout());
		
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
	
}
