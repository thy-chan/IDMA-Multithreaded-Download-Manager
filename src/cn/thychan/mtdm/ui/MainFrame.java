package cn.thychan.mtdm.ui;

import cn.thychan.mtdm.ContextHolder;
import cn.thychan.mtdm.DownloadContext;
import cn.thychan.mtdm.info.Info;
import cn.thychan.mtdm.navigation.*;
import cn.thychan.mtdm.object.Resource;
import cn.thychan.mtdm.state.Downloading;
import cn.thychan.mtdm.state.Failed;
import cn.thychan.mtdm.state.Finished;
import cn.thychan.mtdm.state.Pause;
import cn.thychan.mtdm.util.DateUtil;
import cn.thychan.mtdm.util.FileUtil;
import cn.thychan.mtdm.util.ImageUtil;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by cn_cx on 2016/12/8.
 */

/**
 * ������
 */
public class MainFrame extends JFrame {

    //������
    private NavigationTree navTree;
    //�����б�
    private DownloadTable downloadTable;
    //��Ϣ�б�
    private JList infoJList;
    //������
    private JToolBar toolBar = new JToolBar();
    //���������
    private NewTaskFrame taskFrame;
    //���ڽ���
    private AboutFrame aboutFrame;
    //��������ڵ�
    private TaskNode taskNode = new TaskNode();
    //�������ؽڵ�
    private DownloadingNode downloadingNode = new DownloadingNode();
    //����ʧ�ܽڵ�
    private FailNode failNode = new FailNode();
    //������ɽڵ�
    private FinishNode finishNode = new FinishNode();
    //��ǰ�û�����Ľڵ�
    private DownloadNode currentNode = taskNode;

    //��Ϣ�б�Ķ���
    private final static String FILE_SIZE_TEXT = "�ļ���С: ";
    private final static String FILE_PATH_TEXT = "�ļ�·��: ";
    private final static String DOWNLOAD_DATE_TEXT = "����ʱ��: ";
    private final static String RESOURCE_INFO_TEXT = "��Դ��Ϣ: ";
    private List<Info> infoList = new ArrayList<Info>();
    private Info fileSize = new Info(FILE_SIZE_TEXT);
    private Info filePath = new Info(FILE_PATH_TEXT);
    private Info downloadDate = new Info(DOWNLOAD_DATE_TEXT);
    private Info info = new Info(RESOURCE_INFO_TEXT);

    private JButton newTask = create(new AbstractAction("������", new ImageIcon("images/tool/new_task.png")) {
        public void actionPerformed(ActionEvent e) {
            newTask();
        }
    });
    private JButton start = create(new AbstractAction("��ʼ", new ImageIcon("images/tool/begin.png")) {
        public void actionPerformed(ActionEvent e) {
            start();
        }
    });

    private JButton pause = create(new AbstractAction("��ͣ", new ImageIcon("images/tool/pause.png")) {
        public void actionPerformed(ActionEvent e) {
            pause();
        }
    });

    private JButton delete = create(new AbstractAction("ɾ������", new ImageIcon("images/tool/delete.png")) {
        public void actionPerformed(ActionEvent e) {
            delete();
        }
    });

    private JButton deleteFinished = create(new AbstractAction("�Ƴ�����", new ImageIcon("images/tool/remove.png")) {
        public void actionPerformed(ActionEvent e) {
            deleteFinished();
        }
    });

    private JButton about = create(new AbstractAction("�� ��", new ImageIcon("images/tool/about.png")) {
        public void actionPerformed(ActionEvent e) {
            about();
        }
    });

    ActionListener refreshTable = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //ˢ���б�
            downloadTable.updateUI();
        }
    };

    /**
     * ����JButton
     * @param action
     * @return
     */
    static JButton create(Action action) {
        JButton button = new JButton(action);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setHorizontalTextPosition(JButton.CENTER);
        return button;
    }

    //��������
    private SuspendWindow suspendWindow;
    //������ͼ��
    private TrayIcon trayIcon;
    //������ͼ��˵�
    private PopupMenu popupMenu = new PopupMenu();
    private MenuItem openItem = new MenuItem("��/�ر�");
    private MenuItem newItem = new MenuItem("�½���������");
    private MenuItem startItem = new MenuItem("��ʼȫ������");
    private MenuItem pauseItem = new MenuItem("��ͣȫ������");
    private MenuItem removeItem = new MenuItem("ɾ���������");
    private MenuItem aboutItem = new MenuItem("����");
    private MenuItem quitItem = new MenuItem("�˳�");

    private BufferedImage trayIconImage = ImageUtil.getImage(ImageUtil.TRAY_ICON_PATH);

    public MainFrame() {
        //����������
        createTree();
        createDownloadTable();
        //������Ϣ�б�
        createList();
        this.taskFrame = new NewTaskFrame();
        this.aboutFrame = new AboutFrame();
        //������������
        this.suspendWindow = new SuspendWindow(this);
        //����������ͼ��
        createTrayIcon();
        //����������
        createToolBar();
        //���������ڴ�С
        Dimension screen = new Dimension(1000,600);
        //��������
        JScrollPane navPane = new JScrollPane(this.navTree);
        JScrollPane downloadPane = new JScrollPane(this.downloadTable);
        int downloadPaneHeight = (int)(screen.height/1.5);
        int downloadPaneWidth = (int)(screen.width/0.8);
        downloadPane.setPreferredSize(new Dimension(downloadPaneWidth, downloadPaneHeight));
        JScrollPane infoPane = new JScrollPane(this.infoJList);
        //�������ұߵķָ�Pane
        JSplitPane rightPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                downloadPane, infoPane);
        rightPane.setDividerLocation(360);
        rightPane.setDividerSize(3);
        //������ķָ�Pane
        JSplitPane mainPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                navPane, rightPane);
        mainPane.setDividerSize(3);
        mainPane.setDividerLocation((int)(screen.width/5.5));

        this.add(mainPane);
        this.setPreferredSize(new Dimension(screen.width, screen.height));
        this.setVisible(true);
        this.setTitle("MTDM");
        this.pack();
        this.setLocation(450,210);
        initlisteners();
        //������ʱ��
        Timer timer = new Timer(1000, refreshTable);
        timer.start();
        //��ȡ���л��ļ�
        reverseSer();
    }



    public NewTaskFrame getNewTaskFrame() {
        return this.taskFrame;
    }

    public AboutFrame getAboutFrame(){
        return this.aboutFrame;
    }

    /**
     * ����������ͼ��
     */
    private void createTrayIcon() {
        this.popupMenu.add(openItem);
        this.popupMenu.add(newItem);
        this.popupMenu.add(startItem);
        this.popupMenu.add(pauseItem);
        this.popupMenu.add(removeItem);
        this.popupMenu.add(aboutItem);
        this.popupMenu.add(quitItem);

        try {
            SystemTray tray = SystemTray.getSystemTray();
            this.trayIcon = new TrayIcon(trayIconImage, "MTDM", this.popupMenu);
            this.trayIcon.setToolTip("MTDM");
            tray.add(this.trayIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initlisteners() {
        //����б���������
        this.downloadTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                //�õ��������Դ
                Resource r = getResource();
                if (r == null) return;
                //������Ϣ��ʾ�����ֵ
                fileSize.setValue(FILE_SIZE_TEXT + r.getSize());
                filePath.setValue(FILE_PATH_TEXT +
                        r.getSaveFile().getAbsolutePath());
                downloadDate.setValue(DOWNLOAD_DATE_TEXT +
                        DateUtil.formatDate(r.getDownloadDate()));
                info.setValue(RESOURCE_INFO_TEXT + r.getState().getState());
                //��������JList����
                infoJList.setListData(infoList.toArray());
            }
        });
        //�����������������
        this.navTree.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                selectTree();
            }
        });
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
        });
        //������ͼ�������
        this.trayIcon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    setVisible(true);
                }
            }
        });
        this.openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (isVisible()) setVisible(false);
                else setVisible(true);
            }
        });
        this.newItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                taskFrame.setVisible(true);
            }
        });
        this.startItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                startAllTask();
            }
        });
        this.pauseItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                pauseAllTask();
            }
        });
        this.removeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                deleteFinished();
            }
        });
        this.quitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                serializable();
                System.exit(0);
            }
        });
    }

    /**
     * ��������������ķ���
     */
    private void selectTree() {
        DownloadNode selectNode = getSelectNode();
        this.currentNode = selectNode;
        refreshTable();
    }

    /**
     * ˢ���б�
     */
    private void refreshTable() {
        DownloadTableModel model = (DownloadTableModel)this.downloadTable.getModel();
        model.setResources(ContextHolder.ctx.getResources(currentNode));
    }

    private DownloadNode getSelectNode() {
        TreePath treePath = this.navTree.getSelectionPath();
        if (treePath == null) return null;
        //���ѡ�е�TreeNode
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)treePath.getLastPathComponent();
        return (DownloadNode)node.getUserObject();
    }

    private void addTableData() {
        DownloadTableModel model = (DownloadTableModel)this.downloadTable.getModel();
        //���������Դ���õ��б���
        model.setResources(ContextHolder.ctx.resources);
        //ˢ���б�
        this.downloadTable.refresh();
    }

    /**
     * �����л�
     */
    public void reverseSer() {
        File serFile = FileUtil.SERIALIZABLE_FILE;
        if (!serFile.exists()) return;
        try {
            //�õ��ļ�������
            FileInputStream fis = new FileInputStream(serFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            //����ContextHolder��DownloadContext
            ContextHolder.ctx = (DownloadContext)ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //�����б�
        addTableData();
    }

    /**
     * ���л�(DownloadContext����)
     */
    public void serializable() {
        try {
            //���л�ǰ�Ƚ������������ص�����ֹͣ
            for (Resource r : ContextHolder.ctx.resources) {
                if (r.getState() instanceof Downloading) {
                    r.setState(ContextHolder.ctx.PAUSE);
                }
            }
            File serFile = FileUtil.SERIALIZABLE_FILE;
            //�ж����л��ļ��Ƿ����, �������򴴽�
            if (!serFile.exists()) serFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(serFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //�������Ķ���д�����л��ļ���
            oos.writeObject(ContextHolder.ctx);
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JTable getDownloadTable() {
        return this.downloadTable;
    }

    private void createDownloadTable() {
        DownloadTableModel tableModel = new DownloadTableModel();
        this.downloadTable = new DownloadTable();
        this.downloadTable.setModel(tableModel);
        this.downloadTable.setTableFace();
    }

    private void createToolBar() {
        this.toolBar.setFloatable(false);
        this.toolBar.add(this.newTask);
        this.toolBar.add(this.start);
        this.toolBar.add(this.pause);
        this.toolBar.add(this.delete);
        this.toolBar.add(this.deleteFinished);
        this.toolBar.add(this.about);

        this.toolBar.setMargin(new Insets(4, 10, 5, 10));
        this.add(this.toolBar, BorderLayout.NORTH);

    }

    private void start() {
        Resource r = getResource();
        if (r == null) return;
        if (r.getState() instanceof Pause || r.getState() instanceof Failed) {
            ContextHolder.dh.resumeDownload(r);
        }
    }

    /**
     * ��ʼȫ������
     */
    public void startAllTask() {
        for (Resource r : ContextHolder.ctx.resources) {
            if (r.getState() instanceof Pause || r.getState() instanceof Failed) {
                ContextHolder.dh.resumeDownload(r);
            }
        }
    }

    /**
     * ��ͣȫ������
     */
    public void pauseAllTask() {
        for (Resource r : ContextHolder.ctx.resources) {
            if (r.getState() instanceof Downloading) {
                r.setState(ContextHolder.ctx.PAUSE);
            }
        }
    }

    private void newTask() {
        this.taskFrame.setVisible(true);
    }

    private void pause() {
        Resource r = getResource();
        if (r == null) return;
        //�ж�״̬
        if (!(r.getState() instanceof Downloading)) return;
        r.setState(ContextHolder.ctx.PAUSE);
    }

    /**
     * ɾ����Դ
     */
    private void delete() {
        Resource r = getResource();
        if (r == null) return;
        //�Ƚ�����ֹͣ
        r.setState(ContextHolder.ctx.PAUSE);
        //ɾ�����е�.part�ļ�
        FileUtil.deletePartFiles(r);
        //�������ļ�����ɾ����Դ
        ContextHolder.ctx.resources.remove(r);
    }

    /**
     * ɾ����������ɵ���Դ
     */
    public void deleteFinished() {
        for (Iterator it = ContextHolder.ctx.resources.iterator(); it.hasNext();) {
            Resource r = (Resource)it.next();
            if (r.getState() instanceof Finished) {
                it.remove();
            }
        }
    }

    /**
     * ����
     */
    public void about(){
        this.aboutFrame.setVisible(true);
    }


    /**
     * �õ��û����б�����ѡ�����Դ
     */
    private Resource getResource() {
        int row = this.downloadTable.getSelectedRow();
        int column = this.downloadTable.getColumn(DownloadTableModel.ID_COLUMN).getModelIndex();
        if (row == -1) return null;
        String id = (String)this.downloadTable.getValueAt(row, column);
        return ContextHolder.ctx.getResource(id);
    }


    /**
     * ������
     */
    private void createTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode();
        DefaultMutableTreeNode tn = new DefaultMutableTreeNode(taskNode);
        root.add(tn);
        //���������ڵ�
        tn.add(new DefaultMutableTreeNode(downloadingNode));
        tn.add(new DefaultMutableTreeNode(failNode));
        tn.add(new DefaultMutableTreeNode(finishNode));
        this.navTree = new NavigationTree(root);
    }

    private void createList() {
        this.infoJList = new JList();
        this.infoList.add(this.fileSize);
        this.infoList.add(this.filePath);
        this.infoList.add(this.downloadDate);
        this.infoList.add(this.info);
        this.infoJList.setListData(infoList.toArray());
    }


}
