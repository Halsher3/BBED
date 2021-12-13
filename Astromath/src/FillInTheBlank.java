import java.util.Random;

public class FillInTheBlank extends Question{
	private static Random rand = new Random();

	public FillInTheBlank(int grade, int numOfQuestions)  {
		
		super(grade, numOfQuestions);
		
	}
	
	
	
	public String[] generateFITB(int grade) {
	String[] FITBStatement = new String[2];
	String statement = "";
	int prompt = rand.nextInt(2);
	int maxNum= 20;
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
		halfNum = maxNum/2;
		names1[0] = "Angela"; names1[1] = "Bill"; names1[2] = "Joe"; names1[3] = "Ryan";
		names2[0] = "John"; names2[1] = "Ellie"; names2[2] = "Goofy";
		object[0] = "Stars"; object[1] = "Planets"; object[2] = "Rockets";
		
		floor = 0;
		firstNum = rand.nextInt(halfNum -1) +1;
		secondNum = rand.nextInt(halfNum -1) +1;
		
		
		FITBStatement[0] = String.format("What comes after %d?", firstNum);
		FITBStatement[1] = String.format("%s", (firstNum+1));
		
		break;
		
	case 1:
	  
	names1[0] = "Bruce"; names1[1] = "Brandon"; names1[2] = "Eddy"; names1[3] = "Dylan";
	names2[0] = "Peter"; names2[1] = "Mark"; names2[2] = "Garen";
	object[0] = "Bananas"; object[1] = "Apples"; object[2] = "Berries"; object[3] = "Pears";
	
	
	//rerolls numbers is they're equal
	while(firstNum == secondNum) {
		firstNum = rand.nextInt(halfNum) + floor;
	}

	  switch(prompt) {
	  case 0:
		  statement = String.format("%s has %d %s. %s has %d. Together they have ___.", names1[name1Roll],firstNum, object[objectRoll].toLowerCase(), names2[name2Roll], secondNum, names1[name1Roll]);
		  break;
	  case 1: 
		  //rerolls numbers to prevent negatives
		  while(firstNum < secondNum) {
			  secondNum = rand.nextInt(halfNum) + floor;
		  }
		  statement = String.format("%s has %d %s. %s has %d. %s has ___ more.", names1[name1Roll],firstNum, object[objectRoll].toLowerCase(), names2[name2Roll], secondNum, names1[name1Roll]);
		  break;
	  }
	  
	  FITBStatement[0] = statement;
	  
	  
	  
	  //assigns index 1 of FITBStatement it's answer
	  if(prompt == 0) {
		  
		 FITBStatement[1] = String.valueOf(firstNum + secondNum);
		  
	  } else if (prompt == 1) {
		  if(firstNum > secondNum) {
			  FITBStatement[1] = String.valueOf(firstNum - secondNum);
		  } else {
			  FITBStatement[1] = String.valueOf(secondNum - firstNum);
		  }
		  

	  }
	  break;
	
	case 2:
		 firstNum = rand.nextInt(5 - 2) + 2;
		 secondNum = rand.nextInt(5 - 2) + 2;
		int objectRoll2 = rand.nextInt(4);
		int sumCoins = 0;
		
		names1[0] = "Bruce"; names1[1] = "Brandon"; names1[2] = "Eddy"; names1[3] = "Dylan";
		names2[0] = "Peter"; names2[1] = "Mark"; names2[2] = "Garen";
		object[0] = "Pennies"; object[1] = "Nickles"; object[2] = "Dimes"; object[3] = "Quarters";
		while(objectRoll == objectRoll2) {
			objectRoll2 = rand.nextInt(4);
		}
		
		
		statement = String.format("%s has %d %s and %d %s. How much money does %s have?", names1[name1Roll], firstNum, object[objectRoll], secondNum, object[objectRoll2], names1[name1Roll]);
		
		
		//calculates cents
		switch(objectRoll) {
		case 0:
			sumCoins += firstNum;
			break;
		case 1:
			sumCoins += firstNum * 5;
			break;
		case 2:
			sumCoins += firstNum * 10;
			break;
		case 3: 
			sumCoins += firstNum * 25;
			break;
		}
		
		switch(objectRoll2) {
		case 0:
			sumCoins += secondNum;
			break;
		case 1:
			sumCoins += secondNum * 5;
			break;
		case 2:
			sumCoins += secondNum * 10;
			break;
		case 3: 
			sumCoins += secondNum * 25;
			break;
		}
		
		FITBStatement[0] = statement;
		FITBStatement[1] = String.format("%d", sumCoins);
		
	  break;
	case 3:
		maxNum = 100;
		halfNum = maxNum/2;
		floor = 2;
		
	
		
		//add a floor if you want to increase the base of the random
		 firstNum = rand.nextInt(maxNum - floor) + floor;
		 secondNum = rand.nextInt(maxNum - floor) + floor;

		//while loop to continuously generate new numbers in the event that the random numbers are larger than halfNum, or the total is greater than maxNum

		while(firstNum * secondNum > maxNum){
		firstNum = rand.nextInt(maxNum - floor) + floor;
		secondNum = rand.nextInt(maxNum - floor) + floor;
		}
		
		statement = String.format("%d x _ = %d", firstNum, (firstNum*secondNum));
		FITBStatement[0] = statement;
		
		statement = String.format("%d", secondNum);
		FITBStatement[1] = statement;
		break;
		
	case 4: 
		firstNum = rand.nextInt(99) + 1;

		secondNum = 100;
		double fraction = (double)firstNum/ secondNum;
		statement = String.format("Convert this decimal to a fraction over 100    %.2f", fraction);
		
		FITBStatement[0] = statement;
		
		statement = String.format("%d/%d", firstNum, secondNum);
		
		FITBStatement[1] = statement;
		
		
		
	}

	return FITBStatement;
	
}

}