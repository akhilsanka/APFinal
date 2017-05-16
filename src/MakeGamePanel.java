
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

import java.util.*;


public class MakeGamePanel extends JPanel implements KeyListener, ActionListener
{
	private Main m;
	protected JTextField nameField;
	private String nameText;
	protected JTextArea hintArea;
	protected JTextArea answerArea;
	protected JButton create;
	private Race createdRace;
	private final static String newline = "\n";
	
	private Race r;
	private ArrayList<Hint> hintList = new ArrayList<Hint>();
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
		//JLabel hint = new JLabel("Enter Hint: ");
		//JLabel answer = new JLabel("Enter Answer: ");
		JLabel yourHints = new JLabel("The First Box Contains Your Hints And The Second Box Contains Corresponding Hints");
		//addToArray = new JButton("Add Entered Hints and Answers To Race");
		//create = new JButton("Create Race");
		nameField = new JTextField(20);
		//hintField = new JTextField(20);
		//answerField = new JTextField(20);
		
		nameField.addActionListener(this);
		//hintField.addActionListener(this);
		//answerField.addActionListener(this);
		//addToArray.addActionListener(this);
		//create.addActionListener(this);
 
		hintArea = new JTextArea(10, 20);
		hintArea.setEditable(true);
        JScrollPane scrollPane = new JScrollPane(hintArea);
        
        answerArea = new JTextArea(10, 20);
		answerArea.setEditable(true);
        JScrollPane scrollPane2 = new JScrollPane(answerArea);
 
        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
 
        c.fill = GridBagConstraints.HORIZONTAL;
        add(name, c);
        add(nameField, c);
        //add(create, c);
        //add(hint, c);
        //add(hintField, c);
        //add(answer, c);
        //add(answerField, c);
       // add(finish, c);
        add(yourHints, c);
        
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);
        add(scrollPane2, c);
        //add(answers, c);
       // p.add(addToArray, c);
        
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
			//String raceName = nameField.getText();
			//Race createdRace = new Race(raceName);
			System.out.println("button pressed");
			String clues[] = hintArea.getText().split("\\r?\\n");
		    ArrayList<String>hintList = new ArrayList<String>(Arrays.asList(clues));
		    ArrayList<Hint> hints = new ArrayList<Hint>();
		    System.out.println(hintList);
		    
		    String answers[] = answerArea.getText().split("\\r?\\n");
		    ArrayList<String>answerList = new ArrayList<>(Arrays.asList(answers)) ;
		    System.out.println(answerList);
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
		    			return; //correct? 
		    		}
		    		hints.add(temp);
		    	}
		    	createdRace = new Race(nameField.getText(), hints);
		    	m.addRace(createdRace);
		    	FileIO writer = new FileIO();
				writer.writeObject(nameField.getText() + ".sch", r);
		    }
		}
		/*else if(chooseB == create)
		{
			createdRace = new Race(nameField.getText());
			m.addRace(createdRace);
		}*/
		else
		{
			/*//String hintText = hintField.getText();
	        hintArea.append(hintText + newline);
	       // hintField.selectAll();
	        
	        String answerText = "";
	        try
	        {
		        answerText = answerField.getText();
		        Integer.parseInt(answerText);
		        answerArea.append(answerText + newline);
	        }
	        catch(NumberFormatException ex)
	        {
	        	msgbox("Invalid input, please change input to a number: ");
	        }
	        answerField.selectAll();
	 
	        //Make sure the new text is visible, even if there
	        //was a selection in the text area.
	        hintArea.setCaretPosition(hintArea.getDocument().getLength());
	        answerArea.setCaretPosition(answerArea.getDocument().getLength());*/
		}

		if (chooseB == home){
			//hintList.trimToSize();
			//r = new Race(nameText, hintList);	
			
			//FileIO writer = new FileIO();
			//writer.writeObject(nameText + ".sch", r);
			
			m.changePanel("1");
		}
		
        //Make sure the new text is visible, even if there
        //was a selection in the text area.
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
