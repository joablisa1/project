/**
 * 
 */
package com.framework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.text.MessageFormat;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumn;

import com.abstractmodel.WmvcFrames;

/**
 * @author lisa
 *
 */
@SuppressWarnings("serial")
public class DisplayRegisteredStudent  extends JDialog implements ActionListener{
	private static DisplayRegisteredStudent displaystudent=null;
	private ResultSetTableModel tableModel=null;
	private JTable table=null;
	private static Connection conn=null;
	static final String DRIVER ="com.mysql.jdbc.Driver";
	static final String DATABASE_URL="jdbc:mysql://localhost/masabaexam";
	static final String username="root";
	static final String password="root";
	
	private JLabel title=new JLabel("ADMISSION LIST FOR ALL THE STUDENT");
	
	private JPanel thePanel=null;
	
	private Box box =Box.createVerticalBox();
	static JScrollPane scroll=null;
	private TableColumn column = null;
	
	private JButton printbutton=new JButton("Print List");
    
	static final String DEFAULT_QUERY="select * from students ";
	
	public DisplayRegisteredStudent(){
		super(WmvcFrames.getTheFrame(), "Registered Student List",true);
		table=new JTable();
		 displayTable();	
	}
	private void displayTable() {
		try {
			thePanel=new JPanel();
			thePanel.setLayout(new GridLayout(2, 1,2,3));
			thePanel.add(title);
			thePanel.add(printbutton);
			printbutton.addActionListener(this);
			try {
				tableModel=new ResultSetTableModel(DRIVER, DATABASE_URL, username, password, DEFAULT_QUERY);
				try {
					tableModel.setQuery(DEFAULT_QUERY);
				} catch (Exception e) {
				
				}
			} catch (Exception e) {
				
			}
			table=new JTable(tableModel);
			tableModel.fireTableDataChanged();
	        table.setPreferredScrollableViewportSize(new Dimension(1020, 460));
	        table.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        table.setShowHorizontalLines(true);
	        table.setSelectionBackground(Color.gray);
			table.setFillsViewportHeight(true);
			table.addNotify();
			table.setAutoCreateColumnsFromModel(true);
	        
	        scroll = new JScrollPane(table);
	  
	        JPanel paneltable=new JPanel();
			paneltable.setLayout(new FlowLayout());
			paneltable.setBorder(new TitledBorder("list"));
			paneltable.add(scroll);
			box.add(thePanel);
			box.add(Box.createHorizontalGlue());
			box.add(paneltable);
			add(box,BorderLayout.NORTH);
			
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
			e.getMessage();
		}
		setSize(1050, 600);
 		setResizable(true);
 		setLocation(560,150);
 		setLocationRelativeTo(null);
 		setVisible(true);
	}
	public static DisplayRegisteredStudent getInstance(){
		if(displaystudent !=null){
			displaystudent=new DisplayRegisteredStudent();
		}
		return displaystudent;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		MessageFormat header=new MessageFormat("MASABA PRIMARY SCHOOL LIST");
		try {
			table.print(JTable.PrintMode.FIT_WIDTH, header, null);
			table.setBorder(null);
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
