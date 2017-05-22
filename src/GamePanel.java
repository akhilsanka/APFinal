
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

import java.util.*;


public class GamePanel extends JPanel implements KeyListener, ActionListener
{
 // test 
	private String message;
	private Main m;

	protected JTextField nameField;
	String nameText;
	
	private TimerPanel tp;
	
	protected JTextField hintField;
	protected JTextField answerField;
	protected JTextArea hintArea;
	protected JTextArea answerArea;
	private final static String newline = "\n";
	
	private JButton button;
	private JButton game;
	private ArrayList<JButton> buttons;
	private ArrayList<Race> races;
	/**
	 * Makes a PlayGamePanel object that allows the user to select which game they want to play
	 * @param m Main Class
	 */
	public GamePanel (Main m) {
		
		super(new GridBagLayout());
		
		tp = new TimerPanel();
		JPanel p = new JPanel();
		
		this.m = m;
		setBackground(Color.WHITE);
		GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;
        nameField = new JTextField(20);
		game = new JButton("Enter this Race");
		nameField.addActionListener(this);
		game.addActionListener(this);
		add(nameField, c);
		add(game, c);
		
		races = m.getRaces();
		System.out.println((races.size()));
		buttons = new ArrayList<JButton>();
		for(int i = 0; i < races.size(); i++)
		{
			System.out.println("test");
			 button = new JButton(races.get(i).getName());
			button.addActionListener(this);
			add(button, c);
			buttons.add(button);
		}
	
	}

	/**
	 * 
	 */
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
				m.setRace((Race)reader.readObject(nameText + ".sch"));
				m.changePanel("5");
				tp.reset();
				System.out.println(tp.getSeconds());
				System.out.println("reset");
				
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
		System.out.println(tp.getSeconds());
		return tp.getSeconds();

	}
	
	
	/**
	 * 
	 * @return String of the Race's name
	 */
	public String getRaceName(){
		return nameText;
		
	}

	/**
	 * 
	 * @param s 
	 */
	public void msgbox(String s){
		   JOptionPane.showMessageDialog(null, s);
		}


}
