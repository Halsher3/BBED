
import java.util.Random;

public class MultipleChoice extends Question{
	private static Random rand = new Random();
	private static int answer;

	public MultipleChoice(int grade, int numOfQuestions)  {
		
		super(grade, numOfQuestions);
		numOfQuestions = 4;
		
	}
	
	// creates an answer depending on which operand is given
	public int generateOperandBasedAnswer(int operand, int firstNum, int secondNum) {
		switch(operand) {
		case 0: answer = firstNum + secondNum;
		break;
		case 1: answer = firstNum - secondNum;
		break;
		case 2: answer = firstNum * secondNum;
		break;
		case 3: answer = firstNum / secondNum;
		break;
		}
		return answer;
	}
	
	
	
	public int[] generateEquation(int grade, int operand, int floor) {
		
		int maxNum = 0;
		int halfNum;
		int[] equation = new int[4];
		int firstNum = 0;
		int secondNum = 0;
		int[] avNeg = new int[4];
		
		//whatever the grade is, it'll select the appropriate algorithm. K, 1, 2, 3, 4 is case 0,1,2,3,4.
		switch(grade) {
		case 0:
			
			maxNum = 10;
			if(operand == 4) {
				 operand = rand.nextInt(2); //next number 0 or 1
				}
				
				halfNum = maxNum/2;
			
				
				//add a floor if you want to increase the base of the random
				 firstNum = rand.nextInt(maxNum - floor) + floor;
				 secondNum = rand.nextInt(maxNum - floor) + floor;

				//while loop to continuously generate new numbers in the event that the random numbers are larger than halfNum, or the total is greater than maxNum

				while(firstNum + secondNum > maxNum){
				firstNum = rand.nextInt(maxNum - floor) + floor;
				secondNum = rand.nextInt(maxNum - floor) + floor;
				}

				
				//to avoid negative numbers, we check if the operand is subtraction and then if the firstNum is less than secondNum
				avNeg = avoidNegatives(firstNum, secondNum, operand);
				firstNum = avNeg[0];
				secondNum = avNeg[1];
				
				//random operand for + or -
				generateOperandBasedAnswer(operand, firstNum, secondNum);
				
				break;
		
		case 1:
			
		maxNum = 20;
		if(operand == 4) {
		 operand = rand.nextInt(2); //next number 0 or 1
		}
		
		halfNum = maxNum/2;
	
		
		//add a floor if you want to increase the base of the random
		 firstNum = rand.nextInt(maxNum - floor) + floor;
		 secondNum = rand.nextInt(maxNum - floor) + floor;

		//while loop to continuously generate new numbers in the event that the random numbers are larger than halfNum, or the total is greater than maxNum

		while(firstNum + secondNum > maxNum){
		firstNum = rand.nextInt(maxNum - floor) + floor;
		secondNum = rand.nextInt(maxNum - floor) + floor;
		}

		
		//to avoid negative numbers, we check if the operand is subtraction and then if the firstNum is less than secondNum
		avNeg = avoidNegatives(firstNum, secondNum, operand);
		firstNum = avNeg[0];
		secondNum = avNeg[1];
		
		//random operand for + or -
		generateOperandBasedAnswer(operand, firstNum, secondNum);
		
		break;
		}
		
		equation[0] = firstNum;
	    equation[1] = operand;
		equation[2] = secondNum;
		equation[3] = answer;
		
		

		return equation;
				
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



