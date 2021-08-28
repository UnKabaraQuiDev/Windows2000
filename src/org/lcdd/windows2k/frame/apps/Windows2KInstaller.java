package org.lcdd.windows2k.frame.apps;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import org.lcdd.windows2k.Windows2KMain;
import org.lcdd.windows2k.frame.BlueScreen;

public class Windows2KInstaller extends Windows2KApp {

    public Windows2KInstaller() {
        super("Windows installer", new ImageIcon("./assets/cmd.png"));
        super.visible = false;
    }

    @SuppressWarnings("unused")
	@Override
    public JInternalFrame createFrame() {
        ClippyWindows2KApp clippy = new ClippyWindows2KApp();
        JInternalFrame frame = new JInternalFrame(name, false, false);
        
        JLabel cgu = new JLabel();
        JScrollPane scroll = new JScrollPane(cgu);
        JProgressBar bar = new JProgressBar(0,0,100);
        
        ButtonGroup group = new ButtonGroup();
        JRadioButton accept = new JRadioButton();
        JRadioButton deny = new JRadioButton();
        
        JButton next = new JButton("Next");
        
        frame.setBounds(0, 0, 1000, 600);

        cgu.setHorizontalAlignment(SwingConstants.CENTER);
        String text = "CGU :<br>"
        		+ "Ne pas utiliser ce programme si vous êtes un peu bête, que vous avez des problèmes de vue. En acceptant ces cgu, vous acceptez de raquer un smic et "
        		+ "d'hypothéquer votre maison pour une license, d'utiliser un os pas stable closed-source qui vole vos données, et qui est po bo.<br><br>"
        		+ "Je vous conseille de fuir, d'aller sous GNU/Linux.<br><br>"
        		+ "Au fait, je suis un bg, vraiment bg, mais les développeurs sont pas très doués et laissent plein de bugs...<br>"
        		+ "<br>"
        		+ "<br>"
        		+ "Veuillez accepter celles-ci en signant de votre sang.<br>"
        		+ "<br>"
        		+ "All rights reserved, Rabbit Corporation, PDG : Typhon";
        cgu.setText("<html><div style='text-align: center; font-size: large; font-family: \"Microsoft Sans Serif\"'>"+text+"</div></html>");
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
                    accept.setVisible(false);
                    next.setVisible(false);
                    deny.setVisible(false);
                    cgu.setVisible(false);
                    bar.setVisible(true);
                    
                    new Timer().schedule(new TimerTask() {
                    	Random rand = new Random();
						@Override
						public void run() {
							if(bar.getValue() != bar.getMaximum()) {
								bar.setValue(bar.getValue() +(2 +(rand.nextInt(10) -5)));
								if(rand.nextInt(100) == 0) {
									bar.setValue(10);
								}
							}else {
								cancel();
								try {
									frame.setClosed(true);
								} catch (PropertyVetoException e) {
									System.out.println("Erreur :c");
								}
							}
						}
					}, 0, 50);
				}else{
                    Windows2KMain.frame.putBluescreen(BlueScreen.createBlueScreen("CGU refused"));
                    BlueScreen.crashIn(2500);
                }
			}
		});

        group.add(accept);
        group.add(deny);
        
        bar.setSize(frame.getWidth()/2, 50);
        bar.setLocation(frame.getWidth()/2 -bar.getWidth()/2, frame.getHeight()/2 -bar.getHeight()/2);
        bar.setForeground(Color.BLUE);
        bar.setMaximum(100);
        bar.setVisible(false);
        
        frame.setContentPane(new JDesktopPane());
        frame.getContentPane().add(cgu);
        frame.getContentPane().add(deny);
        frame.getContentPane().add(accept);
        frame.getContentPane().add(next);
        frame.getContentPane().add(bar);

        frame.setVisible(true);
        
        registerFrame(frame);
        return frame;
    }

    @Override
    public void onClose() {

    }
}
