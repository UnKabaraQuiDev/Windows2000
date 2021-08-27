package org.lcdd.windows2k.frame.desktop;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JDesktopPane;

import org.lcdd.windows2k.frame.Windows2KFrame;

@SuppressWarnings("serial")
public class Windows2KFrameDesktop extends JDesktopPane {
	
	private Image image;
	private Windows2KFrame frame;
	
	public Windows2KFrameDesktop(Windows2KFrame frame, Image img) {
		super.setBounds(0, 0, (int) frame.getBounds().getWidth(), (int) frame.getBounds().getHeight());
		super.setBackground(Color.BLACK);
		
		this.image = img;
		this.frame = frame;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage((Image) image, 0, 0, Color.BLUE, null);
		super.paintComponent(g);
	}
	
	public Image getImage() {return image;}
	public void setImage(Image image) {this.image = image;}
	
}
