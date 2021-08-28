package org.lcdd.windows2k.frame.installer;

import org.lcdd.windows2k.frame.apps.Windows2KApp;

import javax.swing.*;
import java.awt.*;

public class Windows2KInstaller extends Windows2KApp {


    public Windows2KInstaller() {
        super("Windows installer", new ImageIcon("./img/cmd.png"));
    }

    @Override
    public JInternalFrame createFrame() {
        System.out.println("called");
        JInternalFrame frame = new JInternalFrame(name,false,false);
        JTextArea cgu = new JTextArea();
        JCheckBox accept = new JCheckBox();
        JCheckBox deny = new JCheckBox();

        deny.setText("Deny the CGU");
        deny.setBounds(0,frame.getHeight()-30, 1000,30);
        deny.setBackground(Color.BLACK);
        deny.setVisible(true);

        accept.setText("Accept the CGU");
        accept.setBounds(0,frame.getHeight()-60,1000,30);
        accept.setBackground(Color.BLACK);
        accept.setVisible(true);

        cgu.setBackground(Color.BLUE);
        cgu.setEditable(false);
        cgu.setText("df");
        cgu.setBounds(0,0,1000,frame.getHeight()-120);
        cgu.setVisible(true);

        frame.setContentPane(new JDesktopPane());
        frame.getContentPane().add(accept);
        frame.getContentPane().add(deny);
        frame.getContentPane().add(cgu);

        frame.setBounds(0,0, 1000,600);
        frame.setVisible(true);
        registerFrame(frame);


        return frame;
    }

    @Override
    public void onClose() {

    }
}
