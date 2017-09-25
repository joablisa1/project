/**
 * 
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entitiy.Student;

import database.utility.ConnectionJDBCFactory;

/**
 * @author lisa
 *
 */
public class StudentDaoModelImpl implements StudentDao{
    private Connection conn=null;
	@Override
	public Student save_Student(Student student) {
		Student student_=null;
		int v=0;
		PreparedStatement ps=null;
		try {
			String sql = "insert into students values(null,?,?,?,?,?,?,?,?,?,?)";
			conn = ConnectionJDBCFactory.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, student.getFirstName());
			ps.setString(2, student.getLastName());
			ps.setString(3, student.getDateofBirth());
			ps.setInt(4, student.getAdm_number());
			ps.setString(5, student.getDate());
			ps.setString(6, student.getGender());
			ps.setString(7, student.getParent_name());
			ps.setString(8, student.getAddress());
			ps.setString(9, student.getPhone_Number());
			ps.setString(10,student.getEnrolled_class());
            v=ps.executeUpdate();
            if(v>0){
             student_=student;	
             System.out.println("Hi"+student.getFirstName()+"Your record is Successfully saved.");
           }else {
			System.out.println("Sorry the record is not saved..");
		   }
			
		   } catch (Exception e) {
			System.out.println(e.getMessage());
		   }finally{
			try {
				ps.close();
				conn.close();
			} catch (Exception e2) {
			
			}
		}
		return student_;
	}
	@Override
	public List<Student> getAllStudent() {
		PreparedStatement ps=null;
		List<Student> list=new ArrayList<>();
		String sql="Select * from students  order by Joined_date asc";
		Student student_=null;
		ResultSet rs=null;
		try {
			conn=ConnectionJDBCFactory.getInstance().getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				student_.setFirstName(rs.getString(1));
				student_.setLastName(rs.getString(2));
				student_.setDateofBirth(rs.getString(3));
				student_.setAdm_number(rs.getInt(4));
				student_.setDate(rs.getString(5));
				student_.setGender(rs.getString(6));
				student_.setParent_name(rs.getString(7));
				student_.setAddress(rs.getString(8));
				student_.setPhone_Number(rs.getString(9));
				student_.setEnrolled_class(rs.getString(10));
				list.add(student_);
			}
		} catch (Exception e) {
		
		}
		return list;
	}
	@Override
	public long update_Student(Student student) {
		long s=0;
		PreparedStatement ps=null;
		String sql="update students set First_Name='"+student.getFirstName()+"',Last_Name='"+student.getLastName()+"', DateOfBirth='"+student.getDateofBirth()+"',Joined_date='"+student.getDate()+"', Gender='"+student.getGender()+"', Parent_Name='"+student.getParent_name()+"', Address='"+student.getAddress()+"', Phone_Number='"+student.getPhone_Number()+"',Enrolled_Class='"+student.getEnrolled_class()+"' where ADM_NO=? order by Student_ID"; 
		try {
			conn=ConnectionJDBCFactory.getInstance().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, student.getAdm_number());
			s=ps.executeUpdate();
			if(s>0){
				System.out.println("Thank you for updating your record.");
			}else {
				System.out.println("Sorry this record is not updated..");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return s;
	}

	@Override
	public List<Student> getStudentByAdm(int adm_number) {
		PreparedStatement ps=null;
		List<Student> list=new ArrayList<>();
		String sql="Select * from students where ADM_NO=? order by Joined_date asc";
		Student student_=null;
		ResultSet rs=null;
		try {
			conn=ConnectionJDBCFactory.getInstance().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, adm_number);
			rs=ps.executeQuery();
			while(rs.next()){
				student_=new Student();
				student_.setFirstName(rs.getString("FIrst_Name"));
				student_.setLastName(rs.getString("Last_Name"));
				student_.setDateofBirth(rs.getString("DateOfBirth"));
				student_.setAdm_number(rs.getInt("ADM_NO"));
				student_.setDate(rs.getString("Joined_date"));
				student_.setGender(rs.getString("Gender"));
				student_.setParent_name(rs.getString("Parent_Name"));
				student_.setAddress(rs.getString("Address"));
				student_.setPhone_Number(rs.getString("Phone_Number"));
				student_.setEnrolled_class(rs.getString("Enrolled_Class"));
				list.add(student_);
			}	
		} catch (Exception e) {
			
		}
		return list;
	}

	@Override
	public void getStudentByAdmAndName(String firstName, String lastName) {
		
		
	}
	@Override
	public void delete(Student Student) {
		
		
	}
	@Override
	public long getStudentByAdmission(int adm_number) {
		PreparedStatement ps=null;
		String sql="Select * from students where ADM_NO=? order by Joined_date asc";
		Student student_=null;
		ResultSet rs=null;
		try {
			
			
		} catch (Exception e) {
		
		}
		return 0;
	}
	

}
