
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

import java.util.*;




public class InstructionPanel extends JPanel implements KeyListener {


	private String message;
	private Main m;
	
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
		message = "To play a scavenger hunt, run the program and click Play. Enter a code tofasldkfasdf asdjf ;askdfj a;slkdfja;skdfja;skdfjasfk;";
		instructionArea =new JTextArea(90, 70);
		instructionArea.append(message);
		instructionArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(instructionArea);
        add(scrollPane);
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
		//int strWidth = g.getFontMetrics().stringWidth(message);
		//g.drawString(message, 400-strWidth/2, 300);
		g2.setTransform(at);
	}


	@Override
    /**  Checks to see if the user wants to go back
	* @param arg0  the key that is recorded by the program
	 */
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


}

