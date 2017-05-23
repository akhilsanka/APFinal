import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
import javax.swing.ImageIcon;
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
	private Hint currHint;
	private String currClue;
	private int currAnswer;
	private JTextArea hintArea;
	private JTextArea answerArea;
	private JTextField used;
	private JTextField unused;
	private JPanel p;
	private JButton check;
	private JLabel picLabel;
	private JPanel map;
	private Graphics2D g;
	private JButton diffRace;
	
	private JButton pauseplay;
	private int pauseCount;

	/**
	 * Makes a GamePanel object where the game is played
	 * @param m Main Class
	 */
    public PlayGamePanel(Main m, GamePanel gp) 
    {
    	super(new GridBagLayout());    	 
    	this.gp = gp;    	
    	p = new JPanel();
    	this.m = m;
		    	
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
        diffRace = new JButton("Play a different race");
        diffRace.addActionListener(this);
      
        
        pauseplay = new JButton("Pause/Play");
        pauseplay.addActionListener(this);
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;
        
        try {
        	map = new JPanel();
			image = ImageIO.read(new File("HomesteadMap.jpg"));
			picLabel = new JLabel(new ImageIcon(image));
			map.add(picLabel);
			g = image.createGraphics();
			g.drawImage(image, 0, 0, map);
			add(map, c);
		} 
        catch (IOException e)
        {
			e.printStackTrace();
		}
        
        g = image.createGraphics();
 
        add(pauseplay, c);
        p.add(used);
        p.add(unused);
        add(p, c);
        add(hint, c);
        add(scrollPane, c);
        add(guess, c);
        add(scrollPane2, c);
        add(check, c);
        
        add(diffRace, c);
        
        setBackground(Color.WHITE);
    }

    
    /**
     * Repaints the screen to draw a circle of the location of the hint
     * @param g Graphics2D object
     */
	protected void paintComponent(Graphics2D g) {
		try {
			image = ImageIO.read(new File("HomesteadMap.jpg"));
			g = image.createGraphics();
			picLabel.setIcon(new ImageIcon(image));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	    g.setColor(Color.CYAN);
	    drawCenteredCircle(g, (int)currHint.getHintLoc().getX(), (int)currHint.getHintLoc().getY(), 100);
    }
	/**
	 * Sets the race being played to the race object passed in.
	 * @param race Race object that user selects to play
	 */
    public void setRace(Race race)
    {
    	game = race;
    	playGame();
    }
    /**
     * Plays the race
     */
    public void playGame()
    {
    	currClue = getHint();
    	if(currHint.equals("Race is Complete!") == false)
    		hintArea.setText(currClue);
    	if(game.hasMap())
    	{
    		repaint();
    		paintComponent(g);
    	}
    	used.setText("Number of Finished Hints: " + (game.getFinishedHints() - 1));
    	unused.setText("Number of Remaining Hints: " + (game.getRemainingHints() + 1));
    //	m.changePanel("5");
    }
    

    /**
     * Gets the next hint in the race.
     * @return the next hint of the race.
     */
	public String getHint()
	{
		if(game != null)
		{
			if(game.isFinished() == true)
			{
				used.setText("Number of Finished Hints: " + (game.getFinishedHints()));
		    	unused.setText("Number of Remaining Hints: " + (game.getRemainingHints()));
		    	m.changePanel("1");
		    	msgbox("Congratulations, You Finished The Race!" + " Time: " + gp.getMins() + " minutes and " + gp.getSeconds() + " seconds");
				
				return "Race is Complete!";
				
			}
			else
			{
				currHint = game.getHint();
				currAnswer = currHint.getAnswer();
				used.setText("Number of Finished Hints: " + (game.getFinishedHints()));
		    	unused.setText("Number of Remaining Hints: " + (game.getRemainingHints()));
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
		if(answer == currAnswer)
		{
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
		Object chooseB = e.getSource();
		if(chooseB == check)
		{
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
		}
		else if(chooseB == diffRace)
		{
			m.changePanel("2");
		}
		else if(chooseB == pauseplay ){
			
			if(pauseCount % 2 == 0){
				gp.getTimer().play();
				check.setEnabled(true);
			}
			else{
				gp.getTimer().pause();
				check.setEnabled(false);
			}
			pauseCount ++;
		}
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
	
	/**
	 * Draws a centered circle
	 * @param g Graphics object
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param r radius of circle to be drawn
	 */
	public void drawCenteredCircle(Graphics g, int x, int y, int r) {
		  x = x-(r/2);
		  y = y-(r/2);
		  g.fillOval(x,y,r,r);
	}
}
