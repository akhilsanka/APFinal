import java.io.Serializable;
import java.util.ArrayList;

public class Hint implements Serializable{
	

	private static final long serialVersionUID = 7206532398665898388L;
	private String hint;
	private int answer;
	//private HintLocation loc;
	
	/** Creates a constructor that has a hint, location, and answer
	 * 
	 * @param myLoc the location related to the hint
	 * @param myHint the hint message
	 * @param myAnswers the answer to the hint
	 */
	public Hint(HintLocation myLoc, String myHint, int myAnswers)
	{
		//loc = myLoc;
		answer = myAnswers;
		hint = myHint;
	}
	/** Creates a constructor that has a hint and answer
	 * 
	 * @param myHint the hint message
	 * @param myAnswers the answer to the hint
	 */
	public Hint(String myHint, int myAnswers)
	{
		answer = myAnswers;
		hint = myHint;
	}
	
	/** Returns the string hint in the object
	 * 
	 * @return the string hint 
	 */
	public String getHint()
	{
		return hint;
	}
	
	/** Returns the answer to the hints
	 * 
	 * @return the string answer
	 */
	public int getAnswer()
	{
		return answer;
	}
	
}
