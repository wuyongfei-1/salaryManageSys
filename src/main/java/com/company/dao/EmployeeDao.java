package main.java.com.company.dao;

import main.java.com.company.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * this class by created wuyongfei
 **/
public interface EmployeeDao {

    Employee getEmployeeByUserName(String userName);

    Employee getEmployeeByUserNameAndPassword(@Param("userName") String userName,@Param("password") String password);

    Integer addEmployee(Employee employee);

    List<Employee> listEmployee();

    Employee getEmployeeByUId(Integer uid);

    Integer updateEmployeeById(@Param("employee") Employee employee);
}
