package com.company;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Motel168LoginFrame extends JFrame {
    private JButton loginButton, exitButton;
    private ButtonGroup bg;
    private JPanel pName, ppwd, pbt;
    private JLabel lbName, lbpsd;
    private JTextField tfName;
    private JPasswordField ptfpsd;

    public Motel168LoginFrame() {
        super("Motel168客房管理系统");
        Container ct = this.getContentPane();
        BoxLayout ctlayout = new BoxLayout(ct, BoxLayout.Y_AXIS);
        ct.setLayout(ctlayout);
        lbName = new JLabel("用户名:");
        tfName = new JTextField(20);
        pName = new JPanel();
        pName.add(lbName);
        pName.add(tfName);
        lbpsd = new JLabel("密码:  ");
        ptfpsd = new JPasswordField(20);
        ppwd = new JPanel();
        ppwd.add(lbpsd);
        ppwd.add(ptfpsd);
        exitButton = new JButton("退  出");
        loginButton = new JButton("登 录");
        pbt = new JPanel();
        bg = new ButtonGroup();
        bg.add(loginButton);
        bg.add(exitButton);
        pbt.add(loginButton);
        pbt.add(exitButton);
        ct.add(pName);
        ct.add(ppwd);
        ct.add(pbt);
        // 创建事件监听器对象
        ButtonListener bListener = new ButtonListener();
        // 按钮注册事件监听器
        exitButton.addActionListener(bListener);
        loginButton.addActionListener(bListener);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // 定义事件监听器类
    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // 获取事件源
            JButton source = (JButton) e.getSource();
            if (source == exitButton) {
                System.exit(0);
            } else if (source == loginButton) {
                String userName = tfName.getText();
                String pw = ptfpsd.getText();
                if (userName.trim().length() == 0 || pw.trim().length() == 0) {
                    JOptionPane.showMessageDialog(null, "用户名和密码不能为空!");
                } else {
                    if ("admin".equals(userName) && "123456".equals(pw)) {
                        System.out.println("登录成功！");
                        System.exit(0);
//                        new RoomOrderFrame();            //跳转到RoomOrderFrame窗口
                    } else {
                        System.out.println("登录有误！");
                    }
                }
            }
        }
    }
}
