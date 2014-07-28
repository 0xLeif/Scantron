package org.mpsomaha.java.zeriksen787.scantron.logic;

import java.util.ArrayList;

public class Exam {
	private  String title;
	private  ArrayList<String> key;
	private static  ArrayList<Submission> submissions;
	
		public Exam(String title, ArrayList<String> key){
			this.title = title;
			this.key = key;
			submissions = null;
		}
		public void grade(ArrayList<Submission> submissions){
			Exam.submissions = submissions;
			//Iterate over submissions
			for(Submission s : submissions){
				//Grade submissions
				s.grade(this);
				System.out.println(s + "\n");
			}
		}
		public ArrayList<String> getKey(){
			return key;
		}
		public int getMaxScore(){
			int max = 0;
			for (Submission a : submissions) {
				int score = a.getResult().getNumCorrect();
					if(score <= max){
						max = score;
				}
			}
			return max;
		}
		public int getMinScore(){
			int min = 1000;
			for (Submission a : submissions) {
				int score = a.getResult().getNumCorrect();
					if(score <= min){
						min = score;
				}
			}
			return min;
		}
		public static int getModeScore(ArrayList<Submission> submissions) {
			ArrayList<Integer> scores = new ArrayList<Integer>();
			for(Submission s : submissions){
				scores.add(s.getResult().getNumCorrect());
				}
			int maxValue = 0;
			int maxCount = 0;
			
			for(int i = 0; i < scores.size(); i++){
				int count = 0;
				
				for(int j = 0; j<scores.size();j++){
					if(scores.get(j) == scores.get(i)){
					count++;
				}
					if(count>maxCount){
						maxCount = count;
						maxValue = scores.get(i);
						}
					}
			}
			return maxValue;
			}

		public double getAvgScore() {
			double total = 0;
			for (Submission a : submissions) {
					double score = a.getResult().getNumCorrect();
			    	total = score;
				}
			return total/submissions.size();
		}
		public String toString(){
			String summary = "Title:\t" + title;
			summary += "\nKey answers:\t[";
			for(String answer : key) {
				summary += answer + ",";
		}
			summary = summary.substring(0,summary.length()-1);
			summary += "]";
			
			for(Submission s : submissions){
				summary += s + "\n";
			}
			return summary;
	}

}