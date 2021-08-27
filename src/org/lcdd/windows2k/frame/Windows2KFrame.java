package org.lcdd.windows2k.frame;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.lcdd.windows2k.frame.apps.Windows2KApp;
import org.lcdd.windows2k.frame.desktop.Windows2KFrameDesktop;
import org.lcdd.windows2k.frame.desktop.taskbar.Windows2KTaskBar;

@SuppressWarnings("serial")
public class Windows2KFrame extends JFrame implements ComponentListener {

	public Windows2KFrameDesktop desktop;
	public Windows2KTaskBar taskBar;
	
	public List<Windows2KApp> apps = new ArrayList<>();
	
	public Windows2KFrame() throws IOException {
		super("Windows 2000 Simulation");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setBounds(0, 0, 1250, 720);
		
		super.addComponentListener(this);
		
		desktop = new Windows2KFrameDesktop(this);
		super.setContentPane(desktop);
		taskBar = new Windows2KTaskBar(this);
		desktop.add(taskBar);
		
		super.setVisible(true);
	}

	@Override
	public void componentResized(ComponentEvent e) {
		taskBar.updateLocation();
	}
	@Override
	public void componentMoved(ComponentEvent e) {}
	@Override
	public void componentShown(ComponentEvent e) {}
	@Override
	public void componentHidden(ComponentEvent e) {}
	
}
