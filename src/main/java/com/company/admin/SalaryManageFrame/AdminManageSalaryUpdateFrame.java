package main.java.com.company.admin.SalaryManageFrame;


import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

/**
 * this class by created wuyongfei
 **/
public class AdminManageSalaryUpdateFrame extends JFrame {

    private JPanel titlePanel, basicSalaryPanel, overTimePanel, beLatePanel, earlyPanel, buttonPanel;

    // 基本工资、加班所得、迟到所扣除、早退所扣除
    private JLabel titleLabel, basicSalaryLabel, basicSalaryText, overTimeLabel, beLateLabel, earlyLabel;

    private JTextField overTimeNumText, beLateNumText, earlyNumText;

    private JButton returnButton, affirmButton;

    // private TextArea overTimeNumText, beLateNumText, earlyNumText;

    public AdminManageSalaryUpdateFrame(BigDecimal basicSalaryText, Integer overTimeNumText, Integer beLateNumText, Integer earlyNumText, Integer uid) {
        super("员工工资管理系统");
        this.basicSalaryLabel = new JLabel("基本工资:\t\t");
        this.basicSalaryText = new JLabel(basicSalaryText.toString() + "元");
        this.overTimeLabel = new JLabel("加班次数：\t\t");
        this.overTimeNumText = new JTextField(overTimeNumText.toString());
        this.overTimeNumText.setColumns(10);
        this.beLateLabel = new JLabel("迟到次数：\t\t");
        this.beLateNumText = new JTextField(beLateNumText.toString());
        this.beLateNumText.setColumns(10);
        this.earlyLabel = new JLabel("早退次数：\t\t");
        this.earlyNumText = new JTextField(earlyNumText.toString());
        this.earlyNumText.setColumns(10);

        // 创建容器
        Container container = this.getContentPane();
        BoxLayout ctlayout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(ctlayout);
        // 标题面板
        titleLabel = new JLabel("员工工资管理系统");
        titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        // 基本工资面板
        basicSalaryPanel = new JPanel();
        basicSalaryPanel.add(this.basicSalaryLabel);
        basicSalaryPanel.add(this.basicSalaryText);
        // 加班面板
        overTimePanel = new JPanel();
        overTimePanel.add(this.overTimeLabel);
        overTimePanel.add(this.overTimeNumText);
        // 迟到面板
        beLatePanel = new JPanel();
        beLatePanel.add(this.beLateLabel);
        beLatePanel.add(this.beLateNumText);
        // 早退面板
        earlyPanel = new JPanel();
        earlyPanel.add(this.earlyLabel);
        earlyPanel.add(this.earlyNumText);
        // 按钮面板
        buttonPanel = new JPanel();
        affirmButton = new JButton("确 定");
        returnButton = new JButton("返 回");
        buttonPanel.add(affirmButton);
        buttonPanel.add(returnButton);
        // 将以上六个面板注册到容器中
        container.add(titlePanel);
        container.add(basicSalaryPanel);
        container.add(overTimePanel);
        container.add(beLatePanel);
        container.add(earlyPanel);
        container.add(buttonPanel);
        // 创建事件监听器对象
        AdminManageSalaryUpdateWindowListener bListener = new AdminManageSalaryUpdateWindowListener(this, uid, this.overTimeNumText, this.beLateNumText, this.earlyNumText);
        // 向按钮添加监听时间
        returnButton.setActionCommand("return");
        returnButton.addActionListener(bListener);
        affirmButton.addActionListener(bListener);
        // 设置窗口属性
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(null);
    }
}
