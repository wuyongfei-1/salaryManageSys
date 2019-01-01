package main.java.com.company.auth;

import javax.swing.*;
import java.awt.*;

/**
 * this class by created wuyongfei
 **/
public class RegistFrame extends JFrame {

    private JPanel userNamePanel, namePanel, positionPanel, phonePanel, passwordPanel,
            againPasswordPanel, buttonPanel, titlePanel, genderPanel, agePanel, addressPanel;

    private JLabel userNameLabel, nameLabel, positionLabel, phoneLabel, passwordLabel,
            againPasswordLabel, titleLabel, genderLabel, ageLabel, addressLabel;

    private JTextField userNameText, nameText, phoneText, ageText, addressText;

    private JPasswordField passwordText, againPasswordText;

    private JButton registButton, cacelButton;

    private JComboBox positionComboBox, genderComboBox;


    public RegistFrame() {
        super("员工工资管理系统");
        // 创建容器
        Container container = this.getContentPane();
        BoxLayout ctlayout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(ctlayout);
        // 标题面板
        titleLabel = new JLabel("员工工资管理系统");
        titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        // 职位面板
        positionLabel = new JLabel("职位：");
        positionComboBox = new JComboBox();
        positionComboBox.addItem("后端开发工程师");
        positionComboBox.addItem("前端开发工程师");
        positionComboBox.addItem("测试工程师");
        positionComboBox.addItem("Web开发工程师");
        positionPanel = new JPanel();
        positionPanel.add(positionLabel);
        positionPanel.add(positionComboBox);
        // 姓名面板
        nameLabel = new JLabel("姓名：");
        nameText = new JTextField(20);
        namePanel = new JPanel();
        namePanel.add(nameLabel);
        namePanel.add(nameText);
        // 性别面板
        genderLabel = new JLabel("性别：");
        genderComboBox = new JComboBox();
        genderComboBox.addItem("男");
        genderComboBox.addItem("女");
        genderComboBox.setPreferredSize(new Dimension(222,20));
        genderPanel = new JPanel();
        genderPanel.add(genderLabel);
        genderPanel.add(genderComboBox);
        // 年龄面板
        ageLabel = new JLabel("年龄：");
        ageText = new JTextField(20);
        agePanel = new JPanel();
        agePanel.add(ageLabel);
        agePanel.add(ageText);
        // 个人住址面板
        addressLabel = new JLabel("个人地址：");
        addressText = new JTextField(20);
        addressPanel = new JPanel();
        addressPanel.add(addressLabel);
        addressPanel.add(addressText);
        // 联系电话面板
        phoneLabel = new JLabel("联系电话：");
        phoneText = new JTextField(20);
        phonePanel = new JPanel();
        phonePanel.add(phoneLabel);
        phonePanel.add(phoneText);
        // 用户名面板
        userNameLabel = new JLabel("用户名：");
        userNameText = new JTextField(20);
        userNamePanel = new JPanel();
        userNamePanel.add(userNameLabel);
        userNamePanel.add(userNameText);
        // 密码面板
        passwordLabel = new JLabel("密码： ");
        passwordText = new JPasswordField(20);
        passwordPanel = new JPanel();
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordText);
        // 密码面板
        passwordLabel = new JLabel("密码： ");
        passwordText = new JPasswordField(20);
        passwordPanel = new JPanel();
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordText);
        // 确认密码面板
        againPasswordLabel = new JLabel("确认密码： ");
        againPasswordText = new JPasswordField(20);
        againPasswordPanel = new JPanel();
        againPasswordPanel.add(againPasswordLabel);
        againPasswordPanel.add(againPasswordText);
        // 按钮面板
        registButton = new JButton("确 定");
        cacelButton = new JButton("取 消");
        buttonPanel = new JPanel();
        buttonPanel.add(registButton);
        buttonPanel.add(cacelButton);
        // 将以上八个面板注册到容器中
        container.add(titlePanel);
        container.add(positionPanel);
        container.add(namePanel);
        container.add(genderPanel);
        container.add(agePanel);
        container.add(userNamePanel);
        container.add(passwordPanel);
        container.add(againPasswordPanel);
        container.add(addressPanel);
        container.add(phonePanel);
        container.add(buttonPanel);
        // 创建事件监听器对象
        RegistWindowListener bListener = new RegistWindowListener(genderComboBox, ageText, addressText, userNameText, passwordText, againPasswordText, positionComboBox, nameText, phoneText, registButton, cacelButton, this);
        // 向按钮添加监听时间
        registButton.addActionListener(bListener);
        cacelButton.addActionListener(bListener);
        // 设置窗口属性
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}