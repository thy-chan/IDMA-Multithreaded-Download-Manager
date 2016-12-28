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
	 */
	ImageIcon getIcon();

	/**
	 * 返回状态的字符串
	 */
	String getState();

	/**
	 * 该状态初始化执行的方法
	 */
	void init(Resource resource);

	/**
	 * 该状态结束时执行的方法
	 */
	void destory(Resource resouse);
}
