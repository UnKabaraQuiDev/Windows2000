package org.lcdd.windows2k.utils;

import java.io.File;
import java.util.Random;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

@SuppressWarnings("serial")
public class FileTree extends JTree implements TreeSelectionListener {   
	
   public FileTree(String path) {
      super(scan(new File(path)));
      addTreeSelectionListener(this);
   }
   
	private String randomise(String string) { 
		String s = "";
		Random rand = new Random();
		for(int i = 0; i < string.toCharArray().length; i++) {
			if(rand.nextInt(4) == 0) {
				s += 0xFEFF;
			}else {
				s += string.charAt(i);
			}
		}
		System.out.println(s);
		return s;
	}

   private static MutableTreeNode scan(File node) {
      DefaultMutableTreeNode ret = new DefaultMutableTreeNode(node.getName());
      if (node.isDirectory())
         for (File child : node.listFiles())
            ret.add(scan(child));
      return ret;
   }

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		DefaultTreeModel model = (DefaultTreeModel) super.getModel();
	    DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
	    root.setUserObject(randomise(root.getUserObject().toString()));
	}
   
}