/**
 * 
 */
package com.abstractmodel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

	/**
	 * @author lisa
	 *
	 */
	public abstract class WmvcFrames {
		private static WmvcFrames theApp=null;  // this class should be a singleton where we only need a single instance of the form
		protected static WmvcFrames  theModel=null;
		
		private static JFrame theFrame =null;
		private static JMenuBar theMenuBar=null;
		private static JToolBar theToolBar=null;
		private static JPanel theContentPanel=null;
		public static WmvcFrames getTheApp() {
			return theApp;
		}
		public static JFrame getTheFrame() {
			return theFrame;
		}
		public static JMenuBar getTheMenuBar() {
			return theMenuBar;
		}
		public static JToolBar getTheToolBar() {
			return theToolBar;
		}
		public static JPanel getTheContentPanel() {
			return theContentPanel;
		}
		public WmvcFrames(String aName,boolean cMenu,boolean cTool){
			if(theApp !=null)
				return;
				theApp=this;
				initializeWmvc(aName,cMenu,cTool);
		}
		private void initializeWmvc(String aName, boolean cMenu, boolean cTool) {
			theFrame=new JFrame(aName);
			theFrame.setLocation(350, 50);
			theFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			theFrame.setDefaultLookAndFeelDecorated(true);
			theFrame.setIconImage(new ImageIcon(getClass().getResource("images.jpg")).getImage());
			theFrame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e){
					if(theApp.appClosing()){
						System.exit(0);
					}
				}
			});
			if(cMenu){
				theMenuBar=new JMenuBar();
				theFrame.setJMenuBar(theMenuBar);
			}
			theContentPanel=new JPanel();
			theContentPanel.setLayout(new BorderLayout());
			theContentPanel.setPreferredSize(new Dimension(400, 300));
			
			if(cTool){
				theToolBar=new JToolBar();
				theContentPanel.add(theToolBar,BorderLayout.NORTH);
			}
			theFrame.add(theContentPanel);
		}
		public static void addMainPane(JComponent pane){
			theContentPanel.add(pane,BorderLayout.CENTER);
		}
		public static void addMenu(JMenu menu){
			if(theMenuBar==null)
				return;
			theMenuBar.add(menu);
		}
		public static void showApp(){
			theFrame.pack();
			theFrame.setVisible(true);
		}
		public boolean appClosing(){
			return true;
		}

	}


