package cn.thychan.mtdm.util;

import cn.thychan.mtdm.ui.MainFrame;

import javax.swing.*;

/**
 * Created by cn_cx on 2016/12/8.
 */

public class ImageUtil {

    //任务节点图片
    static java.net.URL task_node_imgURL = MainFrame.class.getResource("/images/nav/task.png");
    public static final ImageIcon TASK_NODE_IMAGE = new ImageIcon(task_node_imgURL);

    //下载完成节点图片
    static java.net.URL finish_node_imgURL = MainFrame.class.getResource("/images/nav/finish.png");
    public static final ImageIcon FINISH_NODE_IMAGE = new ImageIcon(finish_node_imgURL);

    //下载失败节点图片
    static java.net.URL fail_node_imgURL = MainFrame.class.getResource("/images/nav/fail.png");
    public static final ImageIcon FAIL_NODE_IMAGE = new ImageIcon(fail_node_imgURL);

    //下载完成的节点
    static java.net.URL downloading_node_imgURL = MainFrame.class.getResource("/images/nav/downloading.png");
    public static final ImageIcon DOWNLOADING_NODE_IMAGE = new ImageIcon(downloading_node_imgURL);

    //正在下载状态图片
    static java.net.URL downloading_imgURL = MainFrame.class.getResource("/images/state/downloading.png");
    public static final ImageIcon DOWNLOADING_IMAGE = new ImageIcon(downloading_imgURL);

    //正在连接资源的图片
    static java.net.URL connecting_imgURL = MainFrame.class.getResource("/images/state/connecting.png");
    public static final ImageIcon CONNECTING_IMAGE = new ImageIcon(connecting_imgURL);

    //下载完成的图片
    static java.net.URL finished_imgURL = MainFrame.class.getResource("/images/state/finished.png");
    public static final ImageIcon FINISHED_IMAGE = new ImageIcon(finished_imgURL);

    //不能连接的图片
    static java.net.URL failed_imgURL = MainFrame.class.getResource("/images/state/failed.png");
    public static final ImageIcon FAILED_IMAGE = new ImageIcon(failed_imgURL);

    //暂停下载的图片
    static java.net.URL pause_imgURL = MainFrame.class.getResource("/images/state/pause.png");
    public static final ImageIcon PAUSE_IMAGE = new ImageIcon(pause_imgURL);
}
