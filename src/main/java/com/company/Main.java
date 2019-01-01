package main.java.com.company;

import main.java.com.company.auth.LoginFrame;
import main.java.com.company.repository.EmployeeManager;

public class Main {
    public static void main(String[] args) {
        EmployeeManager.initialConnection();
        new LoginFrame();
    }
}

