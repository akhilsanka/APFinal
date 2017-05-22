
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
		nameField.addActionListener(this);
		game.addActionListener(this);
		home.addActionListener(this);
		add(nameField, c);
		add(game, c);
		add(home, c);
	}


	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background

		Graphics2D g2 = (Graphics2D)g;

		int width = getWidth();
		int height = getHeight();

		double ratioX = (double)width/800.0;
		double ratioY = (double)height/600.0;

		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);

		g.setColor(Color.BLACK);
		g.setFont(new Font("SansSerif",Font.BOLD,28));
		g2.setTransform(at);
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
				System.out.println("TEST");
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
	}
	
	public long getMins(){
		return tp.getMins();
	}
	
	public long getSeconds(){
		return tp.getSeconds();

	}
	
	
	
	public String getRaceName(){
		return nameText;
		
	}

	public void msgbox(String s){
		   JOptionPane.showMessageDialog(null, s);
		}


}
