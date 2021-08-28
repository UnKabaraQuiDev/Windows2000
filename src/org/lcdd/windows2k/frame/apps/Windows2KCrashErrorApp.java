package org.lcdd.windows2k.frame.apps;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.lcdd.windows2k.Windows2KMain;
import org.lcdd.windows2k.back.AudioPlayerManager;
import org.lcdd.windows2k.frame.Windows2KFrame;
import org.lcdd.windows2k.frame.desktop.Windows2KFrameDesktop;

public class Windows2KCrashErrorApp extends Windows2KApp {

	public static String[] messages = {"Faites gagner Freezman & Poucy", "Oops ! Crash :O", ":lp_triste: ca a planté", "Windows crashed :(","Programme.exe ne répond pas"};
	private AudioPlayerManager manager = new AudioPlayerManager();
	
	public Windows2KCrashErrorApp() {
		super("Ooops", new ImageIcon("./img/My_Computer.png"));
	}

	@Override
	public JInternalFrame createFrame() {
		JInternalFrame iframe = new JInternalFrame(name, false, true);
		
		iframe.setBounds(10, 20, 600, 500);
		iframe.setVisible(false);
		
		Windows2KFrame frame = Windows2KMain.frame;
		Windows2KFrameDesktop desk = Windows2KMain.frame.desktop;
		
		Random rand = new Random();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					for(int j = 0; j < 15; j++) {
						try {
							int x = rand.nextInt(frame.getWidth()-300);
							int y = rand.nextInt(frame.getHeight()-225);
							JInternalFrame intF = createDialog((rand.nextInt(10) != 0 ? "OK" : "RIP"), messages[rand.nextInt(messages.length)], x, y);
							desk.add(intF);
							
							intF.moveToFront();
							intF.setSelected(true);
							manager.playAudioFile(new File("./img/chord.wav"));
							
							Thread.sleep(20);
						} catch (Exception e1) {
							System.err.println("Une erreur est survenue, mais c'est pas grave x)");
						}
					}
				}
			}
		}).start();

		registerFrame(iframe);
		return iframe;
	}
	
	private JInternalFrame createDialog(String sclose, String msg, int x, int y) throws PropertyVetoException {
		JInternalFrame dialog = new JInternalFrame("ERROR");
		dialog.setBounds(x, y, 300, 225);
		dialog.setContentPane(new JDesktopPane());
		
		JLabel label = new JLabel(msg);
		label.setBounds(0, 0, dialog.getWidth(), dialog.getHeight()/2);
		label.setVisible(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		dialog.getContentPane().add(label);
		
		JButton btn = new JButton(sclose);
		btn.addMouseListener(new MouseListener() {
			@Override public void mouseReleased(MouseEvent e) {}
			@Override public void mousePressed(MouseEvent e) {}
			@Override public void mouseExited(MouseEvent e) {}
			@Override public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btn.setBounds(0,dialog.getHeight()/2, dialog.getWidth(), dialog.getHeight()/2);
		btn.setVisible(true);
		dialog.getContentPane().add(btn);
		
		dialog.setVisible(true);
		
		return dialog;
	}

	@Override
	public void onClose() {

	}

}
