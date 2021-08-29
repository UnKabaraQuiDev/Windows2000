package org.lcdd.windows2k.frame;

import org.lcdd.windows2k.Windows2KMain;
import org.lcdd.windows2k.back.AudioPlayerManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.File;

public class BlueScreen {
    private static Windows2KFrame frame = Windows2KMain.frame;

    public static Component createBlueScreen(String desc) {
        JDesktopPane pane = new JDesktopPane();
        pane.setBackground(Color.BLUE);
        pane.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        JLabel text = new JLabel();
        text.setBounds(0, 0, pane.getWidth(), pane.getHeight());
        text.setForeground(Color.white);
        text.setText("<html><div style='text-align: center; font-size: large; font-family: \"Microsoft Sans Serif\"'><center>" + "FATAL ERROR<br>" + desc + "</center></div></html>");
        text.setVerticalAlignment(SwingConstants.CENTER);
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 40));
        text.setBackground(Color.BLUE);
        text.setVisible(true);
        pane.add(text);

        pane.setVisible(true);
        AudioPlayerManager manager = new AudioPlayerManager();
        manager.playAudioFile(new File("./assets/bsod.wav"));
        return pane;
    }

    public static void crashIn(long delay) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(delay);
                Windows2KMain.frame.dispatchEvent(new WindowEvent(Windows2KMain.frame, WindowEvent.WINDOW_CLOSING));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }

}
