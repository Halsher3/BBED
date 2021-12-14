/* Test class is used as an interface
 * It allows the flow of data across multiple panels
 * This class contains the following methods: setDifficulty, getDifficulty, setNumQuestions, getNumQuestions,
 * resetDifficulty, resetNumQuestions, setScoreSheet, getScoreSheet, calculateGrade, setCurrentTest, getCurrentTest 
 * 
 * These methods are used to facilitate tracking of progress during test, using the getNumQuestions and getSetDifficulty methods
 *  and their set counterparts. Reset methods are used to reset in the event that the user moves back to the home page
 *  get and set scoreSheet keep track of test questions answers and calculateGrade parses that into a percentage grade.
 *  the currentTest methods are used to track the current test being taken, particularly from JLabels and Buttons. When selecting
 *  a test, we may want to keep the name of the test in reference, which is what this is for. This also allows the database to know what test is being taken.
 */
public class Test {
	public int difficulty;
	public int numQuestions;
	public int[] questions = new int[10];
	public String currentTest;

	public Test(int difficulty, int numQuestions, String currentTest) {
		this.difficulty = difficulty;
		this.numQuestions = numQuestions;
		this.currentTest = currentTest;
		

	}
	
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
		this.difficulty++;

	}
	
	public int getDifficulty() {
		return difficulty;
	}
	
	//track number of test questions taken
	public void setNumQuestions(int numQuestions) {
		this.numQuestions = numQuestions;
		this.numQuestions++;
	}
	
	
	public int getNumQuestions() {
		return numQuestions;
	}
	
	public void resetNumQuestions() {
		this.numQuestions = 0;
	}
	
	public void resetDifficulty() {
		this.difficulty = 0;
	}
	
	public void setScoreSheet(int rightOrWrong){

		for(int i = getNumQuestions(); i < questions.length; i++) {
			questions[i] = rightOrWrong;
		}	
	}
	
	public int[] getScoreSheet(){
		return this.questions;
	}
	
	public int calculateGrade(int[] questions) {
		
		int sum = 0;
		for(int i = 0; i < questions.length; i++) {
			sum += questions[i];
		}
		return sum*10;
	}
	
	public void setCurrentTest(String currentTest) {
		this.currentTest = currentTest;
	}
	
	public String getCurrentTest() {
		return this.currentTest;
	}
	
	
	
}
