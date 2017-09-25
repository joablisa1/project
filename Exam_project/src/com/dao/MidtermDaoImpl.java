/**
 * 
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.entitiy.Marks2;
import com.entitiy.Subject;

import database.utility.ConnectionJDBCFactory;

/**
 * @author lisa
 *
 */
public class MidtermDaoImpl implements MidtermDao{
   private Connection conn=null;
	@Override
	public Subject save_Subject(Subject subject) {
		PreparedStatement ps=null;
		int s=0;
		Subject subject_=null;
		try {
			String sql="insert into subjects values(null,?,?)";
			conn=ConnectionJDBCFactory.getInstance().getConnection();
			ps=conn.prepareStatement(sql);
		//	ps.setInt(1, subject.getSubject_ID());
		//	ps.setInt(2, subject.getStudent_adm());
			ps.setString(1, subject.getSubject_Name());
			ps.setString(2, subject.getSubject_publisher_name());
			s=ps.executeUpdate();
			if(s>0){
				return subject_=subject;
			}	
		} catch (Exception e) {
		System.out.println(e.getMessage());
		}
		return subject_;
	}

	@Override
	public Marks2 save_Marks(Marks2 marks) {
		PreparedStatement ps=null;
		int s=0;
		Marks2 marks_=null;
		try {
			String sql="insert into marks2 values(?,?,?,?)";
			conn=ConnectionJDBCFactory.getInstance().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, marks.getMarks_ID());
			ps.setInt(2, marks.getMarks());
			ps.setString(3, marks.getGrade());
			ps.setString(4, marks.getDate_taken());
			s=ps.executeUpdate();
			if(s>0){
				return marks_=marks;	
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return marks_;
	}

	@Override
	public List<Subject> getFullSubjectForStudent() {
	
		return null;
	}

	@Override
	public int update_Subjects(Subject subject) {
	
		return 0;
	}

	@Override
	public int delete_subject(Subject subject) {
		
		return 0;
	}

	@Override
	public int upadte_Marks(Marks2 marks) {
		
		return 0;
	}

	@Override
	public List<Marks2> getFullListOfMarks() {
		
		return null;
	}

	@Override
	public void delete_Marks(Marks2 marks) {
		
		
	}
	
	

}
