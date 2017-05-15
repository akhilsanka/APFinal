//import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import java.awt.Graphics;

/* map of Shelby's classroom
 * each rectangle would represent basic classroom layout
 * like the door, whiteboard, shelby's desk, each row of computers, etc
 * all of these would be labeled with numbers
 * numbers would be the answers to the hint
 */
public class Map extends JPanel implements MouseListener{
	
	
	
	public void paintComponent(Graphics g) 
	{ 
		super.paintComponent(g);
		
		//g.fillRect(x, y, width, height);
	}
	
	//method checks if click is in area
	public boolean inRect()
	{
		
		return false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
