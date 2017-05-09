import java.util.ArrayList;

public class Race {
	
	private ArrayList<Hint> unusedHints;
	private ArrayList<Hint> usedHints;

	private User[] Users;
	private Map map;
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
	

}
