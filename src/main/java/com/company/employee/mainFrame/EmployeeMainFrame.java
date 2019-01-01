package main.java.com.company.employee.mainFrame;

import main.java.com.company.repository.WorkRecordManager;
import main.java.com.company.model.Employee;
import main.java.com.company.model.WorkRecord;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

/**
 * this class by created wuyongfei
 **/
public class EmployeeMainFrame extends JFrame {

    private JPanel titlePanel, namePanel, phonePanel, positionPanel, salaryPanel, buttonPanel;

    private JLabel titleLabel, nameLabel, phoneLabel, positionLabel, salaryLabel;

    private JTextField nameText, phoneText, positionText, salaryText;

    private JButton personalInfoButton, salaryDetailsButton, exitButton;

    private Integer uid; // 用户ID

    public EmployeeMainFrame(Employee employee) {
        super("员工工资管理系统");

        // 传递值
        this.uid = employee.getUid();
        BigDecimal basicSalary = employee.getSalary();

        // TODO: 2019/1/1 find work_record by uid
        WorkRecord workRecord = WorkRecordManager.getWorkRecordByUId(this.uid);
        workRecord.setBasicSalaryText(basicSalary);
        // 加班薪水
        BigDecimal overTimeSalary = workRecord.getOverTimeSalaryText().multiply(new BigDecimal(workRecord.getOverTimeNumText()));
        // 迟到薪水
        BigDecimal belateSalary = workRecord.getBeLateSalaryText().multiply(new BigDecimal(workRecord.getBeLateNumText()));
        // 早退薪水
        BigDecimal earlySalary = workRecord.getEarlySalaryText().multiply(new BigDecimal(workRecord.getEarlyNumText()));
        // 实际所得薪水
        BigDecimal realSalary = basicSalary.add(overTimeSalary).subtract(belateSalary).subtract(earlySalary);

        nameText = new JTextField(20);
        nameText.setText(employee.getName());
        nameText.setEditable(false);

        positionText = new JTextField(20);
        positionText.setText(employee.getRole());
        positionText.setEditable(false);

        phoneText = new JTextField(20);
        phoneText.setText(employee.getPhone());
        phoneText.setEditable(false);

        salaryText = new JTextField(20);
        salaryText.setText(realSalary.toString());
        salaryText.setEditable(false);

        // 创建容器
        Container container = this.getContentPane();
        BoxLayout ctlayout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(ctlayout);
        // 标题面板
        titleLabel = new JLabel("员工工资管理系统");
        titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        // 职位面板
        positionLabel = new JLabel("职位:");
        positionPanel = new JPanel();
        positionPanel.add(positionLabel);
        positionPanel.add(positionText);
        // 姓名面板
        nameLabel = new JLabel("姓名:");
        namePanel = new JPanel();
        namePanel.add(nameLabel);
        namePanel.add(nameText);
        // 联系电话面板
        phoneLabel = new JLabel("联系电话:");
        phonePanel = new JPanel();
        phonePanel.add(phoneLabel);
        phonePanel.add(phoneText);
        // 薪资面板
        salaryLabel = new JLabel("薪资:");
        salaryPanel = new JPanel();
        salaryPanel.add(salaryLabel);
        salaryPanel.add(salaryText);
        // 按钮面板
        personalInfoButton = new JButton("个人资料");
        salaryDetailsButton = new JButton("工资详情");
        exitButton = new JButton("安全退出");
        buttonPanel = new JPanel();
        buttonPanel.add(personalInfoButton);
        buttonPanel.add(salaryDetailsButton);
        buttonPanel.add(exitButton);
        // 将以上五个面板注册到容器中
        container.add(titlePanel);
        container.add(namePanel);
        //container.add(phonePanel);
        container.add(positionPanel);
        container.add(salaryPanel);
        container.add(buttonPanel);
        // 创建事件监听器对象
        EmployeeFindSalaryWindowListener mainListener = new EmployeeFindSalaryWindowListener(this.uid, this);
        EmployeeFindInfoListener infoListener = new EmployeeFindInfoListener(this, employee);
        // 向按钮添加监听时间
        salaryDetailsButton.addActionListener(mainListener);
        personalInfoButton.addActionListener(infoListener);
        exitButton.setActionCommand("exit");
        exitButton.addActionListener(mainListener);
        // 设置窗口属性
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
