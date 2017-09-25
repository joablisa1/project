/**
 * 
 */
package com.dao;

import java.util.List;

import com.entitiy.Marks;
import com.entitiy.Subject;

/**
 * @author lisa
 *
 */
public interface SubjectDao {
	public  Subject save_Subject(Subject subject);
	public  Marks save_Marks(Marks marks);
	public List<Subject>getFullSubjectForStudent();
	public int update_Subjects(Subject subject);
	public int delete_subject(Subject subject);
	public int upadte_Marks(Marks marks);
	public List<Marks>getFullListOfMarks();
	public void delete_Marks(Marks marks);

}
