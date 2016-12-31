package cn.thychan.mtdm.navigation;

import cn.thychan.mtdm.util.ImageUtil;
import javax.swing.*;

/**
 * Created by cn_cx on 2016/12/8.
 */

/**
 * 下载完成节点
 */
public class FinishNode implements DownloadNode {

    public ImageIcon getImageIcon() {
        return ImageUtil.FINISH_NODE_IMAGE;
    }

    public String getText() {
        return "下载完成";
    }

}
