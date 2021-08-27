package org.lcdd.windows2k.frame.apps;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

public class Windows2KFileExplorerApp extends Windows2KApp {

	public Windows2KFileExplorerApp() {
		super("File explorer", new ImageIcon("./img/My_Documents.ico"));
	}
	
	@Override
	public JInternalFrame createFrame() {
		JInternalFrame frame = new JInternalFrame(name);
		
		registerFrame(frame);
		return frame;
	}

}
