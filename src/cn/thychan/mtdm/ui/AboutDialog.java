package cn.thychan.mtdm.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 2016/12/8.
 */

public class AboutDialog extends JDialog {
    //提示的JLabel
    private JLabel about = new JLabel("MTDM(Multi-threaded Download Manager)");
    private JLabel author = new JLabel("Author:   ThyChan");
    private JLabel blog = new JLabel("Blog:       http://thychan.cn");
    private JLabel github = new JLabel("GitHub:   https://github.com/thy-chan");
    private JLabel email = new JLabel("Email:     cn_cx@foxmail.com");

    //按钮
    private JButton confirmButton = new JButton("确定");

    public AboutDialog() {
        //信息提示的JLabel
        Box aboutBox = Box.createVerticalBox();
        aboutBox.add(this.about);
        aboutBox.add(this.author);
        aboutBox.add(this.blog);
        aboutBox.add(this.github);
        aboutBox.add(this.email);
        //按钮Box
        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(Box.createHorizontalStrut(120));
        buttonBox.add(this.confirmButton);
        //主布局Box
        Box mainBox = Box.createVerticalBox();
        mainBox.add(Box.createVerticalStrut(25));
        mainBox.add(aboutBox);
        mainBox.add(Box.createVerticalStrut(25));
        mainBox.add(buttonBox);
        mainBox.add(Box.createVerticalStrut(25));
        //得到屏幕大小
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((int)(screen.width/2.5), (int)(screen.height/2.5));

        this.add(mainBox);
        this.setTitle(" 关于");
        this.pack();
        this.setResizable(false);
        this.setModal(true);
        //初始化按钮监听器
        initLinsteners();
    }

    private void initLinsteners() {
        this.confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        AboutDialog aboutDialog = new AboutDialog();
        aboutDialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aboutDialog.setVisible(true);
    }
}