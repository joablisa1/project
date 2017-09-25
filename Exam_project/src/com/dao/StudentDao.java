/**
 * 
 */
package com.dao;

import java.util.List;

import com.entitiy.Student;


/**
 * @author lisa
 *
 */
public interface StudentDao {
	public Student save_Student(Student student);
	public List<Student> getAllStudent();
	public long update_Student(Student student);
	public List<Student>getStudentByAdm(int adm_number);
	public long getStudentByAdmission(int adm_number);
	public void getStudentByAdmAndName(String firstName,String lastName);
	public void delete(Student Student);

}
