
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

import java.util.*;


public class MakeGamePanel extends JPanel implements KeyListener, ActionListener
{
 // test 
	private String message;
	private Main m;
	protected JTextField nameField;
	protected JTextField hintField;
	protected JTextField answerField;
	protected JTextArea hintArea;
	protected JTextArea answerArea;
	protected JButton addToArray;
	private final static String newline = "\n";

	public MakeGamePanel (Main m) {
		super(new GridBagLayout());
		this.m = m;
		setBackground(Color.WHITE);
		
		JLabel name = new JLabel("Enter Name: ");
		JLabel hint = new JLabel("Enter Hint: ");
		JLabel answer = new JLabel("Enter Answer: ");
		JLabel finish = new JLabel("Press Finish Button To Add Entered Hints And Answers To Race!");
		addToArray = new JButton("Finish");
		nameField = new JTextField(20);
		hintField = new JTextField(20);
		answerField = new JTextField(20);
		
		nameField.addActionListener(this);
		hintField.addActionListener(this);
		answerField.addActionListener(this);
		addToArray.addActionListener(this);
 
		hintArea = new JTextArea(5, 20);
		hintArea.setEditable(true);
        JScrollPane scrollPane = new JScrollPane(hintArea);
        
        answerArea = new JTextArea(5, 20);
		answerArea.setEditable(true);
        JScrollPane scrollPane2 = new JScrollPane(answerArea);
 
        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        //c.gridwidth = 100;
 
        c.fill = GridBagConstraints.HORIZONTAL;
        add(name, c);
        add(nameField, c);
        add(hint, c);
        add(hintField, c);
        add(answer, c);
        add(answerField, c);
 
        add(finish, c);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);
        add(scrollPane2, c);
        add(addToArray, c);
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
		if (arg0.getKeyCode() == KeyEvent.VK_ESCAPE) {
			m.changePanel("1");
		}
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
		if (chooseB == addToArray){
			String raceName = nameField.getText();
			Race createdRace = new Race(raceName);
			System.out.println("button pressed");
			String hints[] = hintArea.getText().split("\\r?\\n");
		    ArrayList<String>hintList = new ArrayList<>(Arrays.asList(hints)) ;
		    System.out.println(hintList);
		    
		    String answers[] = answerArea.getText().split("\\r?\\n");
		    ArrayList<String>answerList = new ArrayList<>(Arrays.asList(answers)) ;
		    System.out.println(answerList);
		    
		    createdRace.addHint(hintList, answerList);
		}
		else
		{
			String hintText = hintField.getText();
	        hintArea.append(hintText + newline);
	        hintField.selectAll();
	        
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
	        answerArea.setCaretPosition(answerArea.getDocument().getLength());
		}
	}
	
	private void msgbox(String s){
		   JOptionPane.showMessageDialog(null, s);
		}


}
