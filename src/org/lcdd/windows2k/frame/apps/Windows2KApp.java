package org.lcdd.windows2k.frame.apps;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

public abstract class Windows2KApp {

	public String name;
	public ImageIcon icon;
	
	public Windows2KApp(String name, ImageIcon icon) {
		
	}
	
	public abstract JInternalFrame createFrame();
	
}
