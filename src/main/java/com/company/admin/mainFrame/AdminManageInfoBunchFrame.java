package main.java.com.company.admin.mainFrame;

import main.java.com.company.model.Employee;
import main.java.com.company.repository.EmployeeManager;
import sun.swing.table.DefaultTableCellHeaderRenderer;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.List;
import java.util.Vector;

/**
 * this class by created wuyongfei
 **/
public class AdminManageInfoBunchFrame extends JFrame {

    private JPanel titlePanel, buttonPanel;

    private JScrollPane jScrollPane;

    private JTable personalShowTable;

    // 基本工资、加班所得、迟到所扣除、早退所扣除
    private JLabel titleLabel;

    private JButton exitButton, findSalaryButton;

    public AdminManageInfoBunchFrame() {
        super("员工工资管理系统");
        // 创建容器
        Container container = this.getContentPane();
        BoxLayout ctlayout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(ctlayout);
        // 标题面板
        titleLabel = new JLabel("员工个人信息管理");
        titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        // 表格面板
        Vector<Vector<String>> personalDataBody = new Vector<>();
        Vector<String> personalDataHead = new Vector<>();
        personalDataHead.add("工号");
        personalDataHead.add("姓名");
        personalDataHead.add("性别");
        personalDataHead.add("年龄");
        personalDataHead.add("职位");
        personalDataHead.add("个人住址");
        personalDataHead.add("联系电话");
        // TODO: 2018/12/31 get all personal info
        //List<Employee> bunchOfEmployee = new ArrayList<>();
        List<Employee> bunchOfEmployee =EmployeeManager.listEmployees();
        // loop employee group
        bunchOfEmployee.forEach(employee -> {
            Vector<String> columns = new Vector<>();
            columns.add(employee.getUid().toString());
            columns.add(employee.getName());
            columns.add(employee.getGender());
            columns.add(employee.getAge().toString());
            columns.add(employee.getRole());
            columns.add(employee.getAddress());
            columns.add(employee.getPhone());
            if (employee.getIdentity() != 0) {
                personalDataBody.add(columns);
            }
        });

        personalShowTable = new JTable(personalDataBody, personalDataHead);
        personalShowTable.setEnabled(false);
        TableColumnModel columnModel = personalShowTable.getColumnModel();
        TableColumn column = columnModel.getColumn(5);
        column.setPreferredWidth(300);
        column.setMaxWidth(300);
        column.setMinWidth(300);
        DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
        hr.setHorizontalAlignment(JLabel.CENTER);
        personalShowTable.getTableHeader().setDefaultRenderer(hr);
        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
        cr.setHorizontalAlignment(JLabel.CENTER);
        personalShowTable.setDefaultRenderer(Object.class, cr);
        jScrollPane = new JScrollPane(personalShowTable);
        // 按钮面板
        buttonPanel = new JPanel();
        findSalaryButton = new JButton("工资管理");
        buttonPanel.add(findSalaryButton);
        exitButton = new JButton("安全退出");
        buttonPanel.add(exitButton);
        // 将以上三个面板注册到容器中
        container.add(titlePanel);
        container.add(jScrollPane, BorderLayout.CENTER);
        container.add(buttonPanel);
        // 创建事件监听器对象
        AdminManageInfoBunchWindowListener bListener = new AdminManageInfoBunchWindowListener(this);
        // 向按钮添加监听时间
        exitButton.setActionCommand("exit");
        exitButton.addActionListener(bListener);
        findSalaryButton.addActionListener(bListener);
        // 设置窗口属性
        this.setSize(900, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}














