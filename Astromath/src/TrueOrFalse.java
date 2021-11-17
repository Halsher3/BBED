import java.util.Random;

public class TrueOrFalse extends Question{
	private static Random rand = new Random();

	public TrueOrFalse(int grade, int numOfQuestions)  {
		
		super(grade, numOfQuestions);
		numOfQuestions = 2;
		
	}
//Returns a String[] with the first index being the ToF Statement, and the second being the answer.
	public static String[] generateToF(int grade){
		
		String statement = "";
		String[] TFStatement = new String[2];
		int prompt = rand.nextInt(1);
		int maxNum= 20;
		int halfNum = maxNum/2;
		int floor = 2;
		int firstNum = rand.nextInt(halfNum) + floor;
		int secondNum = rand.nextInt(halfNum) + floor;
		String[] names1 = new String[4];
		String[] names2 = new String [3];
		String[] fruit = new String[4];
		
		
		int name1Roll = rand.nextInt(4);
		int name2Roll = rand.nextInt(3);
		int fruitRoll = rand.nextInt(3);
		  
		names1[0] = "Bruce"; names1[1] = "Brandon"; names1[2] = "Eddy"; names1[3] = "Dylan";
		names2[0] = "Peter"; names2[1] = "Mark"; names2[2] = "Garen";
		fruit[0] = "Bananas"; fruit[1] = "Apples"; fruit[2] = "Berries"; fruit[3] = "Pears";
		
		while(firstNum == secondNum) {
			firstNum = rand.nextInt(halfNum) + floor;
		}

		//creates a prompt given random numbers
		  switch(prompt) {
		  case 0:
			  statement = String.format("%s has %d %s. %s has %d. %s has more.", names1[name1Roll],firstNum, fruit[fruitRoll].toLowerCase(), names2[name2Roll], secondNum, names1[name1Roll]);
			  break;
		  case 1: 
			  statement = String.format("%s has %d %s. %s has %d. %s has more.", names1[name1Roll],firstNum, fruit[fruitRoll].toLowerCase(), names2[name2Roll], secondNum, names2[name2Roll]);
			  break;
		  }
		  TFStatement[0] = statement;
		  
		  
		  //creates the answer for the statement 
		  if(prompt == 0) {
			  
			  if(firstNum > secondNum) {
				  TFStatement[1] = "True";
			  } else {
				  TFStatement[1] = "False";
			  }
			  
		  } else if (prompt == 1) {
			  
			  if(secondNum > firstNum) {
				  TFStatement[1] = "True";
			  }  else  {
				  TFStatement[1] = "False";
			  }
			  
		  }
	
		  
		return TFStatement;
	}
	

}
