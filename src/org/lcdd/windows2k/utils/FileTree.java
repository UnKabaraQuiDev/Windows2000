package org.lcdd.windows2k.utils;

import java.io.File;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

@SuppressWarnings("serial")
public class FileTree extends JTree {   
	
   public FileTree(String path) {
      super(scan(new File(path)));
   }

   private static MutableTreeNode scan(File node) {
      DefaultMutableTreeNode ret = new DefaultMutableTreeNode(node.getName());
      if (node.isDirectory())
         for (File child: node.listFiles())
            ret.add(scan(child));
      return ret;
   }
   
}