import java.util.Random;

public class Question {
	private static String question;
	private static int numQuestions;
	private static int answer;

	//constructor
	public Question(String question, int numQuestions, int answer) {
		this.question = question;
		this.numQuestions = numQuestions;
		this.answer = answer;
	}
	
	//checks the answer for correctness
	public static boolean isCorrect(int userInput) {
		boolean isTrue = false;
		
		if(userInput == answer) {
			isTrue = true;
		}
		
		return isTrue;
	}
	
	//generates a random question type, Multiple Choice, True or False, or Fill in the Blank
	public static void randomQuestion() {
		Random rand = new Random();
		//Generates an int 0-2
	    int randomQ = rand.nextInt(3);
	   
	    switch(randomQ) {
	    
	    case 0: MultipleChoice mp = new MultipleChoice();
	    		break;
	    case 1: TrueOrFalse tof = new TrueOrFalse();
	    		break;
	    case 2: FillInTheBank fitb = new FillInTheBlank();
	    		break;
	    		
	    }
		
		
	}
	
	/*gets student Grade to pass to question types for parsing -- GET FROM DATABASE
	public static int getGrade() {
		
	}
	*/
	
	
	
}
