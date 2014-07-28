package org.mpsomaha.java.zeriksen787.scantron.logic;

public class Student {
	private String firstName;
	private String lastName;
	private int year;
	
	public Student(String firstName, String lastName, int year) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.year = year;
	}
	public String toString(){
		return firstName + " " + lastName + " (" + year + ") ";
	}
}
