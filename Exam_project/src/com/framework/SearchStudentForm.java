/**
 * 
 */
package com.framework;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.abstractmodel.WmvcFrames;

import database.utility.ConnectionJDBCFactory;

/**
 * @author lisa
 * 
 */
@SuppressWarnings("serial")

public class SearchStudentForm extends JDialog implements ActionListener {
	private static SearchStudentForm instances = null;
	private JTextField findrecord=new JTextField(10);
	private JPanel thePanel=null;
	private static JTable  table=null;
	private TableColumn column=new TableColumn(10);
	private JButton searchButton=new JButton("Find");
	private String[]columnNames={"S/NO","First Name", "Last Name", "Date Of Birth","Joined Date", "Gender", "Parent Name", "Address", "Phone Number", "Enrolled Class"};
    private Box box=Box.createVerticalBox();
    
    private static DefaultTableModel model = new DefaultTableModel();
    
    private JScrollPane scroll=null;
    static String Student_ID, First_Name, Last_Name, DateOfBirth,Joined_date, Gender, Parent_Name, Address, Phone_Number, Enrolled_Class;
	public SearchStudentForm() {
		super(WmvcFrames.getTheFrame(), "Search student", true);
		showTableData();
		
	}
	public void showTableData() {
		thePanel=new JPanel();
		thePanel.setLayout(new FlowLayout());
		thePanel.add(new JLabel("Search Student By Admission Number:"));
		thePanel.add(findrecord);
		thePanel.add(searchButton);
		searchButton.addActionListener(this);
		table=new JTable();
		scroll=new JScrollPane(table);
		
		JPanel thepanel=new JPanel();
		thepanel.add(scroll);
		
		box.add(thePanel);
		box.add(thepanel);
		
		add(box,BorderLayout.CENTER);
	    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(1050, 600);
 		setResizable(true);
 		setLocation(560,150);
 		setLocationRelativeTo(null);
 		setVisible(true);
		
	}
	public static SearchStudentForm getInstances() {
		if (instances != null) {
			instances = new SearchStudentForm();
		}
		return instances;
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource()==searchButton){
			displayDataForm();
		}
	}
	private void displayDataForm() {
		PreparedStatement ps=null;
		Connection conn=null;
		ResultSet rs=null;
		model.setColumnIdentifiers(columnNames);
		model.fireTableDataChanged();
		table.setModel(model);
		table.setPreferredScrollableViewportSize(new Dimension(1020, 460));
		table.setFillsViewportHeight(true);
		table.addNotify();
		
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		String sql="Select  Student_ID, First_Name, Last_Name, DateOfBirth, Joined_date, Gender, Parent_Name, Address, Phone_Number, Enrolled_Class from students where ADM_NO=? order by Student_ID";
		int j=0;
		
		try {
			conn=ConnectionJDBCFactory.getInstance().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, findrecord.getText());
			rs=ps.executeQuery();
			ps.clearWarnings();
			while(rs.next()){
					Student_ID=rs.getString(1);
					First_Name=rs.getString(2);
					Last_Name=rs.getString(3);
					DateOfBirth=rs.getString(4);
					Joined_date=rs.getString(5);
					Gender=rs.getString(6);
					Parent_Name=rs.getString(7);
					Address=rs.getString(8);
					Phone_Number=rs.getString(9);
					Enrolled_Class=rs.getString(10);
					model.addRow(new Object[]{Student_ID,First_Name,Last_Name,DateOfBirth,Joined_date,Gender,Parent_Name,Address,Phone_Number,Enrolled_Class});
					j++;
			}
			 if (j < 1) 
			 {
				 JOptionPane.showMessageDialog(WmvcFrames.getTheFrame(), "No Record Found", "Error", JOptionPane.ERROR_MESSAGE); 
			 } 
			if(j==1){
				 JOptionPane.showMessageDialog(WmvcFrames.getTheFrame(), "Successfully found", "Success", JOptionPane.QUESTION_MESSAGE); 
		    	}
			 for(int i=0;i<10;i++){
			   		column=table.getColumnModel().getColumn(i);
						if(i==0){
							column.setPreferredWidth(20);
						}
						if(i==1){
							column.setPreferredWidth(20);
						}
						if(i==2){
							column.setPreferredWidth(30);
						}
						if(i==3){
							column.setPreferredWidth(40);
						}
						if(i==4){
							column.setPreferredWidth(50);
						}
						if(i==5){
							column.setPreferredWidth(30);
						}
						if(i==6){
							column.setPreferredWidth(40);
						}
						if(i==7){
							column.setPreferredWidth(70);
						}
						if(i==8){
							column.setPreferredWidth(80);
						}
						if(i==9){
							column.setPreferredWidth(90);
						}
						if(i==10){
							column.setPreferredWidth(60);
						}
					}
			
		} catch (Exception e) {
		
		}finally{
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e2) {
				
			}
		}	
	}
}
