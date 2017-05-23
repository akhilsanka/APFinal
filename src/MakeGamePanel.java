
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

import java.util.*;


public class MakeGamePanel extends JPanel implements KeyListener, ActionListener
{
	private Main m;
	protected JTextField nameField;
	protected JTextArea hintArea;
	protected JTextArea answerArea;
	protected JButton create;
	private Race createdRace;
	private JButton home;
	
	
	/**
	 * This constructor makes a panel where you can make scavenger hunts.
	 * 
	 * @param m the main class
	 */
	public MakeGamePanel (Main m) {
		
		super(new GridBagLayout());
		
		JPanel p = new JPanel(); 
				
		this.m = m;
		setBackground(Color.WHITE);
		
		JLabel name = new JLabel("Enter Name of Race: ");
		
		JLabel yourHints = new JLabel("The First Box Contains Your Hints And The Second Box Contains Corresponding Hints");
		nameField = new JTextField(20);
		nameField.addActionListener(this);
		hintArea = new JTextArea(10, 20);
		hintArea.setEditable(true);
        JScrollPane scrollPane = new JScrollPane(hintArea);       
        answerArea = new JTextArea(10, 20);
		answerArea.setEditable(true);
        JScrollPane scrollPane2 = new JScrollPane(answerArea);
 
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
 
        c.fill = GridBagConstraints.HORIZONTAL;
        add(name, c);
        add(nameField, c);
        add(yourHints, c);
        
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);
        add(scrollPane2, c);
        home = new JButton("Return to home screen");
        home.addActionListener(this);
        
        create = new JButton("Finish Making Race!");
		create.addActionListener(this);
		p.add(create);
		p.add(home);
		add(p);
	}

	/** Paints to the screen of MakeGamePanel
	 * @param g the Graphics class used to paint to the screen
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
		int strWidth = g.getFontMetrics().stringWidth("test");
		g.drawString("test", 400-strWidth/2, 300);
		
		
		
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


	@Override
	/** Checks the user input for adding hints and answers to the scavenger hunt.
	 * 
	 * @param e the action that is recorded by the program
	 */
	public void actionPerformed(ActionEvent e) {
		Object chooseB = e.getSource();
		if (chooseB == create){
			String clues[] = hintArea.getText().split("\\r?\\n");
		    ArrayList<String>hintList = new ArrayList<String>(Arrays.asList(clues));
		    ArrayList<Hint> hints = new ArrayList<Hint>();
		    
		    String answers[] = answerArea.getText().split("\\r?\\n");
		    ArrayList<String>answerList = new ArrayList<>(Arrays.asList(answers)) ;
		    if(answers.length == 0)
		    	msgbox("Please enter a value for the answer before clicking finish");
		    else if(clues.length == 0)
		    	msgbox("Please enter a value for the hint before clicking finish");
		    else if(answers.length != clues.length)
		    {
		    	msgbox("Please enter the same number of hints and answers");
		    }
		    else
		    {
		    	for(int i = 0; i < hintList.size(); i++)
		    	{
		    		Hint temp;
		    		try
		    		{
		    			temp = new Hint(hintList.get(i), Integer.parseInt(answerList.get(i)));
		    		}
		    		catch(NumberFormatException ex)
		    		{
		    			msgbox("Please enter only numbers for answers");
		    			return; 
		    		}
		    		hints.add(temp);
		    	}
		    	createdRace = new Race(nameField.getText(), hints);
		    	m.addRace(createdRace);
		    	FileIO writer = new FileIO();
				writer.writeObject(nameField.getText() + ".sch", createdRace);
		    }
		}

		if (chooseB == home){
			m.changePanel("1");
		}
        hintArea.setCaretPosition(hintArea.getDocument().getLength());
        answerArea.setCaretPosition(answerArea.getDocument().getLength());

	}
	
	
	/** Displays a pop up box
	 * 
	 * @param s the string to be shown
	 */
	public void msgbox(String s){
		   JOptionPane.showMessageDialog(null, s);
		}


}
