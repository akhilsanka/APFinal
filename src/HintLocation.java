
import java.awt.Point;

import processing.core.*;

//this class is only used when maps are used 

public class HintLocation {
	//private static final long serialVersionUID = 1L;
	private static final int radius = 600;
	private int x, y; //coordinates of the center of the circle
	
	public HintLocation(Point p)
	{
		this.x = (int) p.getX();
		this.y = (int) p.getY();
	}
	
	public void setX(int newX)
	{
		x = newX;
	}
	
	public void setY(int newY)
	{
		y = newY;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getRad()
	{
		return radius;
	}
	
}
