package org.lcdd.windows2k.frame.apps;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Windows2KInstaller extends Windows2KApp {

    public Windows2KInstaller() {
        super("Windows installer", new ImageIcon("./img/cmd.png"));
    }

    @SuppressWarnings("unused")
	@Override
    public JInternalFrame createFrame() {
        JInternalFrame frame = new JInternalFrame(name, false, false);
        
        JLabel cgu = new JLabel();
        JScrollPane scroll = new JScrollPane(cgu);
        
        ButtonGroup group = new ButtonGroup();
        JRadioButton accept = new JRadioButton();
        JRadioButton deny = new JRadioButton();
        
        JButton next = new JButton("Next");
        
        frame.setBounds(0, 0, 1000, 600);

        cgu.setHorizontalAlignment(SwingConstants.CENTER);
        cgu.setText("<html><bold>Conditions\n d'utilisation:</bold><br>je suis un bg, tout simplement<html>");
        cgu.setBounds(0, 0, 1000, frame.getHeight()-120);
        cgu.setVisible(true);
        
        deny.setText("Deny the CGU");
        deny.setSize(150, 30);
        deny.setLocation(frame.getWidth()/2 -deny.getWidth(), frame.getHeight()-90);
        deny.setSelected(true);
        deny.setVisible(true);

        accept.setText("Accept the CGU");
        accept.setSize(150, 30);
        accept.setLocation(frame.getWidth()/2, frame.getHeight()-90);
        accept.setVisible(true);
        
        next.setSize(300, 30);
        next.setLocation(frame.getWidth()/2 -next.getWidth()/2, frame.getHeight()-60);
        next.setVisible(true);
        next.addMouseListener(new MouseListener() {
			@Override public void mouseReleased(MouseEvent e) {}
			@Override public void mousePressed(MouseEvent e) {}
			@Override public void mouseExited(MouseEvent e) {}
			@Override public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(accept.isSelected()) {
					try {
						frame.setClosed(true);
					} catch (PropertyVetoException e1) {
						System.err.println("Erreur :c");
					}
				}
			}
		});

        group.add(accept);
        group.add(deny);
        
        frame.setContentPane(new JDesktopPane());
        frame.getContentPane().add(cgu);
        frame.getContentPane().add(deny);
        frame.getContentPane().add(accept);
        frame.getContentPane().add(next);

        frame.setVisible(true);
        
        registerFrame(frame);
        return frame;
    }

    @Override
    public void onClose() {

    }
}
