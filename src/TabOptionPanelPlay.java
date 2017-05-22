import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabOptionPanelPlay extends JPanel {

	private Main m;
	private PlayGamePanel gamePanel;
    private MapJPanelPlay mapPanel;
    
    private JTabbedPane tabbedPane;
    
    
    public TabOptionPanelPlay(Main m, GamePanel gp) {

    	this.m = m;

        gamePanel = new PlayGamePanel(m, gp);
    	mapPanel = new MapJPanelPlay(m, gp);


        setLayout(new BorderLayout());
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("<html><body leftmargin=15 topmargin=8 marginwidth=35 marginheight=5>Hints</body></html>", gamePanel);

        tabbedPane.addTab("<html><body leftmargin=15 topmargin=8 marginwidth=20 marginheight=5>Locations</body></html>", mapPanel);

		add(tabbedPane, BorderLayout.CENTER);

		setBounds(30,30,1100, 750);
	}

	
    public void switchToTab(int i) {
        tabbedPane.setSelectedIndex(i);
    }

    
    
    
}
