package org.lcdd.windows2k.frame.apps;

import java.beans.PropertyVetoException;

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
		JInternalFrame frame = new JInternalFrame(name);
		
		frame.setBounds(10, 20, 350, 500);
		frame.setVisible(true);
		try {
			frame.setSelected(true);
		} catch (PropertyVetoException e) {}
		frame.setContentPane(new JDesktopPane());
		FileTree tree = new FileTree("./");
		frame.getContentPane().add(tree);
		
		System.out.println("hey");
		
		registerFrame(frame);
		return frame;
	}

}
