package cn.thychan.mtdm;

import cn.thychan.mtdm.thread.DownloadHandler;

/**
 * Created by cn_cx on 2016/12/8.
 */

public class ContextHolder {
    //���ع���������
    public static DownloadContext ctx = new DownloadContext();
    //���ش�����
    public static DownloadHandler dh = new DownloadHandler();
}

