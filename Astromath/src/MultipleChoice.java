
import java.util.Random;

public class MultipleChoice extends Question{
	private static int answer;
	private static int numOfQuestions = 4;
	private static Random rand = new Random();

	public MultipleChoice(String question, int numQuestions, int answer)  {
		
		super(question, numQuestions, answer);
		
		
		
		
	}
    // method to make an addition or subtraction equation. It will return the full equation broken into 4 parts.
	// The First number, the operand, the Second number, and the answer in an array for easy UI usability.
	public static int[] generateAddSub(int min, int max) {

		int operand = rand.nextInt(1); //next number 0 or 1

		int maxNum= 20;
		int halfNum = maxNum/2;
		int floor = 3;
		int[] equation = new int[5];
		
		//add a floor if you want to increase the lower limit of the random question
		
		int firstNum = rand.nextInt(halfNum+floor);
		int secondNum = rand.nextInt(halfNum+floor);
		int transitionNum;
		answer = firstNum + halfNum;

		/*while loop to continuously generate new numbers in the event that the random numbers are larger than halfNum
		 */

		while(firstNum + secondNum > maxNum){
		firstNum = rand.nextInt(halfNum);
		secondNum = rand.nextInt(halfNum);
		}

		
		//to avoid negative numbers, we check if the operand is subtraction and then if the firstNum is less than secondNum
		if(operand == 1 || firstNum < secondNum){
		transitionNum = secondNum;
		secondNum = firstNum;
		firstNum = transitionNum;
		}

		//random operand for + or -
		if(operand == 0){
		answer = firstNum + halfNum;
		} else if (operand == 1){
		answer = firstNum - halfNum;
		}
		
		/*
		 * Slot [0] = first number
		 * Slot [1] = operand number
		 * Slot [2] = second number
		 * Slot [3] = answer
		 * 
		 */
		equation[0] = firstNum;
	    equation[1] = operand;
		equation[2] = secondNum;
		equation[3] = answer;
		
		
	
		return equation;
	
	}


		/*method for generating the multiple choice questions, call this in the above method
		*Cast this to an int array to use outside of this class */
		public static int[] generateQ(int answer, int numOfQuestions){

		int[] answers = new int[numOfQuestions];
		int spread = rand.nextInt(5);
		int operand = rand.nextInt(1);
		int multChoiceAnswer = rand.nextInt(numOfQuestions);
		
		//Check to make sure the answer is larger than the spread to prevent variance issues(If answer = 2, spread = 5, -3 may be an option)
		if(spread > answer) {
			spread = answer - 1;
		}

		//generate 3 random answers for multiple choice within +- the spread of the answer
		for(int i = 0; i < numOfQuestions; i++){
		if(i == multChoiceAnswer){
		answers[i] = answer;
		}
		else if(operand == 0){
		answers[i] = answer + spread;
		} else if(operand == 1){
		answers[i] = answer - spread;
		}

		}
		
		return answers;
		
		
	}

}

