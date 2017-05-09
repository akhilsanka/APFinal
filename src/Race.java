import java.util.ArrayList;

public class Race {
	
	private ArrayList<Hint> hints;
	private ArrayList<Integer> usedHints;

	private User[] Users;
	private Map map;

	
	public Race()
	{
		hints = new ArrayList<Hint>();
	}

	
	/*private String[] shuffleHints()
	{
		int randHint;
		boolean used = false;
		do{
			randHint = (int)Math.random()*hints.size();
		}
		while(used != false);
//			
//		}
//		for(int i = 0; i<hints.length(); i++)
//		
	}
*/
}
