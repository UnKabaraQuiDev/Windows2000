package org.lcdd.windows2k.frame.apps;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

public abstract class Windows2KApp {

	public List<JInternalFrame> openedFrames = new ArrayList<>();
	
	public String name;
	public ImageIcon icon;
	
	public Windows2KApp(String name, ImageIcon icon) {
		this.name = name;
		this.icon = icon;
	}
	
	public abstract JInternalFrame createFrame();
	
	protected void registerFrame(JInternalFrame frame) {
		openedFrames.add(frame);
	}
	
}
