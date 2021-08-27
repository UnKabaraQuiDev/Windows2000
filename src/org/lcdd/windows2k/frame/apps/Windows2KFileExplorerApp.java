package org.lcdd.windows2k.frame.apps;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

public class Windows2KFileExplorerApp extends Windows2KApp {

	public Windows2KFileExplorerApp() {
		super("File explorer", new ImageIcon("./img/explorer.png"));
	}
	
	@Override
	public JInternalFrame createFrame() {
		return null;
	}

}
