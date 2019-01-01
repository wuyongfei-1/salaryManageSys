package main.java.com.company.employee.infoFrame;

import main.java.com.company.employee.mainFrame.EmployeeMainFrame;
import main.java.com.company.model.Employee;
import sun.swing.table.DefaultTableCellHeaderRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;

/**
 * this class by created wuyongfei
 **/
public class EmployeeInfoFrame extends JFrame {

    private JPanel titlePanel, buttonPanel;

    private JScrollPane jScrollPane;

    private JTable personalShowTable;

    // 基本工资、加班所得、迟到所扣除、早退所扣除
    private JLabel titleLabel;

    private JButton returnButton, editButton;

    public EmployeeInfoFrame(Employee employee, EmployeeMainFrame employeeMainFrame) {
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
        String[] personalDataHead = {"姓名", "性别", "年龄", "个人住址", "职位", "联系电话"};
        String[][] personalDataBody = {{employee.getName(), employee.getGender(), employee.getAge().toString(), employee.getAddress(), employee.getRole(),
                employee.getPhone()}};
        personalShowTable = new JTable(personalDataBody, personalDataHead);
        personalShowTable.setEnabled(false);
        TableColumnModel columnModel = personalShowTable.getColumnModel();
        TableColumn column = columnModel.getColumn(3);
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
        editButton = new JButton("修 改");
        buttonPanel.add(editButton);
        returnButton = new JButton("返 回");
        buttonPanel.add(returnButton);
        // 将以上五个面板注册到容器中
        container.add(titlePanel);
        container.add(jScrollPane, BorderLayout.CENTER);
        container.add(buttonPanel);
        // 创建事件监听器对象
        EmployeeUpdateInfoWindowListener bListener = new EmployeeUpdateInfoWindowListener(this, employeeMainFrame, employee);
        // 向按钮添加监听时间
        returnButton.setActionCommand("return");
        returnButton.addActionListener(bListener);
        editButton.setActionCommand(employee.getUid().toString());
        editButton.addActionListener(bListener);
        // 设置窗口属性
        this.setSize(800, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


}
