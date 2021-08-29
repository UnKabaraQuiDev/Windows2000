package org.lcdd.windows2k.frame.apps;

import org.lcdd.windows2k.back.AudioPlayerManager;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Windows2KAudioPlayerApp extends Windows2KApp {
    private AudioPlayerManager manager = new AudioPlayerManager();
    private boolean isPlaying = false;
    public Windows2KAudioPlayerApp() {
        super("Audio Player", new ImageIcon("./assets/AudioPlayer.png"));
    }

    @Override
    public JInternalFrame createFrame() {
        JInternalFrame frame = new JInternalFrame(name, false, true);
        JTextArea text = new JTextArea();
        JButton button = new JButton();

        text.setText("Music");
        text.setBounds(0, 600 - 200, 720, 600);

        button.setBackground(Color.BLACK);
        button.setIcon(new ImageIcon("./assets/play.jpg"));
        button.addActionListener(e -> {
            if (!isPlaying) {
                manager.playAudioFile(new File("./assets/music.wav"));
                isPlaying = true;
            } else {
                manager.stopAudioFile();
                isPlaying = false;
            }
        });
        button.setBounds(0, 0, 600, 500);

        frame.setBounds(10, 20, 600, 500);
        frame.setContentPane(new JDesktopPane());
        frame.getContentPane().setBounds(0, 0, frame.getWidth(), frame.getHeight());
        frame.getContentPane().setBackground(Color.GRAY);
        frame.getContentPane().add(button);

        frame.setVisible(true);

        registerFrame(frame);
        return frame;
    }

    @Override
    public void onClose() {
        manager.stopAudioFile();
    }
}
