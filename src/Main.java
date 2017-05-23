
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import java.awt.*;

public class Main extends JFrame {
	JPanel cardPanel;
	ArrayList<Race> races = new ArrayList<Race>();
	private PlayGamePanel panel5;
	private InstructionPanel panel4;
	private GamePanel panel2;
	private MakeGamePanel panel3 ;
	private OptionPanel panel1;
	private JScrollPane mapScrollPanel;
	private JScrollPane gameScrollPanel;
	private MapJPanel map;
	

	public Main(String title) {
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
		panel1 = new OptionPanel(this);    
		panel3 = new MakeGamePanel(this);
		panel2 = new GamePanel(this);
	    panel4 = new InstructionPanel(this);
	    panel5 = new PlayGamePanel(this, panel2);
	    map = new MapJPanel(this);
	    mapScrollPanel = new JScrollPane(map);
	    gameScrollPanel = new JScrollPane(panel5);
	    
	    
	    cardPanel.add(panel1,"1"); 
	    cardPanel.add(panel2,"2"); 
	    cardPanel.add(panel3, "3");
	    cardPanel.add(gameScrollPanel, "5");
	    cardPanel.add(panel4,"4");
	    cardPanel.add(mapScrollPanel, "6");
	    
	    add(cardPanel);
	    addKeyListener(panel2);
	    setVisible(true);  
	}

	public static void main(String[] args)
	{
		Main w = new Main("Scavenger Hunt Game");
	}
	/**
	 * Changes the JPanel that the user is viewing
	 * @param name corresponds to the different JPanels in the GUI
	 */
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
	
	public MapJPanel getMap()
	{
		return map;
	}
	
}