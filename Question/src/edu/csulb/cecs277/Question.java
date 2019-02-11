package edu.csulb.cecs277;

/**
 *  models a question object with correct answer and a means to check
 *  if that answer is correct
 * **/
public class Question {
	
	private String question;
	private String answer;
	
	/**
	 * creates an empty question object
	 * **/
	public Question(String question) {
		this.question = question;

	}
	
	/**
	 * creates a question object with a correct answer
	 * @param question - String the question to be asked
	 * @param answer - String the answer to this question
	 * **/
	public Question(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}
	
	/**
	 * updates this question
	 * @param question - the new question
	 * **/
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * updates the answer to this question
	 * @param answer - the answer to this question
	 * **/
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	/**
	 * gets the correct answer to this question
	 * @return the answer as a String
	 * **/
	public String getAnswer() {
		return this.answer;
	}
	
	
	/**
	 * determines whether a given answer is correct
	 * @return boolean true if the answer given for this question is correct
	 * false otherwise
	 * **/
	public boolean checkAnswer(String answer) {
		return this.answer.equalsIgnoreCase(answer);
	}
	
	/**
	 * displays this question without the correct answer.
	 * **/
	public void display() {
		System.out.println( "Q: " + this.question );
	}
	

	
}
