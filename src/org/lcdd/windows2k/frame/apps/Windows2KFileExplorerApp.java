package org.lcdd.windows2k.frame.apps;

import org.lcdd.windows2k.utils.FileTree;

import javax.swing.*;
import java.awt.*;

public class Windows2KFileExplorerApp extends Windows2KApp {

    public Windows2KFileExplorerApp() {
        super("File explorer", new ImageIcon("./assets/My_Documents.png"));
    }

    @Override
    public JInternalFrame createFrame() {
        JInternalFrame frame = new JInternalFrame(name, false, true);

        frame.setBounds(10, 20, 600, 500);
        frame.setVisible(true);
        frame.setContentPane(new JDesktopPane());
        frame.getContentPane().setBounds(0, 0, frame.getWidth(), frame.getHeight());
        frame.getContentPane().setBackground(Color.GRAY);
        FileTree tree = new FileTree("./");
        tree.setBounds(0, 0, frame.getContentPane().getWidth(), frame.getContentPane().getHeight());
        tree.setVisible(true);
        frame.getContentPane().add(tree);

        registerFrame(frame);
        return frame;
    }

    @Override
    public void onClose() {

    }

}
