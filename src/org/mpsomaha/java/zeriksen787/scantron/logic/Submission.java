package org.mpsomaha.java.zeriksen787.scantron.logic;

import java.util.ArrayList;

public class Submission {
	private String student;
	private ArrayList<String> answers;
	private static Result result;
	private ArrayList<String> key;
	private Boolean correct;
	
	public Submission(String student, ArrayList<String> answers){
		this.student = student;
		this.answers = answers;
	}
	public void grade(Exam exam){
		key = exam.getKey();
		result = null;
		//Grade this submission
		ArrayList<Boolean> grade = new ArrayList<Boolean>();
		for(int i =0; i <answers.size(); i++){
			String answer = answers.get(i);
			String keys = key.get(i);
			if (answer.equals(keys)){
				grade.add(true);
			}else{
				grade.add(false);
			}
		}
		result = new Result(grade);
	}

	public String toString(){
		String summary = student + answers;
				summary += "\n" + "Key: " + key;
		return summary;
	}
	public ArrayList<String> getAnswers(){
		return answers;
	}
	public Result getResult() {
		return result;
	}
}
