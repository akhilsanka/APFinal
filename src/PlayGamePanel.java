
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

import java.util.*;


public class PlayGamePanel extends JPanel implements KeyListener, ActionListener
{
 // test 
	private String message;
	private Main m;
	protected JTextField nameField;
	String nameText;
	protected JTextField hintField;
	protected JTextField answerField;
	protected JTextArea hintArea;
	protected JTextArea answerArea;
	private final static String newline = "\n";
	
	private Race r;
	private ArrayList<Hint> hintList = new ArrayList<Hint>();
	private JButton button;
	private JButton game;
	private ArrayList<JButton> buttons;
	private ArrayList<Race> races;
	/**
	 * Makes a PlayGamePanel object that allows the user to select which game they want to play
	 * @param m Main Class
	 */
	public PlayGamePanel (Main m) {
		
		super(new GridBagLayout());
		
		JPanel p = new JPanel();
		
		this.m = m;
		setBackground(Color.WHITE);
		GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;
		
		game = new JButton("Start Selected Race");
		game.addActionListener(this);
		
		
		races = m.getRaces();
		System.out.println((races.size()));
		buttons = new ArrayList<JButton>();
		for(int i = 0; i < races.size(); i++)
		{
			System.out.println("test");
			JButton button = new JButton(races.get(i).getName());
			button.addActionListener(this);
			add(button, c);
			buttons.add(button);
		}
		add(game, c);
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
		Object chooseB = e.getSource();
		Race playRace; 
		for(int i = 0; i < buttons.size(); i++)
		{
			if(chooseB == buttons.get(i))
			{
				m.changePanel("5");
				m.setRace(races.get(i));
			}
		}
	}


}
