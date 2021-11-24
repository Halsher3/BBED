
import java.util.Random;

public class MultipleChoice extends Question{
	private static Random rand = new Random();
	private static int answer;

	public MultipleChoice(int grade, int numOfQuestions)  {
		
		super(grade, numOfQuestions);
		numOfQuestions = 4;
		
	}
	
	public int[] generateAddSub(int min, int max, int operand) {
		if(operand == 4) {
		 operand = rand.nextInt(2); //next number 0 or 1
		}
		int maxNum= 20;
		int halfNum = maxNum/2;
		int floor = 5;
		int[] equation = new int[5];
		
		//add a floor if you want to increase the base of the random
		int firstNum = rand.nextInt(halfNum) + floor;
		int secondNum = rand.nextInt(halfNum) + floor;
		int transitionNum;
		answer = firstNum + secondNum;

		//while loop to continuously generate new numbers in the event that the random numbers are larger than halfNum, or the total is greater than maxNum

		while(firstNum + secondNum > maxNum){
		firstNum = rand.nextInt(halfNum) + floor;
		secondNum = rand.nextInt(halfNum) + floor;
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
        Boolean duplicates = true;
        for(int i = 0; i < answers.length; i++){
          for( int j = i+1; j < answers.length; j++){
            if(answers[i] == answers[j]){
               duplicates = true;
             
            }
            else
            {
            	duplicates = false;
            }
          }
        }
         return duplicates;
      }
	
	public static Boolean hasNoNegatives(int[] answers){
        Boolean negatives = true;
        for(int i = 0; i < answers.length; i++){
          
            if(answers[i] < 0){
               negatives = true;
             
          }
            else
            {
            	negatives = false;
            }
        }
         return negatives;
      }
	
	   public static Boolean hasNoZeroes(int[] answers){
	        Boolean zeroes = true;
	        for(int i = 0; i < answers.length; i++){
	          for( int j = i+1; j < answers.length; j++){
	            if(answers[i] == 0){
	               zeroes = true;
	             
	            }
	            else
	            {
	            	zeroes = false;
	            }
	          }
	         }
	        return zeroes;
	        }
	
	
		//method for generating the multiple choice questions, call this in the above method
	
		public static int[] generateQuestions(int answer, int numOfQuestions, int difficulty){

		//generate 3 random answers for multiple choice within +-5 of the actual answer
	      
	        Random rand = new Random();
	      int[] answers1 = new int[numOfQuestions];
	      int multChoiceAnswer1 = rand.nextInt(numOfQuestions);
	      
	      
	      
	      //generate 4 random answers for multiple choice within +-spread of the actual answer
	      do{
	      for(int i = 0; i < numOfQuestions; i++){

	            int spread = rand.nextInt(numOfQuestions+difficulty);
	            int operand = rand.nextInt(2);
	            
	            if((2 * spread+ 1) < numOfQuestions) {
	  	    	  spread++;
	  	    	  }
	            
	            
	              answers1[i] = answer + spread;
	            
	        
	          if(operand == 0){
	            answers1[i] = answer + spread;
	          } else if(operand == 1){
	            answers1[i] = answer - spread;
	          }
	        
	          if(hasNoNegatives(answers1))
	          {
	        	  answers1[i] = answers1[i] * (-1);
	          }
	
	      }
	      }
	      while(hasNoDuplicate(answers1) || hasNoNegatives(answers1) || hasNoZeroes(answers1));
	            answers1[multChoiceAnswer1] = answer;
			
		

		//returns numOfQuestions-1 amount of randomly generated answers, and one real answer randomly assorted in, as an array
		return answers1;
		
		
	}

}

