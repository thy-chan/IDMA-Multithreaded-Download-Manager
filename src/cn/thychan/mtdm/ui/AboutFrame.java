package cn.thychan.mtdm.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 2016/12/8.
 */
public class AboutFrame extends JFrame {
    //提示的JLabel
    private JLabel author = new JLabel("Author: ThyChan");
    private JLabel blog = new JLabel("Blog: http://thychan.cn");
    private JLabel github = new JLabel("GitHub: https://github.com/thy-chan");
    private JLabel email = new JLabel("email: cn_cx@foxmail.com");

    //按钮
    private JButton confirmButton = new JButton("确定");

    public AboutFrame() {
        //信息提示的JLabel
        Box warnBox = Box.createVerticalBox();
        warnBox.add(this.author);
        warnBox.add(this.blog);
        warnBox.add(this.github);
        warnBox.add(this.email);
        //按钮Box
        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(Box.createHorizontalStrut(70));
        buttonBox.add(this.confirmButton);
        //主布局Box
        Box mainBox = Box.createVerticalBox();
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(warnBox);
        mainBox.add(Box.createVerticalStrut(10));

        mainBox.add(Box.createVerticalStrut(20));
        mainBox.add(buttonBox);
        mainBox.add(Box.createVerticalStrut(20));
        //得到屏幕大小
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screen.width/3+10, screen.height/3+10);

        this.add(mainBox);
        this.setTitle("About");
        this.pack();
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
        AboutFrame aboutFrame = new AboutFrame();
        aboutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aboutFrame.setVisible(true);
    }

}
