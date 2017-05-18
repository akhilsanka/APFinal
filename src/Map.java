import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import processing.core.PApplet;

/* map of Shelby's classroom
 * each rectangle would represent basic classroom layout
 * like the door, whiteboard, shelby's desk, each row of computers, etc
 * all of these would be labeled with numbers
 * numbers would be the answers to the hint
 */
public class Map extends PApplet implements MouseListener{
	
	ArrayList<Hint> hints;
	String name;
	
	/**
	 * 
	 * @param n String name of Map
	 * @param locations ArrayList of HintLocations that correspond with Hints
	 */
	public Map(String n, ArrayList<Hint> h) //ArrayList of unused hints
	{ 
		super();
		
		name = n;
		this.hints = h;
	}
	
	public void draw()
	{
		background(0, 255, 255);
		
		int i = 0;
		while(hints.size() != 0) //draws all the hint circles...
		{
			int x = hints.get(i).getHintLoc().getX();
			int y = hints.get(i).getHintLoc().getY();
			int radius = hints.get(i).getHintLoc().getRad();
			
			ellipse(x, y, radius, radius);
		}
		
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
