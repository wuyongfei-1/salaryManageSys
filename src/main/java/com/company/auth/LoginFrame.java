package main.java.com.company.auth;

import java.awt.*;

import javax.swing.*;

/**
 * this class by created wuyongfei
 **/
public class LoginFrame extends JFrame {
    // 面板 panel
    private JPanel userNamePanel, passwordPanel, buttonPanel, titlePanel;
    // 标签 label
    private JLabel userNameLabel, passwordLabel, titleLabel;
    // 文本框 textField
    private JTextField userNameText;
    // 密码框 passFiled
    private JPasswordField passwordText;
    // 注册按钮 registButton
    private JButton registButton;
    // 登录按钮 loginButton
    private JButton loginButton;

    public LoginFrame() {
        super("员工工资管理系统");
        // 创建容器
        Container container = this.getContentPane();
        BoxLayout ctlayout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(ctlayout);
        // 标题面板
        titleLabel = new JLabel("员工工资管理系统");
        titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        // 用户名面板
        userNameLabel = new JLabel("用户名:");
        userNameText = new JTextField(20);
        userNamePanel = new JPanel();
        userNamePanel.add(userNameLabel);
        userNamePanel.add(userNameText);
        // 密码面板
        passwordLabel = new JLabel("密码:  ");
        passwordText = new JPasswordField(20);
        passwordPanel = new JPanel();
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordText);
        // 按钮面板
        registButton = new JButton("注 册");
        loginButton = new JButton("登 录");
        buttonPanel = new JPanel();
        buttonPanel.add(loginButton);
        buttonPanel.add(registButton);
        // 将以上三个面板注册到容器中
        container.add(titlePanel);
        container.add(userNamePanel);
        container.add(passwordPanel);
        container.add(buttonPanel);
        // 创建事件监听器对象
        LoginWindowListener bListener = new LoginWindowListener(userNameText, passwordText, loginButton, registButton,this);
        // 向按钮添加监听时间
        registButton.addActionListener(bListener);
        loginButton.addActionListener(bListener);
        // 设置窗口属性
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
