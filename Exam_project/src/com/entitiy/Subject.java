/**
 * 
 */
package com.entitiy;

/**
 * @author lisa
 *
 */
public class Subject {
	private int subject_ID=0;
	private int student_adm;
	private String subject_Name;
	private String Subject_publisher_name;
	private int ID=1;
	private Marks marks;
	public int getSubject_ID() {
		return subject_ID;
	}
	public void setSubject_ID(int subject_ID) {
		subject_ID=ID++;
		this.subject_ID = subject_ID;
	}
	public int getStudent_adm() {
		return student_adm;
	}
	public void setStudent_adm(int student_adm) {
		this.student_adm = student_adm;
	}
	public String getSubject_Name() {
		return subject_Name;
	}
	public void setSubject_Name(String subject_Name) {
		this.subject_Name = subject_Name;
	}
	
	
	public String getSubject_publisher_name() {
		return Subject_publisher_name;
	}
	public void setSubject_publisher_name(String subject_publisher_name) {
		Subject_publisher_name = subject_publisher_name;
	}
	public Marks getMarks() {
		return marks;
	}
	public void setMarks(Marks marks) {
		this.marks = marks;
	}
	
	

}
