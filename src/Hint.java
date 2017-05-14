import java.io.Serializable;
import java.util.ArrayList;

public class Hint implements Serializable{
	
	private static final long serialVersionUID = 1;
	
	private String hint;
	private int answer;
	private HintLocation loc;
	
	public Hint(HintLocation myLoc, String myHint, int myAnswers)
	{
		loc = myLoc;
		answer = myAnswers;
		hint = myHint;
	}
	
	public Hint(String myHint, int myAnswers)
	{
		answer = myAnswers;
		hint = myHint;
	}
	
}
