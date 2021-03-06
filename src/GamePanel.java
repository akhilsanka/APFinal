
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

import java.util.*;


public class GamePanel extends JPanel implements KeyListener, ActionListener
{
	private Main m;

	protected JTextField nameField;
	String nameText;
	
	private TimerPanel tp;
	
	protected JTextField hintField;
	protected JTextField answerField;
	protected JTextArea hintArea;
	protected JTextArea answerArea;
	private JButton mapGame;
	private JButton shelbyGame;
	
	private JButton game;
	private JButton home;
	/**
	 * Makes a PlayGamePanel object that allows the user to select which game they want to play
	 * @param m Main Class
	 */
	public GamePanel (Main m) {
		
		super(new GridBagLayout());
		
		tp = new TimerPanel();
		
		this.m = m;
		setBackground(Color.WHITE);
		GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;
        nameField = new JTextField(20);
		game = new JButton("Enter this Race");
		home = new JButton("Return to home screen");
		mapGame = new JButton("Play Homestead Map Game");
		shelbyGame = new JButton("Play A211 Game");
		
		mapGame.addActionListener(this);
		shelbyGame.addActionListener(this);
		nameField.addActionListener(this);
		game.addActionListener(this);
		home.addActionListener(this);
		add(nameField, c);
		add(game, c);
		add(mapGame, c);
		add(shelbyGame, c);
		add(home, c);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * Changes the panel based on what button is pressed
	 */
	public void actionPerformed(ActionEvent e) {
		nameText = nameField.getText();
		Object chooseB = e.getSource();
		if(chooseB == game){
			FileIO reader = new FileIO();
			if((Race)reader.readObject(nameText + ".sch") == null){
				msgbox("Race not found");
			}
			else{
				Race race = (Race)reader.readObject(nameText + ".sch");
				m.setRace(race);
				m.changePanel("5");
				tp.reset();
			}
		}
		if(chooseB == home)
			m.changePanel("1");
		if(chooseB == shelbyGame)
		{
			FileIO reader = new FileIO();
			if((Race)reader.readObject("A211Race.sch") == null){
				msgbox("Race not found");
			}
			else{
				Race race = (Race)reader.readObject("A211Race.sch");
				m.setRace(race);
				m.changePanel("5");
				tp.reset();
			}
		}
		if(chooseB == mapGame)
		{
			FileIO reader = new FileIO();
			if((Race)reader.readObject("HomesteadMapRace.sch") == null){
				msgbox("Race not found");
			}
			else{
				Race race = (Race)reader.readObject("HomesteadMapRace.sch");
				m.setRace(race);
				m.changePanel("5");
				tp.reset();
			}
		}
	}
	
	/**
	 * 
	 * @return long value of the minutes passed
	 */
	public long getMins(){
		return tp.getMins();
	}
	
	/**
	 * 
	 * @return long value of the seconds, after each minute, that has passed
	 */
	public long getSeconds(){
		return tp.getSeconds();

	}
	/**
	 * 
	 * @return timerPanel object
	 */
	public TimerPanel getTimer(){
		return tp;
	}
	
	
	/**
	 * 
	 * @return String of the Race's name
	 */
	public String getRaceName(){
		return nameText;
		
	}

	/**
	 * Creates a popup window containing String passed in
	 * @param s String to be displayed in popup window
	 */
	public void msgbox(String s){
		   JOptionPane.showMessageDialog(null, s);
		}


}
