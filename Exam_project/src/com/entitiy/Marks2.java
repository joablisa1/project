/**
 * 
 */
package com.entitiy;

/**
 * @author lisa
 *
 */
public class Marks2{
	private int Marks_ID=0;
	private int marks;
	private String date_taken;
	private String grade;
	private Subject subject;
	private int ID=1;
	public int getMarks_ID() {
		return Marks_ID;
	}
	public void setMarks_ID(int marks_ID) {
		marks_ID=ID++;
		Marks_ID = marks_ID;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getDate_taken() {
		return date_taken;
	}
	public void setDate_taken(String date_taken) {
		this.date_taken = date_taken;
	}
	public String getGrade() {
		if(marks>=90){
			grade="A";
		}else if (marks>=80) {
			grade="A-";
		}else if(marks>=70){
			grade="B+";
		}else if(marks>=60){
			grade="B-";
		}else if(marks>=50){
			grade="C+";
		}else if(marks>=40){
			grade="C-";
		}else if(marks>=30){
			grade="D+";
		}else if(marks>=20){
			grade="D-";
		}else {
			grade="E";
		}
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	

}
