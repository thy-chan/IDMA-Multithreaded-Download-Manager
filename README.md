# MTDM

MTDM(Multi-threaded Download Manager)

* Author: ThyChan

* Blog: http://thychan.cn

* GitHub: https://github.com/thy-chan

* Email: cn_cx@foxmail.com

* CodeType: Java

* development environment:

  ​	OS: Win10 64bit

  ​	IDE: Intellij IDEA

  ​	Java version: JDK1.8.0_112

  ​


## 1. 简介	
​	在我们平时使用互联网,获取资源时,最容易被忽视但又离不开的便是下载工具. 而现今市场上大部分人所使用的下载工具便是迅雷,百度云,QQ旋风,uTorrent,Internet Download Manager等等.而在使用这些工具的过程中, 应用开发商往往以利益优先而不是以用户体验优先,总是插入各种广告,或者VIP限制,其目标是将用户向**「吸引眼球」**而非**「关心真正重要的事」**的方向推进,从而脱离了下载工具的本质----下载资源. 例如某些下载应用强制插入浏览器,插入各种广告以及对下载网速进行限制等等.

​	在自选Java课题时,曾想过很多题目,如五子棋,聊天客户端,音乐播放器,小游戏等等.但考虑到以上几点以及实用性后, 便决定选取多线程下载工具这一题目, 仅当一次学习和锻炼.

​	该下载工具是由Java语言开发,并基于面向对象理论, 采用图形化界面的软件.其中涉及到了多线程技术以及网络技术.故命名为多线程下载管理器(Multi-threaded Download Manager),后文简称**MTDM**. GUI界面设计略微参考了Internet Download Manager的GUI界面. 编码设计过程中参考了Java疯狂讲义.



## 2. MTDM概述

### 2.1 分析设计 

**MTDM的GUI界面**大致包括主界面,添加下载资源的界面.

- 主界面拥有工具栏(新建,开始,暂停,删除,移除,关于),导航树(显示正在下载的资源,下载失败的资源和已下载完成的资源) ,下载列表以及资源信息列表


- 添加下载资源的界面有提示用户输入下载资源的地址链接, 存储到本地的路径,以及设置下载过程中的线程数.


**MTDM所涉及的功能**有创建任务,删除任务,开始任务,暂停任务,建立下载线程,对文件进行分割,合并.保存已下载资源的信息中用到对象的序列化与反序列化等.

主界面如下:

![mtdm](https://github.com/thy-chan/MTDM-Multithreaded-Download-Manager/tree/master/mtdm_imgs/mtdm.png)



### 2.2 项目实现编码概述

设计并编码实现见源码[MTDM](https://github.com/thy-chan/MTDM-Multithreaded-Download-Manager),及注释

MTDM源码列表:

```
MTDM(src)
cn.thychan.mtdm				//包名
--exception							//异常
------URLException							//URL异常
--info								//资源信息
------Info									//资源信息
--navigation					 	//导航树
------DownloadingNode				 		//正在下载的节点
------DownloadNode					 		//导航树的节点(接口)
------FailNode						 		//下载失败的节点
------FinishNode					 		//下载完成的节点
------TaskNode						 		//任务节点
--object							//对象
------Part									//块对象
------Resource								//资源对象
--state								//状态
------AbstractState							//抽象状态
------Connecting							//正在连接中
------Downloading							//正在下载
------Failed								//下载失败
------Finished								//下载完成
------Pause									//暂停
------TaskState								//资源状态接口
--thread							//线程
------DownloadHander						//用于处理文件的下载与继续下载
------DownloadThread						//下载线程
--ui								//用户界面
------AboutDialog							//关于对话框
------DownloadProgressBar					 //资源列表进度条
------DownloadTable							//下载列表
------DownloadTableCellRenderer				 //下载列表渲染器
------DownloadTableModel					 //下载表格式数据模型
------MainFrame								//主框架
------NavigationTree						//导航树
------NavigationTreeCellRender				 //导航树渲染器
------NewTaskDialog							//新建下载任务对话框
--util								//工具
------DateUtil								//日期工具,用于格式化时间
------FileUtil								//文件工具,文件相关的操作
------ImageUtil								//图片工具,用于加载图片资源
--ContextHolder						 //用于保存DownloadContext的唯一实例
--DownloadContext					 //上下文对象,保存一些公共信息
--Main								//Main方法,程序入口

images						//图片资源
--icon								//标题栏图标
--nav								//导航树图标
--state								//状态图标
--tool								//工具栏图标

META-INF					Build时用于生成Jar包
```

###2.3 测试

MTDM.jar已放置在项目文件的根目录下,只要拥有jre运行环境,便可以双击运行

简单测试如下:

![test](https://github.com/thy-chan/MTDM-Multithreaded-Download-Manager/tree/master/mtdm_imgs/temp.gif)



注:该项目,源码,文档仅限于交流学习,禁止转发及用于其他目的!