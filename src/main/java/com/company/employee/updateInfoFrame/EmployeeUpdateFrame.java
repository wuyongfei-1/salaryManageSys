package main.java.com.company.employee.updateInfoFrame;

import main.java.com.company.employee.mainFrame.EmployeeMainFrame;
import main.java.com.company.model.Employee;

import javax.swing.*;
import java.awt.*;

/**
 * this class by created wuyongfei
 **/
public class EmployeeUpdateFrame extends JFrame {

    private JPanel namePanel, phonePanel, buttonPanel, titlePanel, genderPanel, agePanel, addressPanel;

    private JLabel nameLabel, phoneLabel, titleLabel, genderLabel, ageLabel, addressLabel;

    private JTextField nameText, phoneText, ageText, addressText;

    private JComboBox genderComboBox;

    private JButton returnButton, editButton;

    public EmployeeUpdateFrame(Employee employee, EmployeeMainFrame employeeMainFrame) {
        super("员工工资管理系统");
        // 创建容器
        Container container = this.getContentPane();
        BoxLayout ctlayout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(ctlayout);
        // 标题面板
        titleLabel = new JLabel("员工个人信息管理");
        titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        // 姓名面板
        nameLabel = new JLabel("姓名:");
        nameText = new JTextField(20);
        nameText.setText(employee.getName());
        namePanel = new JPanel();
        namePanel.add(nameLabel);
        namePanel.add(nameText);
        // 性别面板
        genderLabel = new JLabel("性别:");
        genderComboBox = new JComboBox();
        genderComboBox.addItem("男");
        genderComboBox.addItem("女");
        if ("男".equals(employee.getGender())) {
            genderComboBox.setSelectedIndex(0);
        } else {
            genderComboBox.setSelectedIndex(1);
        }
        genderComboBox.setPreferredSize(new Dimension(222, 20));
        genderPanel = new JPanel();
        genderPanel.add(genderLabel);
        genderPanel.add(genderComboBox);
        // 年龄面板
        ageLabel = new JLabel("年龄:");
        ageText = new JTextField(20);
        ageText.setText(employee.getAge().toString());
        agePanel = new JPanel();
        agePanel.add(ageLabel);
        agePanel.add(ageText);
        // 个人住址面板
        addressLabel = new JLabel("个人地址:");
        addressText = new JTextField(20);
        addressText.setText(employee.getAddress());
        addressPanel = new JPanel();
        addressPanel.add(addressLabel);
        addressPanel.add(addressText);
        // 联系电话面板
        phoneLabel = new JLabel("联系电话:");
        phoneText = new JTextField(20);
        phoneText.setText(employee.getPhone());
        phonePanel = new JPanel();
        phonePanel.add(phoneLabel);
        phonePanel.add(phoneText);
        // 按钮面板
        buttonPanel = new JPanel();
        editButton = new JButton("修 改");
        buttonPanel.add(editButton);
        returnButton = new JButton("返 回");
        buttonPanel.add(returnButton);
        // 将以上五个面板注册到容器中
        container.add(titlePanel);
        container.add(namePanel);
        container.add(genderPanel);
        container.add(agePanel);
        container.add(addressPanel);
        container.add(phonePanel);
        container.add(buttonPanel);
        // 创建事件监听器对象
        EmployeeUpdateWindowListener bListener = new EmployeeUpdateWindowListener(this, employee.getUid(),nameText, genderComboBox, ageText, addressText, phoneText, employeeMainFrame);
        // 向按钮添加监听时间
        returnButton.setActionCommand("return");
        returnButton.addActionListener(bListener);
        editButton.addActionListener(bListener);
        // 设置窗口属性
        this.setSize(800, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
