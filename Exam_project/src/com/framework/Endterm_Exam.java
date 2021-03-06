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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.abstractmodel.WmvcFrames;
import com.dao.EndTermDaoImpl;
import com.dao.SubjectDaoImpl;
import com.entitiy.Marks;
import com.entitiy.Marks3;
import com.entitiy.Subject;

/**
 * @author lisa
 * 
 */
@SuppressWarnings("serial")
public class Endterm_Exam extends JDialog implements ActionListener {

	private static Endterm_Exam subjectform = null;
	private JLabel subjectLabel = new JLabel("Subject Name:");
	private JLabel countyLabel = new JLabel("Subject Publisher's Name:");
	private JLabel markslJLabel = new JLabel("Marks Scored:");
	private JLabel datetakenJLabel = new JLabel("Date Taken:");

	private DateFormat dft = new SimpleDateFormat("dd-MM-YYYY");
	private String date = dft.format(new Date());

	private JTextField subjectField = new JTextField(20);
	private JTextField countyfField = new JTextField(20);
	private JTextField marksscroedfField = new JTextField(7);
	private JTextField datetakenfiField = new JTextField(date);

	private JButton add_button = new JButton("OK");
	private JButton clear_button=new JButton("Clear");
	private JButton exit_button = new JButton("Exit");

	private JPanel thePanel = null;
	private Box box = Box.createVerticalBox();

	EndTermDaoImpl db = null;

	public Endterm_Exam() {
		super(WmvcFrames.getTheFrame(), "EndTerm Exam Form", true);
		db = new EndTermDaoImpl();
	}

	public static Endterm_Exam getinstance() {
		if (subjectform != null) {
			subjectform = new Endterm_Exam();
		}
		return subjectform;

	}

	public void createGui() {
		thePanel = new JPanel();
		thePanel.setLayout(new GridLayout(5, 1, 4, 6));
		thePanel.setBorder(new TitledBorder("Add Subject"));
		thePanel.add(subjectLabel);
		thePanel.add(subjectField);

		thePanel.add(countyLabel);
		thePanel.add(countyfField);

		thePanel.add(datetakenJLabel);
		thePanel.add(datetakenfiField);

		thePanel.add(markslJLabel);
		thePanel.add(marksscroedfField);

		JPanel panelbutton = new JPanel();
		panelbutton.setLayout(new FlowLayout());
		panelbutton.setBorder(new TitledBorder("Button"));
		panelbutton.add(add_button);
		panelbutton.add(clear_button);
		panelbutton.add(exit_button);
		add_button.addActionListener(this);
		clear_button.addActionListener(this);
		exit_button.addActionListener(this);

		box.add(thePanel);
		box.add(Box.createGlue());
		box.add(panelbutton);

		add(box, BorderLayout.CENTER);
		add(box, BorderLayout.CENTER);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(400, 250);
		setLocation(500, 250);
		setVisible(true);
		pack();
		setLocationRelativeTo(box);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == add_button) {
			Subject subject = null;
			Subject subject_ = null;
			Marks3 marks = null;
			Marks3 marks_ = null;
			try {
				subject = new Subject();
				
				subject.setSubject_Name(subjectField.getText());
				subject.setSubject_publisher_name(countyfField.getText());
				subject_ = db.save_Subject(subject);
						
				marks = new Marks3();
				marks.setMarks(Integer.valueOf(marksscroedfField.getText()));
				marks.setDate_taken(datetakenfiField.getText());
				marks_ = db.save_Marks(marks);
				
				if (marks_.equals("") && subject_.equals("")) {
					JOptionPane.showMessageDialog(WmvcFrames.getTheFrame(),"Sorry record not saved in the databases");
				} else {
					JOptionPane.showMessageDialog(WmvcFrames.getTheFrame(),"Successfully saved");
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try {

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} else if (event.getSource() == exit_button) {
			dispose();
		}else if (event.getSource()==clear_button) {
			subjectField.setText(null);
			countyfField.setText(null);
			marksscroedfField.setText(null);	
		}

	}

}
