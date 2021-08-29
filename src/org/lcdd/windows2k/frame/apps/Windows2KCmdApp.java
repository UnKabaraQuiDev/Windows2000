package org.lcdd.windows2k.frame.apps;

import org.lcdd.windows2k.back.CmdManager;

import javax.swing.*;
import java.awt.*;

public class Windows2KCmdApp extends Windows2KApp {

    public Windows2KCmdApp() {
        super("Terminal", new ImageIcon("./assets/cmd.png"));
    }

    @Override
    public JInternalFrame createFrame() {
        final CmdManager manager = new CmdManager();

        JTextField input = new JTextField();
        JTextArea text = new JTextArea();
        JInternalFrame frame = new JInternalFrame(name, false, true);
        JScrollPane scrollPane = new JScrollPane(text);

        input.addActionListener(e -> {
            StringBuilder argument = new StringBuilder();
            if (e.getActionCommand().split(" ").length > 1) {
                for (int i = 1; i < e.getActionCommand().split(" ").length; i++) {
                    argument.append(e.getActionCommand().split(" ")[i]);
                }
            }
            String output = manager.executeCommand(e.getActionCommand().split(" ")[0], argument.toString());
            text.append("\n" + manager.activeDirectory.getPath() + " > " + output);
            input.setText("");
        });

        input.setBackground(Color.darkGray);
        input.setBounds(0, 600 - 50, 720, 25);
        input.setForeground(Color.WHITE);

        text.setEditable(false);
        text.setBackground(Color.BLACK);
        text.setForeground(Color.WHITE);
        text.setAutoscrolls(true);
        text.setBounds(0, 0, 720, 600 - 50);

        scrollPane.setBounds(0, 0, 720 - 10, 600 - 50);

        frame.setBackground(Color.BLACK);
        frame.setBounds(0, 0, 720, 600);
        frame.setContentPane(new JDesktopPane());
        frame.getContentPane().add(input);
        frame.getContentPane().add(scrollPane);
        frame.setVisible(true);
        registerFrame(frame);
        return frame;
    }

    @Override
    public void onClose() {

    }

}

