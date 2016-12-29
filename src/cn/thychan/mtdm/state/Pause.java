package cn.thychan.mtdm.state;

import cn.thychan.mtdm.ContextHolder;
import cn.thychan.mtdm.object.Resource;
import cn.thychan.mtdm.util.ImageUtil;

import javax.swing.*;


/**
 * Created by cn_cx on 2016/12/8.
 */
public class Pause extends AbstractState {

    @Override
    public ImageIcon getIcon() {
        return ImageUtil.PAUSE_IMAGE;
    }

    @Override
    public String getState() {
        return "pause";
    }

    @Override
    public void init(Resource resource) {
        //��Դ��ͣ��ȡ������
        ContextHolder.dh.stopTimer(resource);
    }

}

