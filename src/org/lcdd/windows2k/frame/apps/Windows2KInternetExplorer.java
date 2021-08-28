package org.lcdd.windows2k.frame.apps;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Windows2KInternetExplorer extends Windows2KApp {

	public Windows2KInternetExplorer() {
		super("Internet Explorer", new ImageIcon("./assets/The_Internet.png"));
	}

	@Override
	public JInternalFrame createFrame() {
		JInternalFrame frame = new JInternalFrame(name, false, true);
		frame.setContentPane(new JDesktopPane());
		frame.setBounds(25, 35, 720, 650);
		
		JTextField input = new JTextField("https://coindesdevs.fr/typhon/");
		input.setBounds(0, 0, frame.getWidth(), 30);
		input.setVisible(true);
		
		JLabel label = new JLabel(new ImageIcon("./assets/Internet_404.png"));
		label.setBounds(0, 30, frame.getWidth(), frame.getHeight()-30);
		label.setVisible(true);
		
		frame.getContentPane().add(input);
		frame.getContentPane().add(label);
		frame.setVisible(true);
		
		registerFrame(frame);
		return frame;
	}

	@Override
	public void onClose() {

	}

}
