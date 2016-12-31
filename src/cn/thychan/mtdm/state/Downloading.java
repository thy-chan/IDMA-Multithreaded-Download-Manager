package cn.thychan.mtdm.state;

import cn.thychan.mtdm.util.ImageUtil;

import javax.swing.*;

/**
 * Created by cn_cx on 2016/12/8.
 */

public class Downloading extends AbstractState {

	@Override
	public ImageIcon getIcon() {
		return ImageUtil.DOWNLOADING_IMAGE;
	}
	public String getState() {
		return "downloading";
	}
}
