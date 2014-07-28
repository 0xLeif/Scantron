package org.mpsomaha.java.zeriksen787.scantron.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.mpsomaha.java.zeriksen787.scantron.logic.Exam;
import org.mpsomaha.java.zeriksen787.scantron.logic.Submission;

public class File {
	public static Exam getExam(String dir) {
		String path = dir + "/key.txt";
		Exam exam = null;
		try {
			// Open file
			BufferedReader in = new BufferedReader(new FileReader(path));
			// Read the file
			String title = in.readLine();
			String line;
			ArrayList<String> key = new ArrayList<String>();
			while ((line = in.readLine()) != null) {
				// Read the first line as the exam name
				key.add(line);
			}
			// Loop through remaining lines;
			// storing each line as an answer
			// in the ArrayList of answers
			// Close the file
			in.close();
			// Create Exam object
			exam = new Exam(title, key);

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return exam;
	}

	public static ArrayList<Submission> getSubmissions(String dir) {
		int i = 1;
		ArrayList<Submission> submissions = new ArrayList<Submission>();
		while (true) {
			//String path = dir + "/" + i++ + ".txt";

			try {
				// Open file
				BufferedReader in = new BufferedReader(new FileReader(dir + "/"
						+ i++ + ".txt"));
				// Read the file
				String student = in.readLine();
				String line;
				ArrayList<String> answers = new ArrayList<String>();
				while ((line = in.readLine()) != null) {
					// Read the first line as the exam name
					// Loop through remaining lines;
					// storing each line as an answer
					// in the ArrayList of answers
					answers.add(line);
					}
				// Close the file
					in.close();

					Submission submission = new Submission(student, answers);
					submissions.add(submission);
				

				// Create submissions object
			} catch (FileNotFoundException e1) {
				break;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return submissions;
	}
}