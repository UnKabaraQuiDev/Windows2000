package org.lcdd.windows2k.frame;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.lcdd.windows2k.frame.desktop.Windows2KFrameDesktop;

@SuppressWarnings("serial")
public class Windows2KFrame extends JFrame {

	public Windows2KFrame(String background) throws IOException {
		super("Windows 2000 Simulation");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setBounds(0, 0, 1250, 720);
		
		super.setContentPane(new Windows2KFrameDesktop(this, ImageIO.read(new File(background))));
		
		super.setVisible(true);
	}
	
}
