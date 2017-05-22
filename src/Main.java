
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import java.awt.*;

public class Main extends JFrame {
	//test 
	JPanel cardPanel;
	ArrayList<Race> races = new ArrayList<Race>();
	private PlayGamePanel panel5;
	private MapJPanel map;
	InstructionPanel panel4;
	GamePanel panel2;
	MakeGamePanel panel3 ;
	OptionPanel panel1;
	//private Map map;
	
	public Main(String title) {
		super(title);
		addDummyRace();
		addDefaultRace();
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
	    map = new MapJPanel(this);
		panel1 = new OptionPanel(this);    
		panel3 = new MakeGamePanel(this);
		panel2 = new GamePanel(this);
	    panel4 = new InstructionPanel(this);
	    panel5 = new PlayGamePanel(this, panel2);
	    
	    
	    
	    
	    cardPanel.add(panel1,"1"); // Card is named "1"
	    //cardPanel.add(map, "1");
	    cardPanel.add(panel2,"2"); // Card is named "2"
	    cardPanel.add(panel3,"3");
	    cardPanel.add(panel5, "5");
	    cardPanel.add(panel4,"4");
	  
	    
	    
	    add(cardPanel);
	    addKeyListener(panel2);
	
	    setVisible(true);
	   
	}

	public static void main(String[] args)
	{
		Main w = new Main("Scavenger Hunt Game");
	}
  
	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel,name);
		requestFocus();
	}
	/**
	 * Adds a race to the list of races stored in the main method.
	 * @param r Race that is added to the list of races
	 */
	public void addRace(Race r)
	{
		races.add(r);
	}
	/**
	 * Adds a dummy race to the list of races to test.
	 */
	public void addDummyRace()
	{
		Race dummy = new Race("Dummy");
		Hint hint1 = new Hint("One", 1);
		Hint hint2 = new Hint("Two", 2);
		Hint hint3 = new Hint("Three", 3);
		dummy.addHint(hint1);
		dummy.addHint(hint2);
		dummy.addHint(hint3);
		addRace(dummy);
	}
	/**
	 * Adds a default race to test.
	 */
	public void addDefaultRace()
	{
		Race shelby = new Race("Shelby's Classroom");
		Hint h1 = new Hint("Location of Shelby's desk (one)", 1);
		Hint h2 = new Hint("You pick up the dinosaur at this location before going to the bathroom (three)", 3); 
		
		shelby.addHint(h1);
		shelby.addHint(h2);
		addRace(shelby);
	}
	/**
	 * @param name Name of the race to be returned
	 * @return Race that is asked to return
	 */
	public Race getRace(String name)
	{
		for(int i = 0; i < races.size(); i ++)
		{
			if(races.get(i).getName().equals(name))
			{
				return races.get(i);
			}
		}
		return null;
	}
	/**
	 * @return ArrayList of all the races stored in the main method
	 */
	public ArrayList<Race> getRaces()
	{
		return races;
	}
	/**
	 * 
	 * @param r Race that it will be set to
	 */
	public void setRace(Race r)
	{
		panel5.setRace(r);
	}
}