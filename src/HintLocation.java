
import processing.core.*;

//this class is only used when maps are used 

public class HintLocation {
	
	private static final int radius = 600;
	private int x, y; //coordinates of the center of the circle
	
	public HintLocation(int x, int y)
	{
		this.x = x;
		this.y = y;
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
