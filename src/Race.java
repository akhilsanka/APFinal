import java.util.ArrayList;

public class Race {
	
	private ArrayList<Hint> hints;
	private ArrayList<Integer> usedHints;

	private User[] Users;
	private Map map;
	private boolean isComplete;

	
	public Race()
	{
		hints = new ArrayList<Hint>();
		isComplete = false;
	}
	
	public Hint getHint()
	{
		if(usedHints.size() == hints.size()){
			return null;
		}
		int randHint;
		boolean used = false;
		do{
			randHint = (int)Math.random()*hints.size();
			for(int i = 0; i<usedHints.size(); i++){
				if(randHint == usedHints.get(i)){
					used = true;
					break;
				}
			}
			if(used == false){
				usedHints.add(randHint);
				return hints.get(randHint);
			}
			
		}
		while(used == true);
		return hints.get(0);
		
	}
	
	

}
