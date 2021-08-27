package org.lcdd.windows2k.frame.apps;

import org.lcdd.windows2k.back.CmdManager;

import javax.swing.*;

public class Windows2KShellApp extends Windows2KApp {

    public Windows2KShellApp() {
        super("Terminal", new ImageIcon("./img/cmd.png"));
    }

    private CmdManager manager = new CmdManager();

    @Override
    public JInternalFrame createFrame() {
        JInternalFrame frame = new JInternalFrame(name);
        registerFrame(frame);
        return frame;
    }
}
