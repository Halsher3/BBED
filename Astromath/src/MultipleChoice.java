
import java.util.Random;

public class MultipleChoice extends Question{
	private static Random rand = new Random();
	private static int answer;

	public MultipleChoice(int grade, int numOfQuestions)  {
		
		super(grade, numOfQuestions);
		numOfQuestions = 4;
		
	}
	
	public static int[] generateAddSub(int min, int max) {

		int operand = rand.nextInt(1); //next number 0 or 1

		int maxNum= 20;
		int halfNum = maxNum/2;
		int floor = 5;
		int[] equation = new int[5];
		
		//add a floor if you want to increase the base of the random
		int firstNum = rand.nextInt(halfNum) + floor;
		int secondNum = rand.nextInt(halfNum) + floor;
		int transitionNum;
		answer = firstNum + halfNum;

		//while loop to continuously generate new numbers in the event that the random numbers are larger than halfNum, or the total is greater than maxNum

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
	
	

	
	
	
	


		//method for generating the multiple choice questions, call this in the above method
		public static int[] generateQuestions(int answer, int numOfQuestions){

		int[] answers = new int[numOfQuestions];
		int spread = rand.nextInt(5);
		int operand = rand.nextInt(1);
		int multChoiceAnswer = rand.nextInt(numOfQuestions);

		//generate 3 random answers for multiple choice within +-5 of the actual answer
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
		//returns numOfQuestions-1 amount of randomly generated answers, and one real answer randomly assorted in, as an array
		return answers;
		
		
	}

}

