package org.lcdd.windows2k.frame.apps;

import org.lcdd.windows2k.Windows2KMain;
import org.lcdd.windows2k.frame.BlueScreen;
import org.lcdd.windows2k.frame.desktop.Windows2KFrameDesktop;
import org.lcdd.windows2k.utils.Utils;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ClippyWindows2KApp {

    Timer t;
    Windows2KFrameDesktop desk = Windows2KMain.frame.desktop;
    String[] msgs = {"Vous êtes nuls", "VOus m'aimez ?", "Suis-je beau ?", "Le java est-il le meilleur language ?", "fgidrhgk fkfdjghg bdhfgd ?"};

    public ClippyWindows2KApp() {
        t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                int rand = new Random().nextInt(2);
                int textRand = new Random().nextInt(msgs.length);
                if (rand == 0) {
                    JInternalFrame frame = new JInternalFrame("Clippy !");
                    frame.setBounds(100, 100, 300, 225);
                    frame.setContentPane(new JDesktopPane());

                    JLabel label = new JLabel(msgs[textRand]);
                    label.setBounds(0, frame.getHeight() / 3, frame.getWidth(), frame.getHeight() / 2);
                    label.setVisible(true);
                    label.setHorizontalAlignment(SwingConstants.CENTER);
                    frame.getContentPane().add(label);

                    ImageIcon icon = new ImageIcon(Utils.getScaledImage(new ImageIcon("./assets/clippy.png").getImage(), 100, 100));
                    JLabel img = new JLabel(icon);
                    img.setBounds(0, 0, 100, 100);
                    img.setVisible(true);

                    JButton yes = new JButton("OUI");
                    JButton no = new JButton("NON");
                    yes.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseReleased(MouseEvent e) {
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
                        }

                        @Override
                        public void mouseClicked(MouseEvent e) {
                            try {
                                frame.setClosed(true);
                            } catch (PropertyVetoException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                    no.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            Windows2KMain.frame.putBluescreen(BlueScreen.createBlueScreen("Il ne faut pas contrarier Clippy !"));
                            BlueScreen.crashIn(2500);
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {

                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                        }
                    });
                    yes.setBounds(0, frame.getHeight() / 3 * 2, frame.getWidth() / 2, frame.getHeight() / 4);
                    no.setBounds(frame.getWidth() / 2, frame.getHeight() / 3 * 2, frame.getWidth() / 2, frame.getHeight() / 4);
                    yes.setVisible(true);
                    no.setVisible(true);
                    frame.getContentPane().add(yes);
                    frame.getContentPane().add(img);
                    frame.getContentPane().add(no);

                    frame.setVisible(true);
                    desk.add(frame);
                }
            }
        }, new Date(System.currentTimeMillis() + 1000), 15000);
    }

}
