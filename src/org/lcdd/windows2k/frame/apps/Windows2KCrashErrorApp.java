package org.lcdd.windows2k.frame.apps;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

import org.lcdd.windows2k.Windows2KMain;
import org.lcdd.windows2k.frame.Windows2KFrame;
import org.lcdd.windows2k.frame.desktop.Windows2KFrameDesktop;
import org.lcdd.windows2k.utils.PaintRunnable;

public class Windows2KCrashErrorApp extends Windows2KApp {

	public Windows2KCrashErrorApp() {
		super("Ooops", new ImageIcon("./img/My_Computer.png"));
	}

	@Override
	public JInternalFrame createFrame() {
		JInternalFrame iframe = new JInternalFrame(name, false, true);
		
		System.out.println("c");
		
		iframe.setBounds(10, 20, 600, 500);
		iframe.setVisible(false);
		
		Windows2KFrame frame = Windows2KMain.frame;
		Windows2KFrameDesktop desk = Windows2KMain.frame.desktop;
		desk.paints.add(new PaintRunnable() {
			@Override
			public void paint(Graphics g) {
				for(int x = 0; x < 1; x++) {
					
				}
			}
		});
		
		registerFrame(iframe);
		return iframe;
	}

	@Override
	public void onClose() {

	}

}
