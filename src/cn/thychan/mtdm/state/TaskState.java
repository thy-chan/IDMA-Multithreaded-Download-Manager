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
     */
    ImageIcon getIcon();

    /**
     * ����״̬���ַ���
     */
    String getState();

    /**
     * ��״̬��ʼ��ִ�еķ���
     */
    void init(Resource resource);

    /**
     * ��״̬����ʱִ�еķ���
     */
    void destory(Resource resouse);
}
