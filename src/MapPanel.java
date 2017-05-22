import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MapPanel extends JPanel{
	private BufferedImage image;
	private Hint currHint;
	private JLabel picLabel;
	
	public MapPanel(Hint h)
	{
        try {
			image = ImageIO.read(new File("HomesteadMap.jpg"));
			picLabel = new JLabel(new ImageIcon(image));
			add(picLabel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Graphics g = image.getGraphics();
        g.drawImage(image, 0, 0, this);
        g.dispose();
		currHint = h;
	}
	
	public void paint(Graphics g) {
    	//super.paintComponent(g);
    	if(image != null)
    	{
    		g.drawImage(image, 0, 0, this);
    	}
    	drawCenteredCircle(g, (int)currHint.getHintLoc().getX(), (int)currHint.getHintLoc().getY(), 100);
    	JPanel test = new JPanel();
    	JLabel test2 = new JLabel("Test!");
    	test.add(test2);
    	add(test);
    }

	public void drawCenteredCircle(Graphics g, int x, int y, int r) {
		  x = x-(r/2);
		  y = y-(r/2);
		  g.fillOval(x,y,r,r);
	}
}
