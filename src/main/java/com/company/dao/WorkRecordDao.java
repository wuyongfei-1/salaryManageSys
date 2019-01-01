package main.java.com.company.dao;

import main.java.com.company.model.WorkRecord;

import java.util.List;

/**
 * this class by created wuyongfei
 **/
public interface WorkRecordDao {

    Integer addWorkRecordForEmployee(WorkRecord workRecord);

    Integer updateWorkRecordForEmployee(WorkRecord workRecord);

    WorkRecord getWorkRecordByUId(Integer uid);

    List<WorkRecord> listWorkRecords();
}
