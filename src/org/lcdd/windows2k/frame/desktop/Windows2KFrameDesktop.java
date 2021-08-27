package org.lcdd.windows2k.frame.desktop;

import java.awt.Color;

import javax.swing.JDesktopPane;

import org.lcdd.windows2k.frame.Windows2KFrame;

@SuppressWarnings("serial")
public class Windows2KFrameDesktop extends JDesktopPane {
	
	private Windows2KFrame frame;
	
	public Windows2KFrameDesktop(Windows2KFrame frame) {
		this.frame = frame;
		
		super.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
		super.setBounds(0, 0, (int) frame.getBounds().getWidth(), (int) frame.getBounds().getHeight());
		super.setBackground(new Color(57, 107, 165));
		super.setVisible(true);
	}
	
}
