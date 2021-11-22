public class Student{
	private String username;
	private String email;
	private String password;
	private int accNum;
	private int gradeLevel;
	private int level;

	//constructs account info 
	public Student(String username, String email, String password, int accNum, int gradeLevel, int level) 
	{
		this.username = username;
		this.email = email;
		this.password = password;
		this.accNum = accNum;
		this.gradeLevel = gradeLevel;
		this.level = level;
	} 

	//user creates an account with username, email and password
	public void setUsername(String username){
		this.username = username;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public void setEmail(String email){
		this.email = email;
	}

	//grants login given correct credentails are entered

	public String getPassword(String password)
	{
		return this.password;
	}


	public Boolean getLogin(String username, String password) 
	{
        
        Boolean loginPass;

        if(this.username.equals(username) && (this.password.equals(password))){
            loginPass = true;
        } else { 
            loginPass = false;
        }


        return loginPass;
    }

	public int getAccNum()
	{
		return accNum;
	}

	public int getGradeLevel()
	{
		return gradeLevel;
	}

	public int getLevel() 
	{
		return level;
	}

}