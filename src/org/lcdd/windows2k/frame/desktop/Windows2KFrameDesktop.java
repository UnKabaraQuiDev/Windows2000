package org.lcdd.windows2k.frame.desktop;

import org.lcdd.windows2k.Windows2KMain;
import org.lcdd.windows2k.frame.Windows2KFrame;
import org.lcdd.windows2k.frame.apps.Windows2KApp;
import org.lcdd.windows2k.frame.desktop.taskbar.Windows2KTaskBar;
import org.lcdd.windows2k.utils.PaintRunnable;
import org.lcdd.windows2k.utils.Utils;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("serial")
public class Windows2KFrameDesktop extends JDesktopPane {

    public JPanel startMenuPane;
    public Windows2KTaskBar taskBar;
    public List<PaintRunnable> paints = new ArrayList<>();
    @SuppressWarnings("unused")
    private Windows2KFrame frame;
    private List<JLabel> appLabels = new ArrayList<>();

    public Windows2KFrameDesktop(Windows2KFrame frame) {
        this.frame = frame;

        taskBar = new Windows2KTaskBar(frame);
        super.add(taskBar);

        int i = 0;
        for (Windows2KApp app : frame.apps) {
            if (!app.visible) continue;

            JLabel label = new JLabel(new ImageIcon(Utils.getScaledImage(app.icon.getImage(), 100, 100)));
            label.addMouseListener(new MouseListener() {
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
                    if (!Windows2KMain.isInstalled) return;
                    app.createFrame();
                }
            });
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setBackground(new Color(0, 0, 0, 0));
            label.setBounds(40 + (i * (100 + 20 + 20)), 40, 100 + 20, 100 + 30);

            JLabel text = new JLabel(app.name);
            text.setHorizontalAlignment(SwingConstants.CENTER);
            text.setBounds(0, 115, 100 + 20, 15);
            text.setForeground(Color.WHITE);
            text.setBackground(new Color(0, 0, 0, 0));
            text.setVisible(true);
            label.add(text);

            label.setVisible(true);
            super.add(label);

            appLabels.add(label);

            i++;
        }

        Random rand = new Random();
        startMenuPane = new JPanel() {
            @Override
            public void paint(Graphics g) {
                for (int y = 0; y < startMenuPane.getHeight() / 2 / 50; y++) {
                    g.setColor(randomColor());
                    g.fillRect(0, y * 50, 15, 50);

                    g.setColor(randomColor());
                    g.fillRect(15, y * 50, 200 - 15, 50);

                    g.setColor(randomColor());
                    g.fillRect(200, y * 50, 100, 50);
                }
                for (int y = startMenuPane.getHeight() / 2 / 25; y < startMenuPane.getHeight() / 25; y++) {
                    g.setColor(randomColor());
                    g.fillRect(0, y * 25, 15, 25);

                    g.setColor(randomColor());
                    g.fillRect(15, y * 25, 200 - 15, 25);

                    g.setColor(randomColor());
                    g.fillRect(200, y * 25, 100, 25);
                }
                g.dispose();
                super.paint(g);
            }

            public Color randomColor() {
                return new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
            }
        };
        startMenuPane.setOpaque(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (startMenuPane.isVisible()) {
                            startMenuPane.repaint();
                        }
                        Thread.sleep(1000 + (rand.nextInt(1800) - (1800 / 2)));
                    } catch (InterruptedException e) {
                        System.err.println("Erreur :c");
                    }
                }
            }
        }).start();
        startMenuPane.setSize(300, 400);
        startMenuPane.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.DARK_GRAY));
        startMenuPane.setLocation(0, frame.getHeight() - 40 - startMenuPane.getHeight());
        startMenuPane.setVisible(false);
        super.add(startMenuPane);

        super.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        super.setBounds(0, 0, (int) frame.getBounds().getWidth(), (int) frame.getBounds().getHeight());
        super.setBackground(new Color(57, 107, 165));
        super.setVisible(true);
    }

    public void updateLocation() {
        taskBar.updateLocation();

        startMenuPane.setLocation(0, super.getHeight() - 40 - startMenuPane.getHeight());

        int i = 0;
        for (JLabel label : appLabels) {
            label.setBounds(40 + (i * (100 + 20 + 20)), 40, 100 + 20, 100 + 30);
            i++;
        }
    }

    @Override
    public void paint(Graphics g) {
        for (PaintRunnable pr : paints) {
            pr.paint(g);
        }
        super.paint(g);
    }

}
