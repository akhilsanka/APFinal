
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

import java.util.*;




public class InstructionPanel extends JPanel implements KeyListener, ActionListener {


	private String message;
	private Main m;
	private JButton home;
	
	protected JTextArea instructionArea;


	/**
	 * This constructor makes a panel that shows the instructions.
	 * 
	 * @param m the main class
	 */
	public InstructionPanel (Main m) {
		super();
		this.m = m;
		setBackground(Color.WHITE);
		message = "To make a Scavenger Hunt click the make game button with locations \nor without."
				+ " If you are making a Scavenger Hunt without locations \nenter the name in the first"
				+ "text box and all hints and answers into \ntheir respective textboxes, then press the "
				+ "finish making race button to \nmake the race."
				+ " If you are making a Scavenger Hunt with locations enter the \nname of the race into"
				+ "the popup window that appears right after clicking the \nmake race with locations"
				+ " button. Then add hints by clicking the spot on the \nimage that contains the location "
				+ "you want the hint to be located at. Next, \nenter the hints and answers in their"
				+ "respective places in the popup window."
				+ "\n\n To play a race, click the play race button and enter the name of the race \nyou"
				+ " want to play. If the screen does not change, try to enter a different race. \nWhen the"
				+ " race starts, see the hint that shows up in the hint text box and \nthe general location"
				+ " of the answer if there are locations in the race. Enter \nyour number guess for the "
				+ "answer in the answer text box and click check \nanswer. If the answer is correct a "
				+ "new hint and location will appear.";
		instructionArea = new JTextArea(message, 30, 40);
		instructionArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(instructionArea);
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(scrollPane, c);
        
        home = new JButton("Return to home screen");
        home.addActionListener(this);
        add(home, c);
	}

	/** Paints to the screen of this panel
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
		g2.setTransform(at);
	}


	@Override
    /**  Checks to see if the user wants to go back
	* @param arg0  the key that is recorded by the program
	 */
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
		// TODO Auto-generated method stub
		Object chooseB = e.getSource();
		if(chooseB == home)
			m.changePanel("1");
	}


}

