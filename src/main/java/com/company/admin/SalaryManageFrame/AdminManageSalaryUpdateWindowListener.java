package main.java.com.company.admin.SalaryManageFrame;

import main.java.com.company.admin.SalaryBunchFrame.AdminManageSalaryBunchFrame;
import main.java.com.company.model.WorkRecord;
import main.java.com.company.repository.WorkRecordManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class by created wuyongfei
 **/
public class AdminManageSalaryUpdateWindowListener implements ActionListener {

    private AdminManageSalaryUpdateFrame adminManageSalaryFrame;

    private JTextField overTimeNumText;

    private JTextField beLateNumText;

    private JTextField earlyNumText;

    private Integer uid;

    public AdminManageSalaryUpdateWindowListener(AdminManageSalaryUpdateFrame adminManageSalaryFrame, Integer uid,
                                                 JTextField overTimeNumText, JTextField beLateNumText,JTextField earlyNumText) {
        this.adminManageSalaryFrame = adminManageSalaryFrame;
        this.uid = uid;
        this.overTimeNumText = overTimeNumText;
        this.beLateNumText = beLateNumText;
        this.earlyNumText = earlyNumText;
    }

    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if ("return".equals(actionCommand)) {
            adminManageSalaryFrame.setVisible(false);
            new AdminManageSalaryBunchFrame();
        } else {
            try {
                Integer.parseInt(overTimeNumText.getText());
                Integer.parseInt(beLateNumText.getText());
                Integer.parseInt(earlyNumText.getText());
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "请输入正确的序号！");
                return;
            }
            // get dest salary data
            Integer overTimeNum = Integer.parseInt(overTimeNumText.getText());
            Integer beLateNum = Integer.parseInt(beLateNumText.getText());
            Integer earlyNum = Integer.parseInt(earlyNumText.getText());
            // TODO: 2018/12/31 update current employee salary data by uid
            try {
                WorkRecord workRecord = WorkRecordManager.getWorkRecordByUId(uid);
                workRecord.setOverTimeNumText(overTimeNum);
                workRecord.setEarlyNumText(earlyNum);
                workRecord.setBeLateNumText(beLateNum);
                WorkRecordManager.update(workRecord);
                JOptionPane.showMessageDialog(null, "修改成功！");
                adminManageSalaryFrame.setVisible(false);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "对不起，网络繁忙，请稍后再试！");
            }
            new AdminManageSalaryBunchFrame();
        }
    }
}
