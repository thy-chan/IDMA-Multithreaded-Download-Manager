package cn.thychan.mtdm.state;

import cn.thychan.mtdm.object.Resource;

import javax.swing.*;
import java.io.Serializable;

/**
 * Created by cn_cx on 2016/12/8.
 */

/**
 * 下载任务的状态接口
 */
public interface TaskState extends Serializable {

    /**
     * 返回该状态下的图片
     * @return
     */
    ImageIcon getIcon();

    /**
     * 返回状态的字符串
     * @return
     */
    String getState();

    /**
     * 该状态初始化执行的方法
     * @param resource
     */
    void init(Resource resource);

    /**
     * 该状态结束时执行的方法
     * @param resouse
     */
    void destory(Resource resouse);
}