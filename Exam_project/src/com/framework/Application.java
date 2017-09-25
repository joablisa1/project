/**
 * 
 */
package com.framework;

import java.awt.Dimension;

import com.abstractmodel.WmvcFrames;

/**
 * @author lisa
 *
 */
public class Application extends WmvcFrames {
   private MainView appview=null;
	public Application(String name){
		super(name, true, true);
		appview=new MainView();
		
	}

	public static void main(String[] args) {
		final Application application=new Application("STUDENT EXAMINATION SYSTEM");
		WmvcFrames.getTheContentPanel().setPreferredSize(new Dimension(670, 560));
		application.showApp();
		

	}

}
