package org.lcdd.windows2k.frame.desktop.taskbar;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import org.lcdd.windows2k.frame.Windows2KFrame;

@SuppressWarnings("serial")
public class Windows2KTaskBar extends JPanel {

	private JLabel hour = new JLabel("<html>hour</html>");
	private Windows2KFrame frame;
	
	public Windows2KTaskBar(Windows2KFrame frame) {
		this.frame = frame;
		
		updateLocation();
		
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
	}
	
	public String getHour() {return hour.getText();}
	public void setHour(String hour) {this.hour.setText("<html>"+hour+"</html>");}
	
}
