/**
 * 
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entitiy.Marks;
import com.entitiy.Subject;

import database.utility.ConnectionJDBCFactory;

/**
 * @author lisa
 *
 */
public class SubjectDaoImpl implements SubjectDao{
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
	public Marks save_Marks(Marks marks) {
		PreparedStatement ps=null;
		int s=0;
		Marks marks_=null;
		try {
			String sql="insert into mark values(?,?,?,?)";
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
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Subject>list=new ArrayList<>();
		Subject subject_=null;
		Marks marks=null;
		String sql="select distinct Subject_Name,Marks,Grade from subjects join mark on Sub_ID=Marks_ID order by Marks_ID limit 5";
		try {
			conn=ConnectionJDBCFactory.getInstance().getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				subject_=new Subject();
				subject_.setSubject_Name(rs.getString("Subject_Name"));
				marks=new Marks();
				marks=subject_.getMarks();
				marks.setMarks(rs.getInt("Marks"));
				marks.setGrade(rs.getString("Grade"));
				list.add(subject_);
			}
		} catch (Exception e) {
		  System.out.println(e.getMessage());
		}
		return list;
	}

	@Override
	public int update_Subjects(Subject subject) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete_subject(Subject subject) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int upadte_Marks(Marks marks) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Marks> getFullListOfMarks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete_Marks(Marks marks) {
		// TODO Auto-generated method stub
		
	}
	
	

}
