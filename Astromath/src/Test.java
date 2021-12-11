
public class Test {
	public int difficulty;
	public int numQuestions;
	public int[] questions = new int[10];

	public Test(int difficulty, int numQuestions) {
		this.difficulty = difficulty;
		this.numQuestions = numQuestions;
		

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
	
	
	
}
