package cn.thychan.mtdm.ui;

import cn.thychan.mtdm.ContextHolder;
import cn.thychan.mtdm.DownloadContext;
import cn.thychan.mtdm.object.Resource;
import cn.thychan.mtdm.util.FileUtil;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;

/**
 * Created by cn_cx on 2016/12/8.
 */

public class NewTaskDialog extends JDialog {

    private static final String MSG = "请注意所需下载资源的扩展名格式, 否则会导致失败!";

    //下载地址
    private JLabel addressLabel = new JLabel("下载地址: ");
    private JTextField address = new JTextField(50);

    //提示的JLabel
    private JLabel warnLabel = new JLabel(" ");

    //保存路径
    private JLabel targetLabel = new JLabel("保存至:     ");
    private JTextField target = new JTextField(getDefaultFolder(), 20);

    //线程数
    private JLabel threadCountLabel = new JLabel("线程数: ");
    private JComboBox threadCount;
    private JButton targetSelectButton = new JButton("浏览");

    //文件名
    private JLabel saveFileNameLabel = new JLabel("另存文件名: ");
    private JTextField saveFileName = new JTextField(5);

    //按钮
    private JButton confirmButton = new JButton("确定");
    private JButton cancelButton = new JButton("取消");

    private FolderChooser folderChooser;

    public NewTaskDialog() {
        //创建线程下拉
        createThreadCountSelect();
        this.targetSelectButton.setFont(new Font(null, Font.PLAIN, 12));
        this.target.setEditable(false);
        //信息提示的JLabel
        Box warnBox = Box.createHorizontalBox();
        warnBox.add(this.warnLabel);
        //下载地址Box
        Box addressBox = Box.createHorizontalBox();
        addressBox.add(Box.createHorizontalStrut(50));
        addressBox.add(this.addressLabel);
        addressBox.add(Box.createHorizontalStrut(20));
        addressBox.add(this.address);
        addressBox.add(Box.createHorizontalStrut(50));
        //下载文件保存目录
        Box targetBox = Box.createHorizontalBox();
        targetBox.add(Box.createHorizontalStrut(50));
        targetBox.add(this.targetLabel);
        targetBox.add(Box.createHorizontalStrut(20));
        targetBox.add(this.target);
        targetBox.add(Box.createHorizontalStrut(50));
        targetBox.add(this.targetSelectButton);
        targetBox.add(Box.createHorizontalStrut(50));

        //另存文件名和目录选择按钮
        Box selectFolderBox = Box.createHorizontalBox();
        selectFolderBox.add(Box.createHorizontalStrut(50));
        selectFolderBox.add(this.saveFileNameLabel);
        selectFolderBox.add(Box.createHorizontalStrut(7));
        selectFolderBox.add(this.saveFileName);
        selectFolderBox.add(Box.createHorizontalStrut(50));

        saveFileName.setText(MSG);
        saveFileName.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if(saveFileName.getText().equals(MSG)){
                    saveFileName.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e)
            {
                if(saveFileName.getText().equals("")){
                    saveFileName.setText(MSG);
                }
            }
        });

        //线程选择
        Box threadBox = Box.createHorizontalBox();
        threadBox.add(Box.createHorizontalStrut(50));
        threadBox.add(this.threadCountLabel);
        threadBox.add(Box.createHorizontalStrut(33));
        threadBox.add(this.threadCount);
        threadBox.add(Box.createHorizontalStrut(330));
        //按钮Box
        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(Box.createHorizontalStrut(70));
        buttonBox.add(this.confirmButton);
        buttonBox.add(Box.createHorizontalStrut(40));
        buttonBox.add(this.cancelButton);
        buttonBox.add(Box.createHorizontalStrut(50));
        //主布局Box
        Box mainBox = Box.createVerticalBox();
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(warnBox);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(addressBox);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(targetBox);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(selectFolderBox);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(threadBox);
        mainBox.add(Box.createVerticalStrut(20));
        mainBox.add(buttonBox);
        mainBox.add(Box.createVerticalStrut(20));
        //得到屏幕大小
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screen.width/4, screen.height/4);

        this.add(mainBox);
        this.setTitle("新建下载任务");
        this.setResizable(false);
        this.setModal(true);
        this.pack();

        //初始化按钮监听器
        initLinsteners();
    }

    private void initLinsteners() {
        this.confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                confirm();
            }
        });
        this.cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        this.targetSelectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openFolderChooser();
            }
        });
        this.address.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                setSaveFileName();
            }
            public void insertUpdate(DocumentEvent e) {
                setSaveFileName();
            }
            public void removeUpdate(DocumentEvent e) {
                setSaveFileName();
            }
        });
    }

    private void confirm() {
        if (getSaveFileName() == null) {
            this.warnLabel.setText("请输入正确的文件名");
            return;
        }
        this.warnLabel.setText(" ");
        Resource r = createResource();
        ContextHolder.ctx.resources.add(r);
        ContextHolder.dh.doDownload(r);
        this.setVisible(false);
    }

    //根据界面输入创建Resource对象
    private Resource createResource() {
        String url = this.address.getText();
        String filePath = this.target.getText();
        String fileName = getSaveFileName();
        int threadCount = (Integer)this.threadCount.getSelectedItem();
        return new Resource(url, filePath, fileName, threadCount);
    }

    /**
     * 如果保存的文件名称为空, 则从url中截取文件名称
     * @return
     */
    private String getSaveFileName() {
        String url = this.address.getText();
        String saveFileName = this.saveFileName.getText();
        if (saveFileName == null || saveFileName.equals("")) {
            saveFileName = FileUtil.getFileName(url);
        }
        return saveFileName;
    }

    /**
     * 设置另存为名称的值
     */
    private void setSaveFileName() {
        saveFileName.setText("");
        saveFileName.setText(FileUtil.getFileName(address.getText()));
    }

    /**
     * 创建线程下拉
     */
    private void createThreadCountSelect() {
        this.threadCount = new JComboBox();
        for (int i = 1; i <= DownloadContext.MAX_THREAD_COUNT; i++) {
            this.threadCount.addItem(i);
        }
    }

    /**
     * 打开文件选择器
     */
    private void openFolderChooser() {
        if (this.folderChooser == null) {
            this.folderChooser = new FolderChooser();
        }
        folderChooser.showOpenDialog(null);
    }

    public String getDefaultFolder() {
        return System.getProperty("user.home");
    }

    /**
     * 选择目录后执行的方法
     * @param filePath
     */
    public void selectFolder(String filePath) {
        this.target.setText(filePath);
    }

    class FolderChooser extends JFileChooser {

        public FolderChooser() {
            super(new File(System.getProperty("user.home")));
            this.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        }

        public void approveSelection() {
            super.approveSelection();
            //设置当前打开的目录为默认目录
            this.setCurrentDirectory(this.getSelectedFile());
            selectFolder(this.getSelectedFile().getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        NewTaskDialog nsf = new NewTaskDialog();
        nsf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nsf.setVisible(true);
    }
}

