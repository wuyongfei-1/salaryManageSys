package main.java.com.company.employee.infoFrame;

import main.java.com.company.employee.mainFrame.EmployeeMainFrame;
import main.java.com.company.employee.updateInfoFrame.EmployeeUpdateFrame;
import main.java.com.company.model.Employee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class by created wuyongfei
 **/
public class EmployeeUpdateInfoWindowListener implements ActionListener {

    private EmployeeMainFrame employeeMainFrame;

    private Employee employee;

    private EmployeeInfoFrame employeeInfoFrame;

    public EmployeeUpdateInfoWindowListener(EmployeeInfoFrame employeeInfoFrame, EmployeeMainFrame employeeMainFrame, Employee employee) {
        this.employeeMainFrame = employeeMainFrame;
        this.employee = employee;
        this.employeeInfoFrame = employeeInfoFrame;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        employeeInfoFrame.setVisible(false);
        if ("return".equals(command)) {
            new EmployeeMainFrame(employee);
        } else {
            new EmployeeUpdateFrame(employee, employeeMainFrame);
        }
    }
}
