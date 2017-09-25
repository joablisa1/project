/**
 * 
 */
package com.dao;

import java.util.List;

import com.entitiy.Marks2;
import com.entitiy.Subject;

/**
 * @author lisa
 *
 */
public interface MidtermDao {
	public  Subject save_Subject(Subject subject);
	public  Marks2 save_Marks(Marks2 marks);
	public List<Subject>getFullSubjectForStudent();
	public int update_Subjects(Subject subject);
	public int delete_subject(Subject subject);
	public int upadte_Marks(Marks2 marks);
	public List<Marks2>getFullListOfMarks();
	public void delete_Marks(Marks2 marks);

}
