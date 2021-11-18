public class Student{
	private static String username;
	private static String email;
	private static String passWord;
	private static int accNum;
	private static int gradeLevel;
	private static int level;
	private static int testScores;

	//constructor
	public Student(String username, String email, String password, int accNum, int gradeLevel, int level, int testScores ) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.accNum = accNum;
		this.gradeLevel = gradeLevel;
		this.level = level;
		this.testScores = testScores; 
	} 

	public void setUsername(String username){
		this.username = username;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public void setEmail(String email){
		this.email = email;
	}

	//construtor for login info

	void getPassword(String password){
		return this.password;
	}


	String getLogin(String login) {

		if(username.equals(username)){
			
			if(password.equals(password)){
				
				return login;;
			} 
			else {
				break;
			}
		}

		return null;
	}

	void getAccNum (int accNum) {
		return accNum;
	}

	void getGrade (int gradeLevel){
		return gradeLevel;
	}

	void getLevel (int level) {
		return level;
	}

}

// return type errors
// break outside loop error


		 
