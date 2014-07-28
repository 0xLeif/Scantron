package test;

import java.util.ArrayList;

import org.mpsomaha.java.zeriksen787.scantron.data.File;
import org.mpsomaha.java.zeriksen787.scantron.logic.Exam;
import org.mpsomaha.java.zeriksen787.scantron.logic.Submission;

public class Test {
	public static void main(String[] args) {
		Exam exam = File.getExam("data/sample1");
		ArrayList<Submission> subs = File.getSubmissions("data/sample1");
		
		exam.grade(subs);
	}
}
