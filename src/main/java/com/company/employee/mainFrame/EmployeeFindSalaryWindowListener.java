package main.java.com.company.employee.mainFrame;

import main.java.com.company.auth.LoginFrame;
import main.java.com.company.employee.salaryFrame.SalaryDetailsFrame;
import main.java.com.company.model.Employee;
import main.java.com.company.model.WorkRecord;
import main.java.com.company.repository.EmployeeManager;
import main.java.com.company.repository.WorkRecordManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

/**
 * this class by created wuyongfei
 **/
public class EmployeeFindSalaryWindowListener implements ActionListener {

    private Integer uid; // 用户ID

    private EmployeeMainFrame employeeMainFrame;

    public EmployeeFindSalaryWindowListener(Integer uid, EmployeeMainFrame employeeMainFrame) {
        this.uid = uid;
        this.employeeMainFrame = employeeMainFrame;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        employeeMainFrame.setVisible(false);
        if ("exit".equals(command)) {
            JOptionPane.showMessageDialog(null, "安全退出成功！");
            new LoginFrame();
        } else {
            // TODO: 2018/12/30 find salary by uid
            Employee employee = EmployeeManager.getEmployeeById(uid);
            WorkRecord salary = WorkRecordManager.getWorkRecordByUId(uid);
            salary.setBasicSalaryText(employee.getSalary());
/*            WorkRecord salary = new WorkRecord();
            salary.setBasicSalaryText(new BigDecimal(10000));
            salary.setBeLateSalaryText(new BigDecimal(100));
            salary.setBeLateNumText(2);
            salary.setEarlySalaryText(new BigDecimal(100));
            salary.setEarlyNumText(1);
            salary.setOverTimeSalaryText(new BigDecimal(100));
            salary.setOverTimeNumText(2);*/
            new SalaryDetailsFrame(salary, employeeMainFrame);
        }

    }

}
