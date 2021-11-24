
import java.util.Random;

public class MultipleChoice extends Question{
	private static Random rand = new Random();
	private static int answer;

	public MultipleChoice(int grade, int numOfQuestions)  {
		
		super(grade, numOfQuestions);
		numOfQuestions = 4;
		
	}
	
	public int[] generateAddSub(int maxNum, int operand, int floor) {
		if(operand == 4) {
		 operand = rand.nextInt(2); //next number 0 or 1
		}
		int halfNum = maxNum/2;
		int[] equation = new int[4];
		
		//add a floor if you want to increase the base of the random
		int firstNum = rand.nextInt(maxNum - floor) + floor;
		int secondNum = rand.nextInt(maxNum - floor) + floor;
		int transitionNum;

		//while loop to continuously generate new numbers in the event that the random numbers are larger than halfNum, or the total is greater than maxNum

		while(firstNum + secondNum > maxNum){
		firstNum = rand.nextInt(maxNum - floor) + floor;
		secondNum = rand.nextInt(maxNum - floor) + floor;
		}

		
		//to avoid negative numbers, we check if the operand is subtraction and then if the firstNum is less than secondNum
		if(operand == 1 && firstNum < secondNum){
		transitionNum = secondNum;
		secondNum = firstNum;
		firstNum = transitionNum;
		}

		//random operand for + or -
		if(operand == 0){
		answer = firstNum + secondNum;
		} else if (operand == 1){
		answer = firstNum - secondNum;
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
	
	public static Boolean hasNoNegatives(int[] answers){
        Boolean negatives = false;
        for(int i = 0; i < answers.length; i++){
          
            if(answers[i] < 0){
               negatives = true;
             
          }
        }
         return negatives;
      }
	

	
		//method for generating the multiple choice questions, call this in the above method
	
		public static int[] generateQuestions(int answer, int numOfQuestions){

		//generate 3 random answers for multiple choice within +-5 of the actual answer
	      
	        Random rand = new Random();
	      int[] answers1 = new int[numOfQuestions];
	      int multChoiceAnswer1 = rand.nextInt(numOfQuestions);
	      
	      
	      
	      //generate 4 random answers for multiple choice within +-spread of the actual answer
	      do{
	      for(int i = 0; i < numOfQuestions; i++){
	    	  
	    	  	int maxSpread = numOfQuestions * 2 + 1;
	            int spread = rand.nextInt(numOfQuestions - 1) + 1;
	            int operand = rand.nextInt(2);
	            
	            if(maxSpread < numOfQuestions) {
	  	    	  spread++;
	  	    	  }
	            
	          if(operand == 0){
	            answers1[i] = answer + spread;
	          } else if(operand == 1){
	            answers1[i] = answer - spread;
	          }
	        

	      }
          answers1[multChoiceAnswer1] = answer;
	      }
	      while(hasNoDuplicate(answers1) || hasNoNegatives(answers1));

			
		

		//returns numOfQuestions-1 amount of randomly generated answers, and one real answer randomly assorted in, as an array
		return answers1;
		
		
	}
		}



