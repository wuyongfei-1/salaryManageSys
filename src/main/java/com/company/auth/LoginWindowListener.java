package main.java.com.company.auth;

import main.java.com.company.admin.mainFrame.AdminManageInfoBunchFrame;
import main.java.com.company.repository.EmployeeManager;
import main.java.com.company.employee.mainFrame.EmployeeMainFrame;
import main.java.com.company.model.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;


/**
 * this class by created wuyongfei
 **/
public class LoginWindowListener implements ActionListener {

    private JButton loginButton;
    private JButton registButton;
    private JTextField userNameText;
    private JPasswordField passwordText;
    private LoginFrame loginFrame;

    public LoginWindowListener(JTextField userNameText, JPasswordField passwordText, JButton loginButton, JButton registButton, LoginFrame loginFrame) {
        this.userNameText = userNameText;
        this.passwordText = passwordText;
        this.loginButton = loginButton;
        this.registButton = registButton;
        this.loginFrame = loginFrame;
    }

    public void actionPerformed(ActionEvent e) {
        // 获取事件源
        JButton source = (JButton) e.getSource();
        if (source == registButton) {
            new RegistFrame();
            loginFrame.setVisible(false);
        } else if (source == loginButton) {
            String userName = userNameText.getText();
            String password = passwordText.getText();
            if (userName.trim().length() == 0 || password.trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "用户名或密码不能为空！");
            } else {
                // TODO: 2019/1/1 auth account is exist by userName and password
                Optional<Employee> authEmployeeOptional;
                try {
                    authEmployeeOptional = Optional.of(EmployeeManager.auth(userName, password));
                    authEmployeeOptional.ifPresent(authEmployee -> {
                        if (authEmployee.getIdentity() == 1) {
                            JOptionPane.showMessageDialog(null, "恭喜您，登录成功！");
                          /*  Employee employee = new Employee();
                            employee.setUid(001);
                            employee.setName("张三");
                            employee.setGender("男");
                            employee.setAge(22);
                            employee.setAddress("上海市虹口区万安路1323弄15号");
                            employee.setPhone("17635696656");
                            employee.setRole("后端开发工程师");
                            employee.setSalary(new BigDecimal(10000));*/
                            new EmployeeMainFrame(authEmployee);
                            loginFrame.setVisible(false);
                            return;
                        } else if (authEmployee.getIdentity() == 0) {
                            JOptionPane.showMessageDialog(null, "尊贵的管理员，欢迎您！");
                            new AdminManageInfoBunchFrame();
                            loginFrame.setVisible(false);
                            return;
                        }
                    });
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "用户名或密码错误！");
                }
            }
        }
    }
}
