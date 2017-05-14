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

public class GamePanel extends JPanel implements KeyListener, ActionListener
{
	private Main m;
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
	
    public GamePanel(Main m) 
    {
    	super(new GridBagLayout());
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
        //System.out.println(game.getName());
        //playGame();
       // p.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //used = new JTextField("Number of Finished Hints: ");
        //unused = new JTextField("Number of Hints Remaining: ");
        //p.add(used);
        //p.add(unused);
       // g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    }
	
    public void setRace(Race race)
    {
    	game = race;
    	//System.out.println("race: " + game.getName());
    	playGame();
    }
    
    public void playGame()
    {
    	currHint = getHint();
    	if(currHint.equals("Race is Complete!"))
    		return;
    	hintArea.append(currHint);
    	//used.setText("Number of Finished Hints: " + game.getFinishedHints());
    	//unused.setText("Number of Finished Hints: " + game.getFinishedHints());
    	p.repaint();
    	//m.changePanel("5");
    }
    
	public String getHint()
	{
		if(game != null)
		{
			if(game.isFinished() == true)
			{
				used.setText("Number of Finished Hints: " + (game.getFinishedHints()-1));
		    	unused.setText("Number of Remaining Hints: " + (game.getRemainingHints()+1));
				msgbox("Congratulations, You Finished The Race!");
				return "Race is Complete!";
			}
			else
			{
				Hint currHint = game.getHint();
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
	
	public boolean checkAnswer(int answer)
	{
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
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
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void msgbox(String s){
		   JOptionPane.showMessageDialog(null, s);
		}
}
