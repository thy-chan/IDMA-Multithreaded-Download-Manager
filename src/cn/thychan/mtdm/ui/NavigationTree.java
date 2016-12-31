package cn.thychan.mtdm.ui;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

/**
 * Created by cn_cx on 2016/12/8.
 */

/**
 * ������
 */
public class NavigationTree extends JTree {

    public NavigationTree(DefaultMutableTreeNode root) {
        super(root);
        this.setRootVisible(false);
        this.setShowsRootHandles(true);
        this.setCellRenderer(new NavigationTreeCellRender());
        //չ����һ��ڵ�
        for (int i = 0; i < root.getChildCount(); i++) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)root.getChildAt(i);
            this.expandPath(new TreePath(node.getPath()));
        }
    }
}