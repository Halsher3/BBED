import java.util.Random;

public class FillInTheBlank extends Question{
	private static Random rand = new Random();

	public FillInTheBlank(int grade, int numOfQuestions)  {
		
		super(grade, numOfQuestions);
		
	}
	
	public static String[] generateFITB(int grade) {
	String[] FITBStatement = new String[2];
	String statement = "";
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
	
	
	//rerolls numbers is they're equal
	while(firstNum == secondNum) {
		firstNum = rand.nextInt(halfNum) + floor;
	}

	  switch(prompt) {
	  case 0:
		  statement = String.format("%s has %d %s. %s has %d. Together they have ___.", names1[name1Roll],firstNum, fruit[fruitRoll].toLowerCase(), names2[name2Roll], secondNum, names1[name1Roll]);
		  break;
	  case 1: 
		  //rerolls numbers to prevent negatives
		  while(firstNum < secondNum) {
			  secondNum = rand.nextInt(halfNum) + floor;
		  }
		  statement = String.format("%s has %d %s. %s has %d. %s has ___ more.", names1[name1Roll],firstNum, fruit[fruitRoll].toLowerCase(), names2[name2Roll], secondNum, names2[name2Roll]);
		  break;
	  }
	  
	  FITBStatement[0] = statement;
	  
	  
	  
	  //assigns index 1 of FITBStatement it's answer
	  if(prompt == 0) {
		  
		 FITBStatement[1] = String.valueOf(firstNum + secondNum);
		  
	  } else if (prompt == 1) {
		  if(firstNum > secondNum) {
			  FITBStatement[1] = String.valueOf(firstNum - secondNum);
		  }
		  

	  }

	return FITBStatement;
	
}

}