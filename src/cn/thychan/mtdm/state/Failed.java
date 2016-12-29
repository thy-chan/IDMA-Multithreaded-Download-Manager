package cn.thychan.mtdm.state;

import cn.thychan.mtdm.ContextHolder;
import cn.thychan.mtdm.object.Resource;
import cn.thychan.mtdm.util.ImageUtil;

import javax.swing.*;

/**
 * Created by cn_cx on 2016/12/8.
 */
public class Failed extends AbstractState {

    @Override
    public ImageIcon getIcon() {
        return ImageUtil.FAILED_IMAGE;
    }

    public String getState() {
        return "failed";
    }

    @Override
    public void init(Resource resource) {
        System.out.println(resource.getSaveFile().getAbsolutePath());
        System.out.println("��ֹͣ��");
        //����������Ϊ��������ʱ, ֹͣʱ�������
        ContextHolder.dh.stopTimer(resource);
    }

}
