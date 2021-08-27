package org.lcdd.windows2k.frame.desktop.taskbar;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolTip;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import org.lcdd.windows2k.frame.Windows2KFrame;
import org.lcdd.windows2k.frame.apps.Windows2KApp;
import org.lcdd.windows2k.utils.Utils;

@SuppressWarnings("serial")
public class Windows2KTaskBar extends JPanel {

	private JLabel startMenu = new JLabel(new ImageIcon("./img/start_main.jpg"));
	private JLabel hour = new JLabel("<html>hour</html>");
	private Windows2KFrame frame;
	
	public Windows2KTaskBar(Windows2KFrame frame) {
		this.frame = frame;
		
		updateLocation();
		
		super.setAlignmentX(SwingConstants.RIGHT);
		
		startMenu.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.DARK_GRAY));
		startMenu.setBounds(0, 0, 80, 30);
		startMenu.setVisible(true);
		super.add(startMenu);
		
		int i = 0;
		for(Windows2KApp app : frame.apps) {
			JLabel label = new JLabel(new ImageIcon(Utils.getScaledImage(app.icon.getImage(), 30, 30)));
			JToolTip toolTip = label.createToolTip();
			toolTip.setTipText(app.name);
			label.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {}
				@Override
				public void mousePressed(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {}
				@Override
				public void mouseEntered(MouseEvent e) {}
				@Override
				public void mouseClicked(MouseEvent e) {
					app.createFrame();
				}
			});
			//label.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.DARK_GRAY));
			label.setBounds(80+(i*30), 0, 30, 30);
			label.setVisible(true);
			super.add(label);
			
			i++;
		}
		
		hour.setVerticalAlignment(SwingConstants.CENTER);
		hour.setHorizontalAlignment(SwingConstants.CENTER);
		hour.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.DARK_GRAY));
		hour.setBounds((int) super.getBounds().getWidth()-70, 0, 70, 30);
		hour.setVisible(true);
		super.add(hour);
		
		super.setBackground(Color.LIGHT_GRAY);
		super.setVisible(true);
		super.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.DARK_GRAY));
	}
	
	public void updateLocation() {
		super.setBounds(0, (int) frame.desktop.getBounds().getHeight()-30, (int) frame.desktop.getBounds().getWidth(), 30);
		hour.setBounds((int) super.getBounds().getWidth()-70, 0, 70, 30);
		startMenu.setBounds(0, 0, 80, 30);
	}
	
	public String getHour() {return hour.getText();}
	public void setHour(String hour) {this.hour.setText("<html>"+hour+"</html>");}
	
}
