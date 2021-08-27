package org.lcdd.windows2k.frame.apps;

import org.lcdd.windows2k.back.CmdManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Windows2KCmdApp extends Windows2KApp implements ActionListener {

    public Windows2KCmdApp() {
        super("Terminal", new ImageIcon("./img/cmd.png"));
    }

    private CmdManager manager = new CmdManager();

    @Override
    public JInternalFrame createFrame() {


        JTextField input = new JTextField();
        JTextPane text = new JTextPane();
        JInternalFrame frame = new JInternalFrame(name);
        input.addActionListener(this);
        input.setBackground(Color.black);
        input.setBounds(0, -300, 600, 10);
        //text.setBackground(Color.black);
        text.setBounds(0,0,600,380);
        frame.setBackground(Color.black);
        frame.setBounds(0, 0, 600, 400);
        frame.setContentPane(new JDesktopPane());
        frame.getContentPane().add(input);
        frame.getContentPane().add(text);
        frame.setVisible(true);
        registerFrame(frame);
        return frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Enter pressed");
        StringBuilder argument = new StringBuilder();
        if (e.getActionCommand().split(" ").length > 1) {
            for (int i = 1; i < argument.length(); i++) {
                argument.append(e.getActionCommand().split(" ")[i]);
                System.out.println("+1");
            }
        }
        System.out.println(argument);
        String output = manager.executeCommand(e.getActionCommand().split(" ")[0], argument.toString());
        System.out.println(output);
        text.setText(text.getText()+"\n"+output);
        input.setText("");
    }
}
