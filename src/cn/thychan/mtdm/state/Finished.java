package cn.thychan.mtdm.state;

import cn.thychan.mtdm.ContextHolder;
import cn.thychan.mtdm.object.Resource;
import cn.thychan.mtdm.util.FileUtil;
import cn.thychan.mtdm.util.ImageUtil;

import javax.swing.*;

/**
 * Created by cn_cx on 2016/12/8.
 */
public class Finished extends AbstractState {

    @Override
    public ImageIcon getIcon() {
        return ImageUtil.FINISHED_IMAGE;
    }

    public String getState() {
        return "finished";
    }

    public void init(Resource resource) {
        //删除临时文件
        FileUtil.deletePartFiles(resource);
        //资源下载完成后取消任务
        ContextHolder.dh.stopTimer(resource);
    }


}

