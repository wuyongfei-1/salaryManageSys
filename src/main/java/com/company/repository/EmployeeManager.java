package main.java.com.company.repository;

import main.java.com.company.dao.EmployeeDao;
import main.java.com.company.model.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

/**
 * this class by created wuyongfei
 **/
public class EmployeeManager {

    private static SqlSession sqlSession;

    private static EmployeeDao employeeMapper;

    public static void initialConnection() {
        try {
            if (sqlSession != null) {
                sqlSession.close();
            }
            String resource = "main/resources/mybatis-config.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = ssf.openSession();
            WorkRecordManager.sqlSession = ssf.openSession();
            employeeMapper = sqlSession.getMapper(EmployeeDao.class);
            System.out.println("db connection success!");
        } catch (Exception e) {
            System.out.println("数据库连接失败，请联系管理员！");
        }
    }

    public static void destroyConnection() {
        sqlSession.close();
    }

    public static Employee checkUserNameIsUnique(String userName) {
        return employeeMapper.getEmployeeByUserName(userName);
    }

    public static Employee auth(String userName, String password) {
        return employeeMapper.getEmployeeByUserNameAndPassword(userName, password);
    }

    public static Integer add(Employee employee) {
        Integer uid = employeeMapper.addEmployee(employee);
        sqlSession.commit();
        return uid;
    }

    public static Integer update(Employee employee) {
        Integer resultRow = employeeMapper.updateEmployeeById(employee);
        sqlSession.commit();
        return resultRow;
    }

    public static List<Employee> listEmployees() {
        return employeeMapper.listEmployee();
    }

    public static Employee getEmployeeById(Integer id) {
        return employeeMapper.getEmployeeByUId(id);
    }
}
