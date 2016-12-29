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
        //资源暂停后取消任务
        ContextHolder.dh.stopTimer(resource);
    }

}

