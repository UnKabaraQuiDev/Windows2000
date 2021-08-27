package org.lcdd.windows2k.frame.desktop;

import java.awt.Color;
import java.awt.Image;

import javax.swing.JDesktopPane;

import org.lcdd.windows2k.frame.Windows2KFrame;

@SuppressWarnings("serial")
public class Windows2KFrameDesktop extends JDesktopPane {
	
	private Image image;
	private Windows2KFrame frame;
	
	public Windows2KFrameDesktop(Windows2KFrame frame, Image img) {
		super.setBounds(0, 0, (int) frame.getBounds().getWidth(), (int) frame.getBounds().getHeight());
		super.setBackground(new Color(57, 107, 165));
		
		this.image = img;
		this.frame = frame;
	}
	
	public Image getImage() {return image;}
	public void setImage(Image image) {this.image = image;}
	
}
