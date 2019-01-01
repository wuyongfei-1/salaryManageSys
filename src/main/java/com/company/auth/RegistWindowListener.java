package main.java.com.company.auth;

import main.java.com.company.model.WorkRecord;
import main.java.com.company.repository.EmployeeManager;
import main.java.com.company.model.Employee;
import main.java.com.company.repository.WorkRecordManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class by created wuyongfei
 **/
public class RegistWindowListener implements ActionListener {

    private JButton loginButton;
    private JButton cancelButton;
    private JTextField userNameText, nameText, phoneText, ageText, addressText;
    private JPasswordField passwordText;
    private JPasswordField againPasswordText;
    private JComboBox positionText, genderText;
    private RegistFrame registFrame;

    public RegistWindowListener(JComboBox genderText, JTextField ageText, JTextField addressText, JTextField userNameText, JPasswordField passwordText, JPasswordField againPasswordText,
                                JComboBox positionText, JTextField nameText, JTextField phoneText, JButton loginButton,
                                JButton cancelButton, RegistFrame registFrame) {
        this.userNameText = userNameText;
        this.passwordText = passwordText;
        this.loginButton = loginButton;
        this.cancelButton = cancelButton;
        this.againPasswordText = againPasswordText;
        this.positionText = positionText;
        this.nameText = nameText;
        this.phoneText = phoneText;
        this.registFrame = registFrame;
        this.genderText = genderText;
        this.ageText = ageText;
        this.addressText = addressText;
    }

    public void actionPerformed(ActionEvent e) {
        // 获取事件源
        JButton source = (JButton) e.getSource();
        if (source == cancelButton) {
            new LoginFrame();
            registFrame.setVisible(false);
        } else if (source == loginButton) {
            String userName = userNameText.getText();
            String password = passwordText.getText();
            String againPassword = againPasswordText.getText();
            String phoneTexts = phoneText.getText();
            String nameTexts = nameText.getText();
            String gender = genderText.getSelectedItem().toString();
            Integer age = Integer.parseInt(ageText.getText());
            String address = addressText.getText();
            String positionTexts = positionText.getSelectedItem().toString(); // position info
            if (userName.trim().length() == 0 || password.trim().length() == 0 || againPassword.trim().length() == 0
                    || phoneTexts.trim().length() == 0 || nameTexts.trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "请完善信息！");
            } else if (phoneTexts.trim().length() != 11) {
                JOptionPane.showMessageDialog(null, "手机格式不正确！");
            } else if (!(password.trim() == null ? "" : password.trim()).equals(againPassword.trim())) {
                JOptionPane.showMessageDialog(null, "两次输入密码不一致！");
            } else {
                // TODO: 2019/1/1 check userName is unique
                Employee employee = EmployeeManager.checkUserNameIsUnique(userName.trim());
                if (employee != null) {
                    JOptionPane.showMessageDialog(null, "对不起，该账户已存在！");
                } else {
                    // TODO: 2018/12/30 add employee to db
                    Employee employee1 = new Employee();
                    employee1.setName(nameTexts.trim());
                    employee1.setRole(positionTexts);
                    employee1.setPhone(phoneTexts);
                    employee1.setUserName(userName);
                    employee1.setPassword(password);
                    employee1.setAge(age);
                    employee1.setGender(gender);
                    employee1.setAddress(address);
                    employee1.setSalaryGeneralId(positionText.getSelectedIndex() + 1);
                    // TODO: 2019/1/1 add work_record to db
                    WorkRecord workRecord = new WorkRecord();
                    workRecord.setBeLateNumText(0);
                    workRecord.setEarlyNumText(0);
                    workRecord.setOverTimeNumText(0);
                    try {
                        EmployeeManager.add(employee1);
                        workRecord.setUid(employee1.getUid());
                        WorkRecordManager.add(workRecord);
                        JOptionPane.showMessageDialog(null, "恭喜，注册成功！");
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, "对不起，网络繁重，请稍后再试！");
                    }
                    new LoginFrame();
                    registFrame.setVisible(false);
                }
            }
        }
    }
}

