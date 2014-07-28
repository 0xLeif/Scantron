package org.mpsomaha.java.zeriksen787.scantron.ui;

import java.util.ArrayList;
import java.util.Scanner;

import org.mpsomaha.java.zeriksen787.scantron.data.File;
import org.mpsomaha.java.zeriksen787.scantron.logic.Exam;
import org.mpsomaha.java.zeriksen787.scantron.logic.Submission;

public class Console {
	public static void main(String[] args){
		String key = keyDirectory();
		String sub = subDirectory();
		Exam e = File.getExam(key);
		
		ArrayList<Submission> subs = File.getSubmissions(sub);
		e.grade(subs);
		System.out.println(e);
		System.out.println(subs);
		System.out.println("Enter yes if you would like to scan another test!");
		Scanner in = new Scanner(System.in);
		if(in.nextLine().equals("yes")){
			keyDirectory();
			subDirectory();
			ArrayList<Submission> subs2 = File.getSubmissions(sub);
			e.grade(subs2);
			System.out.println(e);
			System.out.println(subs2);
		} else {
			System.out.println("Thank you.");
		}
	}
	
	public static String keyDirectory(){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your key directory:");
		String keyDir = in.nextLine();
		return keyDir;
	}
	
	public static String subDirectory(){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your submission directory:");
		String subDir = in.nextLine();
		return subDir;
	}
}
