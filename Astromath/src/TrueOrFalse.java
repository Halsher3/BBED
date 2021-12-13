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
			firstNum = rand.nextInt(maxNum - 2)  + 2;
			int randomPrompt = rand.nextInt(2);
			if(randomPrompt == 0) {
			secondNum = firstNum - 1;
			}
			else {
				secondNum = firstNum + 1;
			}
			
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
		
		case 2:
			maxNum = 999;
			firstNum = rand.nextInt(maxNum - 100) + 100;
			secondNum = rand.nextInt(maxNum - 100) + 100;
		prompt = rand.nextInt(3);
			
		switch(prompt) {
		case 0:
				statement = String.format("%d < %d", firstNum, secondNum);
				break;
		case 1:
			statement = String.format("%d > %d", firstNum, secondNum);
				break;
		case 2:
			statement = String.format("%d = %d", firstNum, secondNum);
				break;			
		}
		TFStatement[0] = statement;
		
		  if(prompt == 0) {
			  
			  if(firstNum < secondNum) {
				  TFStatement[1] = "True";
			  } else {
				  TFStatement[1] = "False";
			  }
			  
		  } else if (prompt == 1) {
			  
			  if(firstNum >  secondNum) {
				  TFStatement[1] = "True";
			  }  else  {
				  TFStatement[1] = "False";
			  }
			  
		  } else if (prompt == 2) {
			  if(firstNum == secondNum) {
				  TFStatement[1] = "True";
			  } else {
				  TFStatement[1] = "False";
				  
			  }
		  }
		
			
			break;
			
		case 3:
			prompt = rand.nextInt(2);
			maxNum = 180;
			names1[0] = "Bruce"; names1[1] = "Brandon"; names1[2] = "Eddy"; names1[3] = "Dylan";
			object[0] = " a Soccer game"; object[1] = "class"; object[2] = "store"; object[3] = "a basketball game";
			int[] minutes = new int[3];

			minutes[0] = rand.nextInt(5) + 10; minutes[1] = rand.nextInt(10) + 30; minutes[2] = rand.nextInt(20) + 25;
			firstNum = rand.nextInt(maxNum - 10) + 10;

			int minutesRand = rand.nextInt(3);
			
			int time = rand.nextInt(10) + 1;
			switch(prompt) {
			
			case 0: 
				statement = String.format("%s has to go to %s. It takes %d minutes to get there, and it's %d:05 now. Does %s have enough time to get there if it closes at %d:%d?", names1[name1Roll], object[objectRoll].toLowerCase(), firstNum, time, names1[name1Roll], (time+1), minutes[minutesRand]);
				if(firstNum < 60+minutes[minutesRand]) {
					TFStatement[1] = "True";
					
				} else {
					TFStatement[1] = "False";
				}
				break;
			case 1:
				firstNum = rand.nextInt(55) + 5;
				statement = String.format("%s has to go to %s. It takes %d minutes to get there, and it's %d:05 now. Does %s have enough time to get there if it closes at %d:%d?", names1[name1Roll], object[objectRoll].toLowerCase(), firstNum, time, names1[name1Roll], (time+1), minutes[minutesRand]);
				TFStatement[1] = "True";
				break;
				
				
				
			}			
						
			TFStatement[0] = statement;
			break;
			
		case 4:
			
			objectRoll = rand.nextInt(3);
			object[0] = "n obtuse"; object[1] = " right"; object[2] = "n acute";
			
			firstNum = rand.nextInt(179) + 1;
			
			statement = String.format("If an angle is %d degrees, it's a%s angle.", firstNum, object[objectRoll]);
			TFStatement[0] = statement;
			
			if(objectRoll == 0) {
				if(firstNum > 90) {
					TFStatement[1] = "True";
				} else {
					TFStatement[1] = "False";
				}
			}	else if(objectRoll == 1) {
				if(firstNum == 90) {
					TFStatement[1] = "True";
				} else {
					TFStatement[1] = "False";
				}
			}	else if(objectRoll == 2) {
				if(firstNum < 90) {
					TFStatement[1] = "True";
				} else {
					TFStatement[1] = "False";
				}
			}
			
			
			

	
		}
		return TFStatement;
	}
	

}
