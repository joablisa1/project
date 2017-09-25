/**
 * 
 */
package com.framework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

import com.abstractmodel.WmvcFrames;
import com.dao.StudentDaoModelImpl;



/**
 * @author lisa
 *
 */
@SuppressWarnings("serial")
public class MainView extends JMenu{

	private JToolBar toolbar=new JToolBar();
	private Edit_Student edit_executor=null;
	private StudentDaoModelImpl myModel=new StudentDaoModelImpl();
	public MainView(){
      createControls();
	}
	private void createControls() {
		JMenu fileMenu=new JMenu("File");
		JMenuItem menuItem=new JMenuItem("New Student");
		fileMenu.add(menuItem);
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				StudentAdmission admission=new StudentAdmission();
				admission.createGui();
			}
		});
		
		JMenuItem memberlist=new JMenuItem("Select All Student");
		fileMenu.add(memberlist);
		memberlist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DisplayRegisteredStudent();
			}
		});
		
		JMenuItem memberprint=new JMenuItem("Print Student List");
		fileMenu.add(memberprint);
		memberprint.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DisplayRegisteredStudent();
			}
		});
		
		JMenuItem memberClose=new JMenuItem("Close");
		fileMenu.add(memberClose);
		memberClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenu editstudent=new JMenu("Edit");
        JMenuItem edit=new JMenuItem("Edit Student....");
		editstudent.add(edit);
		edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				edit_executor=new Edit_Student();
				edit_executor.createGui();
				
			}
		});
		
		 JMenuItem addsubject=new JMenuItem("Openner Exam ....");
		 editstudent.add(addsubject);
		 addsubject.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				SubjectForm subject=new SubjectForm();
				subject.createGui();
				
			}
		});
		 
		 JMenuItem midtermsubject=new JMenuItem("Add Midterm Exam ....");
		 editstudent.add(midtermsubject);
		 midtermsubject.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Midterm_Exams midterm=new Midterm_Exams();
				midterm.createGui();
			}
		});
		 
		 JMenuItem endtermsubject=new JMenuItem("Add Endterm Exam ....");
		 editstudent.add(endtermsubject);
		 endtermsubject.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Endterm_Exam endterm=new Endterm_Exam();
				endterm.createGui();
			}
		});
		WmvcFrames.addMenu(fileMenu);
		
		WmvcFrames.addMenu(editstudent);
		JButton toolButton=new JButton("Open");
		toolbar.add(toolButton);
		toolButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent event) {
				StudentAdmission admission=new StudentAdmission();
				admission.createGui();
				
			}
		});
		WmvcFrames.getTheToolBar().add(toolbar);
	}

}
