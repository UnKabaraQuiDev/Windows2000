package org.lcdd.windows2k.utils;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import java.io.File;
import java.util.Random;

@SuppressWarnings("serial")
public class FileTree extends JTree implements TreeSelectionListener {

    public FileTree(String path) {
        super(scan(new File(path)));
        addTreeSelectionListener(this);
    }

    private static MutableTreeNode scan(File node) {
        DefaultMutableTreeNode ret = new DefaultMutableTreeNode(node.getName());
        if (node.isDirectory())
            for (File child : node.listFiles())
                ret.add(scan(child));
        return ret;
    }

    private String randomise(String string) {
        String s = "";
        Random rand = new Random();
        for (int i = 0; i < string.toCharArray().length; i++) {
            if (rand.nextInt(4) == 0) {
                s += "?";
            } else {
                s += string.charAt(i);
            }
        }
        return s;
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) super.getLastSelectedPathComponent();
        if (node == null) return;
        node.setUserObject(randomise(node.getUserObject().toString()));
    }

}