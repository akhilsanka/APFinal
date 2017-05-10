import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
	//test 
	JPanel cardPanel;
	
	public Main(String title) {
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
		OptionPanel panel1 = new OptionPanel(this);    
	    GamePanel panel2 = new GamePanel(this);
	    
	
	    cardPanel.add(panel1,"1"); // Card is named "1"
	    cardPanel.add(panel2,"2"); // Card is named "2"
	    cardPanel.add(panel2,"3");
	    cardPanel.add(panel2,"4");
	    cardPanel.add(panel2,"5");
	    
	    
	    add(cardPanel);
	    addKeyListener(panel2);
	
	    setVisible(true);
	}

	public static void main(String[] args)
	{
		Main w = new Main("AP Animation Demo");
	}
  
	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel,name);
		requestFocus();
	}
  
}