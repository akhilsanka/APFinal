import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

/* map of Shelby's classroom
 * each rectangle would represent basic classroom layout
 * like the door, whiteboard, shelby's desk, each row of computers, etc
 * all of these would be labeled with numbers
 * numbers would be the answers to the hint
 */
public class Map extends PApplet {
	
	private Main main;
	ArrayList<Hint> hints;
	String name;
	PImage hhs;

	PlayGamePanel pgPanel;
	
	/**
	 * 
	 * @param n String name of Map
	 * @param locations ArrayList of HintLocations that correspond with Hints
	 */
	public Map(String n, ArrayList<Hint> h, Main m)
	{
		super();
		
		name = n;
		this.hints = h;
		main = m;
		
		pgPanel = new PlayGamePanel(m);
	}
	
	public void setup()
	{
		hhs = loadImage("Homestead Map.jpg");
	}
	
	public void draw(int index) //index of the hint to be drawn
	{
		background(hhs);
		clear(); 
		
		if(hints.size() != 0)
		{
			int x = hints.get(index).getHintLoc().getX();
			int y = hints.get(index).getHintLoc().getY();
			int radius = hints.get(index).getHintLoc().getRad();
			
			ellipse(x, y, radius, radius);
		}
		
		/*
		int i = 0;
		while(hints.size() != 0) //draws all the hint circles...
		{
			int x = hints.get(i).getHintLoc().getX();
			int y = hints.get(i).getHintLoc().getY();
			int radius = hints.get(i).getHintLoc().getRad();
			
			ellipse(x, y, radius, radius);
		}
		*/
		
	}

}
