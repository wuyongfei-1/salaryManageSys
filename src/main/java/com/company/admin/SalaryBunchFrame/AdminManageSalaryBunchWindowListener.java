package main.java.com.company.admin.SalaryBunchFrame;

import main.java.com.company.admin.SalaryManageFrame.AdminManageSalaryUpdateFrame;
import main.java.com.company.admin.mainFrame.AdminManageInfoBunchFrame;
import main.java.com.company.model.Employee;
import main.java.com.company.model.WorkRecord;
import main.java.com.company.repository.EmployeeManager;
import main.java.com.company.repository.WorkRecordManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class by created wuyongfei
 **/
public class AdminManageSalaryBunchWindowListener implements ActionListener {

    private AdminManageSalaryBunchFrame adminManageSalaryBunchFrame;

    private Integer uid;

    private JComboBox uidComboBox;

    public AdminManageSalaryBunchWindowListener(AdminManageSalaryBunchFrame adminManageSalaryBunchFrame, JComboBox uidComboBox) {
        this.adminManageSalaryBunchFrame = adminManageSalaryBunchFrame;
        this.uidComboBox = uidComboBox;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        adminManageSalaryBunchFrame.setVisible(false);
        if ("return".equals(command)) {
            new AdminManageInfoBunchFrame();
        } else {
            /*WorkRecord salary = new WorkRecord();
            salary.setUid(0);
            salary.setOverTimeNumText(1);
            salary.setOverTimeSalaryText(new BigDecimal(100));
            salary.setEarlyNumText(2);
            salary.setEarlySalaryText(new BigDecimal(200));
            salary.setBeLateNumText(3);
            salary.setBeLateSalaryText(new BigDecimal(150));
            salary.setBasicSalaryText(new BigDecimal(10000));
            salary.setName("张三");*/
            // TODO: 2018/12/31 find current employee salary by uid
            this.uid = Integer.parseInt(uidComboBox.getSelectedItem().toString().trim());
            WorkRecord workRecord = WorkRecordManager.getWorkRecordByUId(uid);
            Employee employee = EmployeeManager.getEmployeeById(workRecord.getUid());
            workRecord.setBasicSalaryText(employee.getSalary());
            new AdminManageSalaryUpdateFrame(workRecord.getBasicSalaryText(), workRecord.getOverTimeNumText(), workRecord.getBeLateNumText(), workRecord.getEarlyNumText(), workRecord.getUid());
        }
    }
}
