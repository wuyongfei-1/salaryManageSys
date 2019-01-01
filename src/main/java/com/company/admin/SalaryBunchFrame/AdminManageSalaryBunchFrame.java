package main.java.com.company.admin.SalaryBunchFrame;

import main.java.com.company.model.Employee;
import main.java.com.company.model.WorkRecord;
import main.java.com.company.repository.EmployeeManager;
import main.java.com.company.repository.WorkRecordManager;
import sun.swing.table.DefaultTableCellHeaderRenderer;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Vector;

/**
 * this class by created wuyongfei
 **/
public class AdminManageSalaryBunchFrame extends JFrame {
    // 面板 panel
    private JPanel titlePanel, buttonPanel;
    // 标签 label
    private JLabel titleLabel, promptLabel;
    // 注册按钮 registButton
    private JButton adjustSalaryButton, returnButton;

    private JTable salaryShowTable;

    private JScrollPane jScrollPane;

    private JComboBox uidComboBox;

    public AdminManageSalaryBunchFrame() {
        super("员工工资管理系统");
        // 创建容器
        Container container = this.getContentPane();
        BoxLayout ctlayout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(ctlayout);
        // 标题面板
        titleLabel = new JLabel("员工工资管理系统");
        titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        uidComboBox = new JComboBox();
        uidComboBox.setPreferredSize(new Dimension(80, 20));
        // 表格面板
        Vector<Vector<String>> personalDataBody = new Vector<>();
        Vector<String> personalDataHead = new Vector<>();
        personalDataHead.add("工号");
        personalDataHead.add("姓名");
        personalDataHead.add("基本工资");
        personalDataHead.add("加班所得");
        personalDataHead.add("迟到所扣");
        personalDataHead.add("早退所扣");
        personalDataHead.add("实发工资");
        // TODO: 2018/12/31 get all personal info
        //List<WorkRecord> bunchOfSalary = new ArrayList<>();
/*        WorkRecord salarys = new WorkRecord();
        salarys.setUid(0);
        salarys.setOverTimeNumText(1);
        salarys.setOverTimeSalaryText(new BigDecimal(100));
        salarys.setEarlyNumText(2);
        salarys.setEarlySalaryText(new BigDecimal(200));
        salarys.setBeLateNumText(3);
        salarys.setBeLateSalaryText(new BigDecimal(150));
        salarys.setBasicSalaryText(new BigDecimal(10000));
        salarys.setName("张三");
        bunchOfSalary.add(salarys);*/
        List<WorkRecord> bunchOfSalary = WorkRecordManager.listWorkRecords();
        // loop salary group
        bunchOfSalary.forEach(salary -> {
            Employee employee = EmployeeManager.getEmployeeById(salary.getUid());
            salary.setBasicSalaryText(employee.getSalary());
            // 加班薪水
            BigDecimal overTimeSalary = salary.getOverTimeSalaryText().multiply(new BigDecimal(salary.getOverTimeNumText()));
            // 迟到薪水
            BigDecimal belateSalary = salary.getBeLateSalaryText().multiply(new BigDecimal(salary.getBeLateNumText()));
            // 早退薪水
            BigDecimal earlySalary = salary.getEarlySalaryText().multiply(new BigDecimal(salary.getEarlyNumText()));
            // 实际所得薪水
            BigDecimal realSalary = salary.getBasicSalaryText().add(overTimeSalary).subtract(belateSalary).subtract(earlySalary);
            Vector<String> columns = new Vector<>();
            columns.add(salary.getUid().toString());
            columns.add(salary.getName());
            columns.add(salary.getBasicSalaryText().toString());
            columns.add(salary.getOverTimeSalaryText() + " * " + salary.getOverTimeNumText());
            columns.add(salary.getBeLateSalaryText() + " * " + salary.getBeLateNumText());
            columns.add(salary.getEarlySalaryText() + " * " + salary.getEarlyNumText());
            columns.add(realSalary.toString());
            uidComboBox.addItem(salary.getUid());
            personalDataBody.add(columns);
        });
        salaryShowTable = new JTable(personalDataBody, personalDataHead);
        salaryShowTable.setEnabled(false);
        DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
        hr.setHorizontalAlignment(JLabel.CENTER);
        salaryShowTable.getTableHeader().setDefaultRenderer(hr);
        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
        cr.setHorizontalAlignment(JLabel.CENTER);
        salaryShowTable.setDefaultRenderer(Object.class, cr);
        jScrollPane = new JScrollPane(salaryShowTable);
        // 按钮面板
        buttonPanel = new JPanel();
        adjustSalaryButton = new JButton("修 改");
        returnButton = new JButton("返 回");
        promptLabel = new JLabel("工号：");
        buttonPanel.add(promptLabel);
        buttonPanel.add(uidComboBox);
        buttonPanel.add(adjustSalaryButton);
        buttonPanel.add(returnButton);
        // 将以上三个面板注册到容器中
        container.add(titlePanel);
        container.add(jScrollPane, BorderLayout.CENTER);
        container.add(buttonPanel);
        // 创建事件监听器对象
        AdminManageSalaryBunchWindowListener bListener = new AdminManageSalaryBunchWindowListener(this, uidComboBox);
        // 向按钮添加监听时间
        returnButton.setActionCommand("return");
        returnButton.addActionListener(bListener);
        adjustSalaryButton.addActionListener(bListener);
        // 设置窗口属性
        this.setSize(900, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

