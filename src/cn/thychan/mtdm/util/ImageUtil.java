package cn.thychan.mtdm.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by cn_cx on 2016/12/8.
 */


public class ImageUtil {

	//任务节点图片
	public static final ImageIcon TASK_NODE_IMAGE = new ImageIcon("images/nav/task.png");

	//下载完成节点图片
	public static final ImageIcon FINISH_NODE_IMAGE = new ImageIcon("images/nav/finish.png");

	//下载失败节点图片
	public static final ImageIcon FAIL_NODE_IMAGE = new ImageIcon("images/nav/fail.png");

	//下载完成的节点
	public static final ImageIcon DOWNLOADING_NODE_IMAGE = new ImageIcon("images/nav/downloading.png");

	//正在下载状态图片
	public static final ImageIcon DOWNLOADING_IMAGE = new ImageIcon("images/state/downloading.png");

	//正在连接资源的图片
	public static final ImageIcon CONNECTING_IMAGE = new ImageIcon("images/state/connecting.png");

	//下载完成的图片
	public static final ImageIcon FINISHED_IMAGE = new ImageIcon("images/state/finished.png");

	//不能连接的图片
	public static final ImageIcon FAILED_IMAGE = new ImageIcon("images/state/failed.png");

	//暂停下载的图片
	public static final ImageIcon PAUSE_IMAGE = new ImageIcon("images/state/pause.png");
	//悬浮图标
	public static final String SUSPEND_IMAGE_PATH = "images/icon/mtdm.png";
	//悬浮打开主窗体菜单
	public static final ImageIcon SUSPEND_OPEN_IAMGE = new ImageIcon("images/suspend/open.png");
	//悬浮新任务菜单
	public static final ImageIcon SUSPEND_NEW_IAMGE = new ImageIcon("images/suspend/add.png");
	//悬浮开始任务菜单
	public static final ImageIcon SUSPEND_START_IAMGE = new ImageIcon("images/suspend/start.png");
	//悬浮暂停任务菜单
	public static final ImageIcon SUSPEND_PAUSE_IAMGE = new ImageIcon("images/suspend/pause.png");
	//删除已完成任务
	public static final ImageIcon SUSPEND_REMOVE_IAMGE = new ImageIcon("images/suspend/remove.png");
	//退出菜单
	public static final ImageIcon SUSPEND_QUIT_IAMGE = new ImageIcon("images/suspend/quit.png");
	//工具栏图片
	public static final String TRAY_ICON_PATH = "images/icon/mtdm_trayicon.png";

	/**
	 * 返回悬浮图片
	 */
	public static BufferedImage getImage(String path) {
		try {
			return ImageIO.read(new File(path));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
