
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Race extends JPanel implements Serializable{
		

	private static final long serialVersionUID = -1379850089802977302L;
	private ArrayList<Hint> unusedHints;
	private ArrayList<Hint> usedHints;
	private String name;
	private boolean isComplete, hasMap;
	
	/**
	 * This constructs a Race object with the race's name and 
	 * its ArrayList of Hint objects
	 * @param name String of the name of the race
	 * @param hints ArrayList of Hint objects that is custom to the race
	 */
	public Race(String name, ArrayList<Hint> hints )
	{
		unusedHints = hints;
		usedHints = new ArrayList<Hint>();
		isComplete = false;
		this.name = name;
		hasMap = false;
	}
	
	/**
	 * This constructs a Race object with the race's name
	 * @param name String of the name of the race
	 */
	public Race(String name)
	{
		this.name = name;
		unusedHints = new ArrayList<Hint>();
		usedHints = new ArrayList<Hint>();
		isComplete = false;
		
		hasMap = false;
	}
	
	/**
	 * @return This method returns the Race's name in a String
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * 
	 * @return return the next hint in the ArrayList of unused Hint objects.
	 * Then removes the hint from the unused ArrayList and adds it to the 
	 * ArrayList of used hints
	 */
	public Hint getHint()
	{
		if(unusedHints.size() == 0){
			isComplete = true;
			System.out.println("RACE IS COMPLETE!");
			return null;
		}
		
		int randHint;
		randHint = (int)Math.random()*unusedHints.size();
		Hint shuffledHint = unusedHints.get(randHint);
		usedHints.add(unusedHints.get(randHint));
		unusedHints.remove(randHint);	
		
		return shuffledHint;
	}
	
	/**
	 * 
	 * @param hint ArrayList of Strings that represent the String form of the hint
	 * @param answer ArrayList of Strings of the answers that correspond with each hint
	 */
	public void addHint(ArrayList<String> hint, ArrayList<String> answer)
	{
		if(hint.size() == 0 || answer.size() == 0)
		{
			msgbox("Enter an equal number of hints and answers!");
		}
		else if(hint.size() != answer.size())
		{
			msgbox("Enter an equal number of hints and answers!");
		}
		else
		{
			for(int i = 0; i < hint.size(); i++)
			{
				Hint newHint = new Hint(hint.get(i), Integer.parseInt(answer.get(i)));
				unusedHints.add(newHint);
			}
		}
		
	}
	
	/**
	 * 
	 * @param hint new Hint object to be added to the ArrayList of unused hints
	 */
	public void addHint(Hint hint)
	{
		unusedHints.add(hint);
	}
	
	/**
	 * 
	 * @param location the hint's location on the map stored as a HintLocation object
	 * @param hint String form of the hint to be added 
	 * @param answer int answer that corresponds with the hint to be added 
	 */
	public void addHint(Point location, String hint, int answer)
	{
		Hint newHint = new Hint(location, hint, answer);
		unusedHints.add(newHint);
		System.out.println("New Hint with location has been added");
		System.out.println("Number of Remaining Hints: " + unusedHints.size());
	}

	/**
	 * 
	 * @return true if the Race's hints have all been completed
	 */
	public boolean isFinished()
	{
		return isComplete;
	}
	
	/**
	 * 
	 * @return int number of hints that have been used up
	 */
	public int getFinishedHints()
	{
		return usedHints.size();
	}
	
	/**
	 * 
	 * @return int number of unused hints left
	 */
	public int getRemainingHints()
	{
		return unusedHints.size();
	}
	
	/**
	 * sets isComplete boolean to true
	 */
	public void finish()
	{
		isComplete = true;
	}
	
	public boolean hasMap()
	{
		return hasMap;
	}
	
	public void setMap()
	{
		hasMap = true;
	}
	
	public void msgbox(String s){
		   JOptionPane.showMessageDialog(null, s);
		}
}
