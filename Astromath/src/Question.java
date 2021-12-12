
public class Question {
	private static int numOfQuestions;
	private static int grade;

	//constructor
	public Question(int grade, int numOfQuestions) 
	{
		this.grade = grade;
		this.numOfQuestions = numOfQuestions;
	}
	
	
	/*gets student Grade to pass to question types for parsing -- GET FROM DATABASE
	public static int getGrade() {
		
	}
	*/
	
	


	public int getNumOfQuestions() {
		return this.numOfQuestions;
	}
	
	
	//iterate through the array to find duplicates
	public static Boolean hasNoDuplicate(int[] answers){
        Boolean duplicates = false;
        for(int i = 0; i < answers.length; i++){
          for( int j = 0; j < answers.length; j++){
            if(answers[i] == answers[j] && i != j){
               duplicates = true;
             
            }
          }
        }
         return duplicates;
      }
	
	//iterate through the array to find negatives
	public static Boolean hasNoNegatives(int[] answers){
        Boolean negatives = false;
        for(int i = 0; i < answers.length; i++){
          
            if(answers[i] < 0){
               negatives = true;
             
          }
        }
         return negatives;
      }
	

	public int[] avoidNegatives(int firstNum, int secondNum, int operand) {
		int[] avNeg = new int[2];
		int transitionNum = 0;
		if(operand == 1 && firstNum < secondNum || operand == 3 && firstNum < secondNum){
		transitionNum = secondNum;
		secondNum = firstNum;
		firstNum = transitionNum;
		
		}
		
		avNeg[0] = firstNum;
		avNeg[1] = secondNum;
		return avNeg;
		
	}
	
}
