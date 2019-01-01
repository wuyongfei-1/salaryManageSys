package main.java.com.company.employee.updateInfoFrame;

import main.java.com.company.model.Employee;
import main.java.com.company.employee.infoFrame.EmployeeInfoFrame;
import main.java.com.company.employee.mainFrame.EmployeeMainFrame;
import main.java.com.company.repository.EmployeeManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class by created wuyongfei
 **/
public class EmployeeUpdateWindowListener implements ActionListener {

    private EmployeeUpdateFrame employeeUpdateFrame;

    private Employee employee;

    private EmployeeMainFrame employeeMainFrame;

    private JTextField nameText, ageText, addressText, phoneText;

    private JComboBox genderComboBox;

    private Integer uid;

    public EmployeeUpdateWindowListener(EmployeeUpdateFrame employeeUpdateFrame, Integer uid, JTextField nameText, JComboBox genderComboBox, JTextField ageText, JTextField addressText, JTextField phoneText, EmployeeMainFrame employeeMainFrame) {
        this.employeeUpdateFrame = employeeUpdateFrame;
        this.employeeMainFrame = employeeMainFrame;
        this.nameText = nameText;
        this.ageText = ageText;
        this.addressText = addressText;
        this.phoneText = phoneText;
        this.genderComboBox = genderComboBox;
        this.uid = uid;
    }

    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if ("return".equals(actionCommand)) {
            employee = EmployeeManager.getEmployeeById(uid);
            employeeUpdateFrame.setVisible(false);
            new EmployeeInfoFrame(employee, employeeMainFrame);
        } else {
            try {
                Integer.parseInt(ageText.getText());
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "请输入有效的年龄！");
                return;
            }
            String phoneTexts = phoneText.getText() == null ? "" : phoneText.getText();
            String nameTexts = nameText.getText() == null ? "" : nameText.getText();
            Integer age = Integer.parseInt(ageText.getText());
            String address = addressText.getText() == null ? "" : addressText.getText();
            if (phoneTexts.trim().length() == 0 || nameTexts.trim().length() == 0 || age == null || address.trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "请完善信息！");
            } else if (phoneTexts.trim().length() != 11) {
                JOptionPane.showMessageDialog(null, "手机格式不正确！");
            } else {
                // TODO: 2018/12/30 update employee info by id
                employee = EmployeeManager.getEmployeeById(uid);
                employee.setName(nameText.getText().trim());
                employee.setAddress(addressText.getText().trim());
                employee.setAge(Integer.parseInt(ageText.getText().trim()));
                employee.setGender(genderComboBox.getSelectedItem().toString().trim());
                employee.setPhone(phoneText.getText().trim());
                try {
                    EmployeeManager.update(employee);
                    JOptionPane.showMessageDialog(null, "修改成功！");
                    employeeUpdateFrame.setVisible(false);
                    new EmployeeInfoFrame(employee, employeeMainFrame);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "对不起，网路繁忙，请稍后再试！");
                }
            }
        }
    }
}

