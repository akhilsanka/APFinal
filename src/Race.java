
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Race extends JPanel {
	

	private ArrayList<Hint> unusedHints;
	private ArrayList<Hint> usedHints;

	private BufferedImage image;
	private boolean isComplete;

	
	public Race()
	{
		unusedHints = new ArrayList<Hint>();
		usedHints = new ArrayList<Hint>();
		isComplete = false;
	}
	
//	public Hint getHint()
//	{
//		if(usedHints.size() == hints.size()){
//			return null;
//		}
//		int randHint;
//		boolean used = false;
//		do{
//			randHint = (int)Math.random()*hints.size();
//			for(int i = 0; i<usedHints.size(); i++){
//				if(randHint == usedHints.get(i)){
//					used = true;
//					break;
//				}
//			}
//			if(used == false){
//				usedHints.add(randHint);
//				return hints.get(randHint);
//			}
//			
//		}
//		while(used == true);
//		return hints.get(0);
//		
//	}
	public Hint getHint()
	{
		if(unusedHints.size() == 0){
			return null;
		}
		int randHint;
		randHint = (int)Math.random()*unusedHints.size();
		Hint shuffledHint = unusedHints.get(randHint);
		usedHints.add(unusedHints.get(randHint));
		unusedHints.remove(randHint);	
		
		return shuffledHint;
		
	}
	
	public void addHint(String hint, int answer)
	{
		Hint newHint = new Hint(hint, answer);
		unusedHints.add(newHint);
	}
	
	public void addHint(HintLocation location, String hint, int answer)
	{
		Hint newHint = new Hint(location, hint, answer);
		unusedHints.add(newHint);
	}

}
