package cn.thychan.mtdm.navigation;

import cn.thychan.mtdm.util.ImageUtil;

import javax.swing.*;

/**
 * Created by cn_cx on 2016/12/8.
 */

/**
 * ȫ��������Դ(����)�ڵ�
 */
public class TaskNode implements DownloadNode {

    public ImageIcon getImageIcon() {
        return ImageUtil.TASK_NODE_IMAGE;
    }

    public String getText() {
        return "����";
    }
}
