package cn.thychan.mtdm.navigation;
import cn.thychan.mtdm.util.ImageUtil;

import javax.swing.*;

/**
 * Created by cn_cx on 2016/12/8.
 */

/**
 * �������صĵ����ڵ�
 */
public class DownloadingNode implements DownloadNode {
    public ImageIcon getImageIcon() {
        return ImageUtil.DOWNLOADING_NODE_IMAGE;
    }

    public String getText() {
        return "��������";
    }
}
