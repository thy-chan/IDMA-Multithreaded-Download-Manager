package cn.thychan.mtdm.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by cn_cx on 2016/12/8.
 */


public class ImageUtil {

    //����ڵ�ͼƬ
    public static final ImageIcon TASK_NODE_IMAGE = new ImageIcon("images/nav/task.png");

    //������ɽڵ�ͼƬ
    public static final ImageIcon FINISH_NODE_IMAGE = new ImageIcon("images/nav/finish.png");

    //����ʧ�ܽڵ�ͼƬ
    public static final ImageIcon FAIL_NODE_IMAGE = new ImageIcon("images/nav/fail.png");

    //������ɵĽڵ�
    public static final ImageIcon DOWNLOADING_NODE_IMAGE = new ImageIcon("images/nav/downloading.png");

    //��������״̬ͼƬ
    public static final ImageIcon DOWNLOADING_IMAGE = new ImageIcon("images/state/downloading.png");

    //����������Դ��ͼƬ
    public static final ImageIcon CONNECTING_IMAGE = new ImageIcon("images/state/connecting.png");

    //������ɵ�ͼƬ
    public static final ImageIcon FINISHED_IMAGE = new ImageIcon("images/state/finished.png");

    //�������ӵ�ͼƬ
    public static final ImageIcon FAILED_IMAGE = new ImageIcon("images/state/failed.png");

    //��ͣ���ص�ͼƬ
    public static final ImageIcon PAUSE_IMAGE = new ImageIcon("images/state/pause.png");
    //����ͼ��
    public static final String SUSPEND_IMAGE_PATH = "images/icon/mtdm.png";
    //������������˵�
    public static final ImageIcon SUSPEND_OPEN_IAMGE = new ImageIcon("images/suspend/open.png");
    //����������˵�
    public static final ImageIcon SUSPEND_NEW_IAMGE = new ImageIcon("images/suspend/add.png");
    //������ʼ����˵�
    public static final ImageIcon SUSPEND_START_IAMGE = new ImageIcon("images/suspend/start.png");
    //������ͣ����˵�
    public static final ImageIcon SUSPEND_PAUSE_IAMGE = new ImageIcon("images/suspend/pause.png");
    //ɾ�����������
    public static final ImageIcon SUSPEND_REMOVE_IAMGE = new ImageIcon("images/suspend/remove.png");
    //�˳��˵�
    public static final ImageIcon SUSPEND_QUIT_IAMGE = new ImageIcon("images/suspend/quit.png");
    //������ͼƬ
    public static final String TRAY_ICON_PATH = "images/icon/mtdm_trayicon.png";

    /**
     * ��������ͼƬ
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
