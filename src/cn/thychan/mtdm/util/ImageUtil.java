package cn.thychan.mtdm.util;

import cn.thychan.mtdm.ui.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;

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

    //悬浮图标
    public static final String SUSPEND_IMAGE_PATH = "/images/icon/mtdm.png";

    //悬浮打开主窗体菜单
    static java.net.URL suspend_open_imgURL = MainFrame.class.getResource("/images/suspend/open.png");
    public static final ImageIcon SUSPEND_OPEN_IAMGE = new ImageIcon(suspend_open_imgURL);

    //悬浮新任务菜单
    static java.net.URL suspend_new_imgURL = MainFrame.class.getResource("/images/suspend/add.png");
    public static final ImageIcon SUSPEND_NEW_IAMGE = new ImageIcon(suspend_new_imgURL);

    //悬浮开始任务菜单
    static java.net.URL suspend_start_imgURL = MainFrame.class.getResource("/images/suspend/start.png");
    public static final ImageIcon SUSPEND_START_IAMGE = new ImageIcon(suspend_start_imgURL);

    //悬浮暂停任务菜单
    static java.net.URL suspend_pause_imgURL = MainFrame.class.getResource("/images/suspend/pause.png");
    public static final ImageIcon SUSPEND_PAUSE_IAMGE = new ImageIcon(suspend_pause_imgURL);

    //删除已完成任务
    static java.net.URL suspend_remove_imgURL = MainFrame.class.getResource("/images/suspend/remove.png");
    public static final ImageIcon SUSPEND_REMOVE_IAMGE = new ImageIcon(suspend_remove_imgURL);

    //退出菜单
    static java.net.URL suspend_quit_imgURL = MainFrame.class.getResource("/images/suspend/quit.png");
    public static final ImageIcon SUSPEND_QUIT_IAMGE = new ImageIcon(suspend_quit_imgURL);

    //工具栏图片
    public static final String TRAY_ICON_PATH = "/images/icon/mtdm_trayicon.png";

    /**
     * 返回悬浮图片
     */
    public static BufferedImage getImage(String path) {
        try {
            java.net.URL imgURL = MainFrame.class.getResource(path);
            return ImageIO.read(imgURL);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
