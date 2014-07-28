package org.mpsomaha.java.zeriksen787.scantron.logic;

import java.util.ArrayList;

public class Result{
	private ArrayList<Boolean> correct;
	private int numCorrect;
	private int numIncorrect;
	private int questions;
	
	public Result(ArrayList<Boolean>grade){
		numCorrect = 0;
		numIncorrect = 0;
		questions = 0;
		for(Boolean a : grade){
			if(a.equals(true)){
				numCorrect++;
				questions++;
			}else{
				numIncorrect++;
				questions++;
			}
		}
		double percent = (numCorrect*100 / questions);
		String summary = "Correct: " + numCorrect;
			summary += "\n" + "Incorrect: " + numIncorrect;
			summary += "\n" + "Questions: " + questions;
			summary += "\n" + "Percent Correct: " + percent + "%";
		System.out.println(summary);
	}
	public int getNumCorrect(){
		return numCorrect;
	}
	public int getNumIncorrect(){
		return numIncorrect;
	}
	public int getQuestions(){
		return questions;
	}
}