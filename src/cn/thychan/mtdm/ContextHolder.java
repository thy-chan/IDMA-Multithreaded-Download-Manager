package cn.thychan.mtdm;

import cn.thychan.mtdm.thread.DownloadHandler;

/**
 * Created by cn_cx on 2016/12/8.
 */

public class ContextHolder {
    //下载工具上下文
    public static DownloadContext ctx = new DownloadContext();
    //下载处理类
    public static DownloadHandler dh = new DownloadHandler();
}

