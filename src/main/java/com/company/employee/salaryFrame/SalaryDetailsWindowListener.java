package main.java.com.company.employee.salaryFrame;

import main.java.com.company.employee.mainFrame.EmployeeMainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class by created wuyongfei
 **/
public class SalaryDetailsWindowListener implements ActionListener {

    private EmployeeMainFrame employeeMainFrame;

    private SalaryDetailsFrame salaryDetailsFrame;

    public SalaryDetailsWindowListener(EmployeeMainFrame employeeMainFrame, SalaryDetailsFrame salaryDetailsFrame) {
        this.employeeMainFrame = employeeMainFrame;
        this.salaryDetailsFrame = salaryDetailsFrame;
    }

    public void actionPerformed(ActionEvent e) {
        employeeMainFrame.setVisible(true);
        salaryDetailsFrame.setVisible(false);
    }
}
