import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PlayGamePanel extends JPanel implements KeyListener, ActionListener
{
	private Main m;
	private GamePanel gp;
	private BufferedImage image;
	private Race game;
	private String currHint;
	private int currAnswer;
	private JTextArea hintArea;
	private JTextArea answerArea;
	private JTextField used;
	private JTextField unused;
	private JPanel p;
	private JButton check;
	
	private TimerPanel timer;
	/**
	 * Makes a GamePanel object where the game is played
	 * @param m Main Class
	 */
    public PlayGamePanel(Main m) 
    {
    	super(new GridBagLayout());

    	gp = new GamePanel(m);


    	
    	if(gp.fileFound() == true){
    		game = gp.getRace();
    		System.out.println(game.getName());
    	}
    	else{
    		System.out.println("NOT FOUND YET");
    	}
		


    	p = new JPanel();
    	this.m = m;
		setBackground(Color.WHITE);
		
		hintArea = new JTextArea(5, 20);
		hintArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(hintArea);  
        answerArea = new JTextArea(5, 20);
        answerArea.setEditable(true);
        answerArea.addKeyListener(this);;
        JScrollPane scrollPane2 = new JScrollPane(answerArea);
        
        JLabel hint = new JLabel("Hint:");
        JLabel guess = new JLabel("Your Guess: ");
        check = new JButton("Check Answer");
        check.addActionListener(this);
        used = new JTextField("Number of Finished Hints: ");
        unused = new JTextField("Number of Hints Remaining: ");
        used.setEditable(false);
        unused.setEditable(false);
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;
        
        p.add(used);
        p.add(unused);
        add(p, c);
        add(hint, c);
        add(scrollPane, c);
        add(guess, c);
        add(scrollPane2, c);
        add(check, c);
    }

    @Override
    protected void paintComponent(Graphics g) {
              
    }
    
    /**
     * Plays the race
     */
    public void playGame()
    {
    	System.out.println("PlayGame");
    	System.out.println(game);
    	currHint = getHint();
    	if(currHint.equals("Race is Complete!"))
    		return;
    	hintArea.append(currHint);
    	//used.setText("Number of Finished Hints: " + game.getFinishedHints());
    	//unused.setText("Number of Finished Hints: " + game.getFinishedHints());
    	p.repaint();
    	//m.changePanel("5");
    }
    /**
     * Gets the next hint in the race.
     * @return the next hint of the race.
     */
	public String getHint()
	{
		System.out.println("GeTHint");
		if(game != null)
		{
			if(game.isFinished() == true)
			{
				used.setText("Number of Finished Hints: " + (game.getFinishedHints()));
		    	unused.setText("Number of Remaining Hints: " + (game.getRemainingHints()));
				msgbox("Congratulations, You Finished The Race!");
				m.changePanel("1");
				return "Race is Complete!";
			}
			else
			{
				System.out.println(game.getRemainingHints());
				Hint currHint = game.getHint();
				System.out.println(currHint);
				currAnswer = currHint.getAnswer();
				System.out.println("Hint: " + currHint.getHint());
				System.out.println("Answer: " + currHint.getAnswer());
				System.out.println("UsedHints: " + game.getFinishedHints());
				System.out.println("UnusedHints: " + game.getRemainingHints());
				used.setText("Number of Finished Hints: " + (game.getFinishedHints()-1));
		    	unused.setText("Number of Remaining Hints: " + (game.getRemainingHints()+1));
				return currHint.getHint();
			}
		}
		return "Game Not Found";
	}
	/**
	 * Checks to see if the guess from the user is the same as the answer of the hint.
	 * @param answer guess made by the user.
	 * @return true if the answer is correct and false if not.
	 */
	public boolean checkAnswer(int answer)
	{
		System.out.println("CheckAnswer");
		System.out.println("answer: " + answer);
		System.out.println("Current answer: " + currAnswer);
		if(answer == currAnswer)
		{
			System.out.println("answer: " + answer);
			hintArea.setText("");
			if(game.getRemainingHints() == 0)
				game.finish();
			playGame();
			return true;
		}
		return false;
	}

	/**
	 * Calls checkAnswer method if the checkAnswer button is clicked.
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("performed");
		game = gp.getRace();
		
		try
		{
			int guess = Integer.parseInt(answerArea.getText());
			checkAnswer(guess);
		}
		catch(NumberFormatException ex)
		{
        	msgbox("Invalid input, please change input to a number!");
		}
		finally
		{
			answerArea.setText("");
		}
		//System.out.println("guess: " + guess);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * Causes a pop up box to appear if the user presses the enter key.
	 */
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			answerArea.setText("");
			msgbox("Don't press enter after typing in your answer, just click the button when you are done.");
		   }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Causes a pop up window to appear.
	 * @param s message displayed in the pop up window.
	 */
	public void msgbox(String s){
		   JOptionPane.showMessageDialog(null, s);
		}
}
