package org.lcdd.windows2k.frame.apps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import org.lcdd.windows2k.Windows2KMain;

public abstract class Windows2KApp {

	public List<JInternalFrame> openedFrames = new ArrayList<>();
	
	public String name;
	public ImageIcon icon;
	
	public Windows2KApp(String name, ImageIcon icon) {
		this.name = name;
		this.icon = icon;
	}
	
	public abstract JInternalFrame createFrame();

	public abstract void onClose();
	
	protected void registerFrame(JInternalFrame frame) {
		Windows2KMain.frame.desktop.add(frame);
		openedFrames.add(frame);
		frame.setLocation(frame.getX()+(openedFrames.size()*20), frame.getY()+(openedFrames.size()*20));
		frame.toFront();
		
		frame.addInternalFrameListener(new InternalFrameListener() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {}
			@Override
			public void internalFrameIconified(InternalFrameEvent e) {}
			@Override
			public void internalFrameDeiconified(InternalFrameEvent e) {}
			@Override
			public void internalFrameDeactivated(InternalFrameEvent e) {}
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				openedFrames.remove(frame);
				onClose();
			}
			@Override
			public void internalFrameClosed(InternalFrameEvent e) {}
			@Override
			public void internalFrameActivated(InternalFrameEvent e) {}
		});
	}
	
}
