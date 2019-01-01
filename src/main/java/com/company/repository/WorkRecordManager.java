package main.java.com.company.repository;

import main.java.com.company.dao.WorkRecordDao;
import main.java.com.company.model.WorkRecord;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * this class by created wuyongfei
 **/
public class WorkRecordManager {

    public static SqlSession sqlSession;

    public static WorkRecordDao workRecordDao;

    public static void destroyConnection() {
        sqlSession.close();
    }

    public static Integer add(WorkRecord workRecord) {
        if (workRecordDao == null) {
            workRecordDao = sqlSession.getMapper(WorkRecordDao.class);
        }
        Integer id = workRecordDao.addWorkRecordForEmployee(workRecord);
        sqlSession.commit();
        return id;
    }

    public static Integer update(WorkRecord workRecord) {
        if (workRecordDao == null) {
            workRecordDao = sqlSession.getMapper(WorkRecordDao.class);
        }
        Integer resultRow = workRecordDao.updateWorkRecordForEmployee(workRecord);
        sqlSession.commit();
        return resultRow;
    }

    public static WorkRecord getWorkRecordByUId(Integer uid) {
        if (workRecordDao == null) {
            workRecordDao = sqlSession.getMapper(WorkRecordDao.class);
        }
        return workRecordDao.getWorkRecordByUId(uid);
    }

    public static List<WorkRecord> listWorkRecords() {
        if (workRecordDao == null) {
            workRecordDao = sqlSession.getMapper(WorkRecordDao.class);
        }
        return workRecordDao.listWorkRecords();
    }
}
