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
        //ɾ����ʱ�ļ�
        FileUtil.deletePartFiles(resource);
        //��Դ������ɺ�ȡ������
        ContextHolder.dh.stopTimer(resource);
    }


}

