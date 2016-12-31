package cn.thychan.mtdm.state;

import cn.thychan.mtdm.object.Resource;

import javax.swing.*;
import java.io.Serializable;

/**
 * Created by cn_cx on 2016/12/8.
 */

/**
 * ���������״̬�ӿ�
 */
public interface TaskState extends Serializable {

    /**
     * ���ظ�״̬�µ�ͼƬ
     * @return
     */
    ImageIcon getIcon();

    /**
     * ����״̬���ַ���
     * @return
     */
    String getState();

    /**
     * ��״̬��ʼ��ִ�еķ���
     * @param resource
     */
    void init(Resource resource);

    /**
     * ��״̬����ʱִ�еķ���
     * @param resouse
     */
    void destory(Resource resouse);
}