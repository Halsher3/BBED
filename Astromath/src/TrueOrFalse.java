import java.util.Random;

public class TrueOrFalse extends Question{
	private static Random rand = new Random();

	public TrueOrFalse(int grade, int numOfQuestions)  {
		
		super(grade, numOfQuestions);
		numOfQuestions = 2;
		
	}
//Returns a String[] with the first index being the ToF Statement, and the second being the answer.
	public String[] generateToF(int grade){
		
		String statement = "";
		String[] TFStatement = new String[2];
		int prompt = rand.nextInt(1);
		int maxNum = 10;
		int halfNum = maxNum/2;
		int floor = 2;
		int firstNum = rand.nextInt(halfNum) + floor;
		int secondNum = rand.nextInt(halfNum) + floor;
		String[] names1 = new String[4];
		String[] names2 = new String [3];
		String[] object = new String[4];
		
		
		int name1Roll = rand.nextInt(4);
		int name2Roll = rand.nextInt(3);
		int objectRoll = rand.nextInt(3);
		
		
		
		
		switch(grade) {
		case 0:
			maxNum = 10;
			names1[0] = "Angela"; names1[1] = "Bill"; names1[2] = "Joe"; names1[3] = "Ryan";
			names2[0] = "John"; names2[1] = "Ellie"; names2[2] = "Goofy";
			object[0] = "Stars"; object[1] = "Planets"; object[2] = "Rockets";
			
			floor = 0;
			firstNum = rand.nextInt(maxNum) ;
			
			switch(prompt) {
			case 0:
				 statement = String.format("%s counts %d %s. %s counts %d. %s is right.", names1[name1Roll], firstNum, object[objectRoll].toLowerCase(), names2[name2Roll], secondNum, names1[name1Roll]);
				 break;
			
			case 1:
			  statement = String.format("%s counts %d %s. %s counts %d. %s is right.", names1[name1Roll],firstNum, object[objectRoll].toLowerCase(), names2[name2Roll], secondNum, names2[name2Roll]);
			  break;
			}
			 TFStatement[0] = statement;
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
		
					  break;
					
		case 1:
		maxNum = 20;
		names1[0] = "Bruce"; names1[1] = "Brandon"; names1[2] = "Eddy"; names1[3] = "Dylan";
		names2[0] = "Peter"; names2[1] = "Mark"; names2[2] = "Garen";
		object[0] = "Bananas"; object[1] = "Apples"; object[2] = "Berries"; object[3] = "Pears";
		
		
		if(firstNum == secondNum) {
			firstNum = rand.nextInt(halfNum) + floor;
		}

		//creates a prompt given random numbers
		  switch(prompt) {
		  case 0:
			  statement = String.format("%s has %d %s. %s has %d. %s has more.", names1[name1Roll],firstNum, object[objectRoll].toLowerCase(), names2[name2Roll], secondNum, names1[name1Roll]);
			  break;
		  case 1: 
			  statement = String.format("%s has %d %s. %s has %d. %s has more.", names1[name1Roll],firstNum, object[objectRoll].toLowerCase(), names2[name2Roll], secondNum, names2[name2Roll]);
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
		  break;
		}
		  
		return TFStatement;
	}
	

}
