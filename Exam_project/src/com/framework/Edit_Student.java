/**
 * 
 */
package com.framework;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.abstractmodel.WmvcFrames;
import com.dao.StudentDaoModelImpl;
import com.entitiy.Student;

/**
 * @author lisa
 * 
 */
@SuppressWarnings("serial")
public class Edit_Student extends JDialog implements ActionListener  {
	private static Edit_Student theAdmisson = null;
	private JTextField firstNameTextField = new JTextField(20);
	private JTextField lastNameTextField = new JTextField(20);
	private JTextField dobNameTextField = new JTextField(20);
	private JTextField admNameTextField = new JTextField(20);
	private JTextField addressNameTextField = new JTextField(20);
	private JTextField parentNameTextField = new JTextField(20);
	private JTextField phoneNameField = new JTextField(20);
	private JComboBox gender = new JComboBox();
	private JTextField admittedClassField=new JTextField(20);
	private JButton add_Button = new JButton("Update");
	private JButton cancel_button = new JButton("Exit");
	private JPanel thePanel = null;
	private Box box = Box.createVerticalBox();
	private JTextField findTextField=new JTextField(12);
	private JButton find_Button=new JButton("Find");
	private JTextField joined_date=new JTextField();
    private StudentDaoModelImpl  db=null;
    private Student students_;
    private JButton searchtable=new JButton("Search");
    Student student=null;
    
	public Edit_Student() {
		super(WmvcFrames.getTheFrame(), "Edit Student", true);
        db=new StudentDaoModelImpl();
	}
	static public Edit_Student getInstance() {
		if (theAdmisson == null) {
			theAdmisson = new Edit_Student();
		}
		return theAdmisson;
	}

	public void createGui(){
		JPanel findPanel=new JPanel();
		findPanel.setLayout(new FlowLayout());
		findPanel.add(new JLabel("Edit By Admission Number:"));
		findPanel.setBorder(new TitledBorder("Edit"));
		findPanel.add(findTextField);
		findPanel.add(find_Button);
		
		thePanel = new JPanel();
		thePanel.setLayout(new GridLayout(10, 1, 3, 5));
		thePanel.setBorder(new TitledBorder("Personal Detalis"));
		thePanel.add(new JLabel("First Name:"));
		thePanel.add(firstNameTextField);

		thePanel.add(new JLabel("Last Name:"));
		thePanel.add(lastNameTextField);

		thePanel.add(new JLabel(" D.O.B"));
		thePanel.add(dobNameTextField);

		thePanel.add(new JLabel("Student Admission Number:"));
		thePanel.add(admNameTextField);
		admNameTextField.setEditable(false);

		thePanel.add(new JLabel("Gender:"));
		thePanel.add(gender);

		thePanel.add(new JLabel("Address:"));
		thePanel.add(addressNameTextField);

		thePanel.add(new JLabel("Parent Name:"));
		thePanel.add(parentNameTextField);

		thePanel.add(new JLabel("Phone Number:"));
		thePanel.add(phoneNameField);
		
		thePanel.add(new JLabel("Enrolled In Class:"));
		thePanel.add(admittedClassField);
		
		thePanel.add(new JLabel("Date Enrolled:"));
		thePanel.add(joined_date);
		joined_date.setEditable(false);

		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout());
		pane.setBorder(new TitledBorder("Button"));
		pane.add(add_Button);
		pane.add(cancel_button);
		pane.add(searchtable);
		
		find_Button.addActionListener(this);
		add_Button.addActionListener(this);
		cancel_button.addActionListener(this);
		searchtable.addActionListener(this);
		
		box.add(findPanel);
		box.add(Box.createGlue());
		box.add(thePanel);
		box.add(pane);

		add(box, BorderLayout.CENTER);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(410, 490);
		setLocation(500, 150);
		setVisible(true);
		pack();
		setLocationRelativeTo(box);
	}
	public Student showDialog(Component comp,Student std){
		if(theAdmisson==null && std==null)
			return null;
		 student=std;
		
		firstNameTextField.setText(std.getFirstName());
		lastNameTextField.setText(std.getLastName());
		dobNameTextField.setText(std.getDateofBirth());
		admNameTextField.setText(""+ std.getAdm_number());
		joined_date.setText(std.getDate());
		gender.addItem(std.getGender().toString());
		gender.setEditable(true);
		addressNameTextField.setText(std.getAddress());
		parentNameTextField.setText(std.getParent_name());
		phoneNameField.setText(std.getPhone_Number());
		admittedClassField.setText(std.getEnrolled_class());
		
		return std;
		
	}
	@Override
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource()==add_Button){
			
			long s=0;
			try {
				  student=new Student();
		          student.setFirstName(firstNameTextField.getText());
		          student.setLastName(lastNameTextField.getText());
		          student.setDateofBirth(dobNameTextField.getText());
     	          student.setAdm_number(Integer.parseInt(admNameTextField.getText()));
		          student.setDate(joined_date.getText());
		          student.setGender(gender.getSelectedItem().toString());
		          student.setAddress(addressNameTextField.getText());
		          student.setParent_name(parentNameTextField.getText());
		          student.setPhone_Number(phoneNameField.getText());
		          student.setEnrolled_class(admittedClassField.getText());
		          students_=student;
		          
		          s=db.update_Student(student);
		          if(s>0){
		        	  JOptionPane.showConfirmDialog(WmvcFrames.getTheFrame(), "Sucessfully Updated","Success",JOptionPane.OK_OPTION); 
		          }else {
		        	  JOptionPane.showConfirmDialog(WmvcFrames.getTheFrame(), "Sorry!! there was a problem updating this record try Again","Message !!!",JOptionPane.WARNING_MESSAGE); 
				}
				
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(WmvcFrames.getTheFrame(), "Sorry We have a problem with the databases",e.getMessage(),JOptionPane.ERROR_MESSAGE);
			}
			
			
			
		}else if (ev.getSource()==cancel_button) {
          dispose();			
		}else if (ev.getSource()==find_Button) {
			 Student std=new Student();
			 List<Student>result=new ArrayList<>();
			 int admn=Integer.valueOf(findTextField.getText());
			try {
				result=db.getStudentByAdm(admn);
				for(int i=0;i<result.size();i++){
					std=result.get(i);
					firstNameTextField.setText(std.getFirstName());
					lastNameTextField.setText(std.getLastName());
					dobNameTextField.setText(std.getDateofBirth());
					admNameTextField.setText(""+ std.getAdm_number());
					joined_date.setText(std.getDate());
					gender.addItem(std.getGender().toString());
					gender.setEditable(true);
					addressNameTextField.setText(std.getAddress());
					parentNameTextField.setText(std.getParent_name());
					phoneNameField.setText(std.getPhone_Number());
					admittedClassField.setText(std.getEnrolled_class());
				}
				
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(WmvcFrames.getTheFrame(), "Sorry We have a problem with the databases",e.getMessage(),JOptionPane.ERROR_MESSAGE);
			}
		}else if (ev.getSource()==searchtable) {
			setVisible(false);
			new SearchStudentForm();
		}
		
	}

	

}
