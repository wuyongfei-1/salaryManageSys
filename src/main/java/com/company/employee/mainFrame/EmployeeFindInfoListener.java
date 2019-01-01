package main.java.com.company.employee.mainFrame;

import main.java.com.company.model.Employee;
import main.java.com.company.employee.infoFrame.EmployeeInfoFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class by created wuyongfei
 **/
public class EmployeeFindInfoListener implements ActionListener {

    private EmployeeMainFrame employeeMainFrame;

    private Employee employee;

    public EmployeeFindInfoListener(EmployeeMainFrame employeeMainFrame, Employee employee) {
        this.employeeMainFrame = employeeMainFrame;
        this.employee = employee;
    }

    public void actionPerformed(ActionEvent e) {
        employeeMainFrame.setVisible(false);
        new EmployeeInfoFrame(employee, employeeMainFrame);
    }
}
