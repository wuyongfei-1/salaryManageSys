package main.java.com.company.employee.salaryFrame;

import main.java.com.company.employee.mainFrame.EmployeeMainFrame;
import main.java.com.company.model.WorkRecord;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

/**
 * this class by created wuyongfei
 **/
public class SalaryDetailsFrame extends JFrame {

    private JPanel titlePanel, basicSalaryPanel, overTimePanel, beLatePanel, earlyPanel, buttonPanel, realPanel;

    private JLabel titleLabel, basicSalaryLabel, overTimeLabel, beLateLabel, earlyLabel, realLabel;

    // 基本工资、加班所得、迟到所扣除、早退所扣除
    private JTextField basicSalaryText, overTimeSalaryText, beLateSalaryText, earlySalaryText, realSalaryText;

    private JButton returnButton;

    public SalaryDetailsFrame(WorkRecord salary, EmployeeMainFrame employeeMainFrame) {
        super("员工工资管理系统");
        this.basicSalaryLabel = new JLabel("基本工资：\t\t");
        this.basicSalaryText = new JTextField(20);
        this.basicSalaryText.setText(salary.getBasicSalaryText().toString());
        this.basicSalaryText.setEditable(false);
        this.overTimeLabel = new JLabel("加班情况：\t\t");
        this.overTimeSalaryText = new JTextField(20);
        this.overTimeSalaryText.setEditable(false);
        this.overTimeSalaryText.setText(salary.getOverTimeNumText() != 0 ? salary.getOverTimeSalaryText() + " * " + salary.getOverTimeNumText() : " 无");
        this.beLateLabel = new JLabel("迟到情况：\t\t");
        this.beLateSalaryText = new JTextField(20);
        this.beLateSalaryText.setEditable(false);
        this.beLateSalaryText.setText(salary.getBeLateNumText() !=0 ? salary.getBeLateSalaryText().toString() + " * " + salary.getBeLateNumText() : " 无");
        this.earlyLabel = new JLabel("早退情况：\t\t");
        this.earlySalaryText = new JTextField(20);
        this.earlySalaryText.setEditable(false);
        this.earlySalaryText.setText(salary.getEarlyNumText() !=0 ? salary.getEarlySalaryText() + " * " + salary.getEarlyNumText() : " 无");
        this.realLabel = new JLabel("实际应发：\t\t");
        this.realSalaryText = new JTextField(20);
        this.realSalaryText.setEditable(false);
        // 加班薪水
        BigDecimal overTimeSalary = salary.getOverTimeSalaryText().multiply(new BigDecimal(salary.getOverTimeNumText()));
        // 迟到薪水
        BigDecimal belateSalary = salary.getBeLateSalaryText().multiply(new BigDecimal(salary.getBeLateNumText()));
        // 早退薪水
        BigDecimal earlySalary = salary.getEarlySalaryText().multiply(new BigDecimal(salary.getEarlyNumText()));
        // 实际所得薪水
        BigDecimal realSalary = salary.getBasicSalaryText().add(overTimeSalary).subtract(belateSalary).subtract(earlySalary);
        this.realSalaryText.setText(realSalary.toString());

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
        this.basicSalaryText.setSize(150, 20);
        basicSalaryPanel.add(this.basicSalaryText);
        // 加班面板
        overTimePanel = new JPanel();
        overTimePanel.add(this.overTimeLabel);
        overTimePanel.add(this.overTimeSalaryText);
        // 迟到面板
        beLatePanel = new JPanel();
        beLatePanel.add(this.beLateLabel);
        beLatePanel.add(this.beLateSalaryText);
        // 早退面板
        earlyPanel = new JPanel();
        earlyPanel.add(this.earlyLabel);
        earlyPanel.add(this.earlySalaryText);
        // 实际应发
        realPanel = new JPanel();
        realPanel.add(realLabel);
        realPanel.add(realSalaryText);
        // 按钮面板
        buttonPanel = new JPanel();
        returnButton = new JButton("返 回");
        buttonPanel.add(returnButton);
        // 将以上五个面板注册到容器中
        container.add(titlePanel);
        container.add(basicSalaryPanel);
        container.add(overTimePanel);
        container.add(beLatePanel);
        container.add(earlyPanel);
        container.add(realPanel);
        container.add(buttonPanel);
        // 创建事件监听器对象
        SalaryDetailsWindowListener bListener = new SalaryDetailsWindowListener(employeeMainFrame, this);
        // 向按钮添加监听时间
        returnButton.addActionListener(bListener);
        // 设置窗口属性
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
