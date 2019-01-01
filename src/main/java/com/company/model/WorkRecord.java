package main.java.com.company.model;

import java.math.BigDecimal;

/**
 * this class by created wuyongfei
 **/
public class WorkRecord {

    private Integer id;

    private Integer uid;

    private String name;

    private BigDecimal basicSalaryText;

    private Integer overTimeNumText;

    private BigDecimal overTimeSalaryText = new BigDecimal(50);

    private Integer beLateNumText;

    private BigDecimal beLateSalaryText = new BigDecimal(50);

    private Integer earlyNumText;

    private BigDecimal earlySalaryText = new BigDecimal(100);

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBasicSalaryText() {
        return basicSalaryText;
    }

    public void setBasicSalaryText(BigDecimal basicSalaryText) {
        this.basicSalaryText = basicSalaryText;
    }

    public Integer getOverTimeNumText() {
        return overTimeNumText;
    }

    public void setOverTimeNumText(Integer overTimeNumText) {
        this.overTimeNumText = overTimeNumText;
    }

    public BigDecimal getOverTimeSalaryText() {
        return overTimeSalaryText;
    }

    public void setOverTimeSalaryText(BigDecimal overTimeSalaryText) {
        this.overTimeSalaryText = overTimeSalaryText;
    }

    public Integer getBeLateNumText() {
        return beLateNumText;
    }

    public void setBeLateNumText(Integer beLateNumText) {
        this.beLateNumText = beLateNumText;
    }

    public BigDecimal getBeLateSalaryText() {
        return beLateSalaryText;
    }

    public void setBeLateSalaryText(BigDecimal beLateSalaryText) {
        this.beLateSalaryText = beLateSalaryText;
    }

    public Integer getEarlyNumText() {
        return earlyNumText;
    }

    public void setEarlyNumText(Integer earlyNumText) {
        this.earlyNumText = earlyNumText;
    }

    public BigDecimal getEarlySalaryText() {
        return earlySalaryText;
    }

    public void setEarlySalaryText(BigDecimal earlySalaryText) {
        this.earlySalaryText = earlySalaryText;
    }

}
