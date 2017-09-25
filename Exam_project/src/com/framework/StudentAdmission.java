/**
 * 
 */
package com.framework;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
public class StudentAdmission extends JDialog implements ActionListener  {
	private static StudentAdmission theAdmisson = null;
	
	private DateFormat dft=new SimpleDateFormat("dd-MM-YYYY");
	private String date=dft.format(new Date());
	
	private DateFormat dfts=new SimpleDateFormat("dd-MM-YYYY");
	private String dates=dft.format(new Date());
	
	private JTextField firstNameTextField = new JTextField(20);
	private JTextField lastNameTextField = new JTextField(20);
	private JTextField dobNameTextField = new JTextField(date);
	private JTextField admNameTextField = new JTextField(20);
	private JTextField addressNameTextField = new JTextField(20);
	private JTextField parentNameTextField = new JTextField(20);
	private JTextField phoneNameField = new JTextField(20);
	
	private JComboBox gender = new JComboBox(new String[] { "Female", "Male" });
	private JTextField admittedClassField=new JTextField(20);
	private JButton add_Button = new JButton("OK");
	private JButton cancel_button = new JButton("Exit");
	private JPanel thePanel = null;
	private Box box = Box.createVerticalBox();
    private StudentDaoModelImpl db=null;
    
	public StudentAdmission() {
		super(WmvcFrames.getTheFrame(), "New Student", true);
       db=new StudentDaoModelImpl();
	}
	static public StudentAdmission getInstance() {
		if (theAdmisson != null) {
			theAdmisson = new StudentAdmission();
		}
		return theAdmisson;
	}
	public void createGui() {
		thePanel = new JPanel();
		thePanel.setLayout(new GridLayout(9, 1, 4, 5));
		thePanel.setBorder(new TitledBorder("add"));
		thePanel.add(new JLabel("First Name:"));
		thePanel.add(firstNameTextField);

		thePanel.add(new JLabel("Last Name:"));
		thePanel.add(lastNameTextField);

		thePanel.add(new JLabel(" D.O.B"));
		thePanel.add(dobNameTextField);

		thePanel.add(new JLabel("Student Admission Number:"));
		thePanel.add(admNameTextField);

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

		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout());
		pane.add(add_Button);
		pane.add(cancel_button);
		add_Button.addActionListener(this);
		cancel_button.addActionListener(this);
		box.add(thePanel);
		box.add(pane);

		add(box, BorderLayout.CENTER);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(380, 370);
		setLocation(500, 150);
		setVisible(true);
		pack();
		setLocationRelativeTo(box);
	}
	@Override
	public void actionPerformed(ActionEvent ev) {
		Student student_=null;
		if(ev.getSource()==add_Button){
          Student student=new Student();
          student.setFirstName(firstNameTextField.getText());
          student.setLastName(lastNameTextField.getText());
          student.setDateofBirth(dobNameTextField.getText());
          student.setAdm_number(Integer.valueOf(admNameTextField.getText()));
          student.setGender(gender.getSelectedItem().toString());
          student.setDate(dates);
          student.setAddress(addressNameTextField.getText());
          student.setParent_name(parentNameTextField.getText());
          student.setPhone_Number(phoneNameField.getText());
          student.setEnrolled_class(admittedClassField.getText());
          student_=db.save_Student(student);
          if(student.equals("")){
        	  JOptionPane.showMessageDialog(WmvcFrames.getTheFrame(), "Sorry Your record is not saved","Warning",JOptionPane.WARNING_MESSAGE);
          }else{
        	  JOptionPane.showMessageDialog(WmvcFrames.getTheFrame(), "Successfully Saved");
          }
		  clearField();
		  }else if (ev.getSource()==cancel_button) {
          dispose();			
		}
		
	}
	private void clearField() {
		firstNameTextField.setText(null);
		lastNameTextField.setText(null);
		dobNameTextField.setText(null);
		admNameTextField.setText(null);
		addressNameTextField.setText(null);
		parentNameTextField.setText(null);
		phoneNameField.setText(null);
		admittedClassField.setText(null);
		
	}

	

}
