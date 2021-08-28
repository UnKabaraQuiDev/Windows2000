package org.lcdd.windows2k.frame.apps;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import org.lcdd.windows2k.utils.FileTree;

public class Windows2KFileExplorerApp extends Windows2KApp {

	public Windows2KFileExplorerApp() {
		super("File explorer", new ImageIcon("./img/My_Documents.png"));
	}
	
	@Override
	public JInternalFrame createFrame() {
		JInternalFrame frame = new JInternalFrame(name, false, true);
		
		frame.setBounds(10, 20, 600, 500);
		frame.setVisible(true);
		frame.setContentPane(new JDesktopPane());
		frame.getContentPane().setBounds(0, 0, frame.getWidth(), frame.getHeight());
		frame.getContentPane().setBackground(Color.GRAY);
		FileTree tree = new FileTree("./");
		tree.setBounds(0, 0, frame.getContentPane().getWidth(), frame.getContentPane().getHeight());
		tree.setVisible(true);
		frame.getContentPane().add(tree);
		
		registerFrame(frame);
		return frame;
	}

	@Override
	public void onClose() {

	}

}
