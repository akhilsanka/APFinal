
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import java.awt.*;

public class Main extends JFrame {
	//test 
	JPanel cardPanel;
	ArrayList<Race> races = new ArrayList<Race>();
	private GamePanel panel5;
	
	public Main(String title) {
		super(title);
		addDummyRace();
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
		OptionPanel panel1 = new OptionPanel(this);    
	    PlayGamePanel panel2 = new PlayGamePanel(this);
	    MakeGamePanel panel3 = new MakeGamePanel(this);
	    InstructionPanel panel4 = new InstructionPanel(this);
	    panel5 = new GamePanel(this);
	    
	    cardPanel.add(panel1,"1"); // Card is named "1"
	    cardPanel.add(panel2,"2"); // Card is named "2"
	    cardPanel.add(panel3,"3");
	    cardPanel.add(panel4,"4");
	    cardPanel.add(panel5, "5");
	    
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
	
	public void addRace(Race r)
	{
		races.add(r);
	}
  
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
	
	public ArrayList<Race> getRaces()
	{
		return races;
	}
	
	public void setRace(Race r)
	{
		panel5.setRace(r);
	}
}