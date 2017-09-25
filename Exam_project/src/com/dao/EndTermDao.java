/**
 * 
 */
package com.dao;

import java.util.List;

import com.entitiy.Marks;
import com.entitiy.Marks3;
import com.entitiy.Subject;

/**
 * @author lisa
 *
 */
public interface EndTermDao {
	public  Subject save_Subject(Subject subject);
	public  Marks3 save_Marks(Marks3 marks);
	public List<Subject>getFullSubjectForStudent();
	public int update_Subjects(Subject subject);
	public int delete_subject(Subject subject);
	public int upadte_Marks(Marks3 marks);
	public List<Marks3>getFullListOfMarks();
	public void delete_Marks(Marks3 marks);

}
