import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabOptionPanel extends JPanel {

	private Main m;
	private MakeGamePanel gamePanel;
    private MapJPanel mapPanel;
    
    private JTabbedPane tabbedPane;
    
    
    public TabOptionPanel(Main m) {

    	this.m = m;
        mapPanel = new MapJPanel(m);

        gamePanel = new MakeGamePanel(m);

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
