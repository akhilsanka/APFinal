import java.util.ArrayList;

public class Hint {
	private String hint;
	private int answers;
	private HintLocation loc;
	
	public Hint(HintLocation myLoc, String myHint, int myAnswers)
	{
		loc = myLoc;
		answers = myAnswers;
		hint = myHint;
	}
	
}
