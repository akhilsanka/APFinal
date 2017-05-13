import java.io.Serializable;
import java.util.ArrayList;

public class Hint implements Serializable{
	
	private static final long serialVersionUID = 1;
	
	private String hint;
	private String answer;
	private HintLocation loc;
	
	public Hint(HintLocation myLoc, String myHint, String myAnswers)
	{
		loc = myLoc;
		answer = myAnswers;
		hint = myHint;
	}
	
	public Hint(String myHint, String myAnswers)
	{
		answer = myAnswers;
		hint = myHint;
	}
	
}
