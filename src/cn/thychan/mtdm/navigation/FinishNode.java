package cn.thychan.mtdm.navigation;

import cn.thychan.mtdm.util.ImageUtil;
import javax.swing.*;

/**
 * Created by cn_cx on 2016/12/8.
 */

/**
 * ������ɽڵ�
 */
public class FinishNode implements DownloadNode {

    public ImageIcon getImageIcon() {
        return ImageUtil.FINISH_NODE_IMAGE;
    }

    public String getText() {
        return "�������";
    }

}
