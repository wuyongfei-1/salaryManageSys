package main.java.com.company.admin.mainFrame;

import main.java.com.company.admin.SalaryBunchFrame.AdminManageSalaryBunchFrame;
import main.java.com.company.auth.LoginFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class by created wuyongfei
 **/
public class AdminManageInfoBunchWindowListener implements ActionListener {

    private AdminManageInfoBunchFrame adminManageInfoBunchFrame;

    public AdminManageInfoBunchWindowListener(AdminManageInfoBunchFrame adminManageInfoBunchFrame) {
        this.adminManageInfoBunchFrame = adminManageInfoBunchFrame;
    }

    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        adminManageInfoBunchFrame.setVisible(false);
        if ("exit".equals(actionCommand)) {
            JOptionPane.showMessageDialog(null, "安全退出成功！");
            new LoginFrame();
        } else {
            new AdminManageSalaryBunchFrame();
        }
    }
}

