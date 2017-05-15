
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
		//add(p, c);
		//JLabel name = new JLabel("Please enter the name of the Scavenger Hunt you would like to play");
		
//		JLabel hint = new JLabel("Enter Hint(s): ");
//		JLabel answer = new JLabel("Enter Answer(s): ");
//		JLabel finish = new JLabel("Press Enter Key To Add Current Hints And Answers To Race!");
		
//		FileIO reader = new FileIO();
//		reader.readObject(nameText + ".sch", r);
//		
		
		/*nameField = new JTextField(20);
		hintField = new JTextField(20);
		answerField = new JTextField(20);
		
		nameField.addActionListener(this);
		hintField.addActionListener(this);
		answerField.addActionListener(this);

 
		hintArea = new JTextArea(5, 20);
		hintArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(hintArea);
        
        answerArea = new JTextArea(5, 20);
		answerArea.setEditable(false);
        JScrollPane scrollPane2 = new JScrollPane(answerArea);
        
        answerArea.append("Corresponding Answers: \n");
        hintArea.append("Your Hints: \n");
 
        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        //c.gridwidth = 100;
 
        c.fill = GridBagConstraints.HORIZONTAL;
        add(name, c);
        add(nameField, c);
        //add(hint, c);
        add(hintField, c);
        //add(answer, c);
        add(answerField, c);
 
        //add(finish, c);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);
        add(scrollPane2, c);
        
        
        button = new JButton("Finish Making Race!");
		button.addActionListener(this);
		p.add(button);
		add(p);*/
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
		//int strWidth = g.getFontMetrics().stringWidth(message);
		//g.drawString(message, 400-strWidth/2, 300);
		
		
		
		g2.setTransform(at);

		// TODO Add any custom drawings here
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


	@Override
	public void actionPerformed(ActionEvent e) {
		Object chooseB = e.getSource();
		Race playRace; 
		/*if (chooseB == button){
			hintList.trimToSize();
			r = new Race(nameText, hintList);	
			
			FileIO writer = new FileIO();
			writer.writeObject(nameText + ".sch", r);
			
			m.changePanel("1");
		}*/
		for(int i = 0; i < buttons.size(); i++)
		{
			if(chooseB == buttons.get(i))
			{
				m.changePanel("5");
				m.setRace(races.get(i));
			}
		}
		/*if(chooseB == game)
		{
			m.changePanel("5");
		}*/
		/*
		nameText = nameField.getText();
		String hintText = hintField.getText();
        hintArea.append(hintText + newline);
        hintField.selectAll();
        
        String answerText = answerField.getText();
        answerArea.append(answerText + newline);
        answerField.selectAll();
        Hint currentH = new Hint(hintText, Integer.parseInt(answerText));
        hintList.add(currentH);
        
        //Make sure the new text is visible, even if there
        //was a selection in the text area.
        hintArea.setCaretPosition(hintArea.getDocument().getLength());
        answerArea.setCaretPosition(answerArea.getDocument().getLength());*/
	}


}
