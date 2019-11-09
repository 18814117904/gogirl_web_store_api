package com.bailun.gogirl_web_store.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yinyong on 2018/9/18.
 */
public class TechnicianManage implements Serializable {

    private Integer id;
    private String technicianNo;
    private String name;
    private Integer departmentId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    private String mobile;
    private String userAuthority;
    private String grade;
    private Double seniority;
    private Double informationIntegrity;
    private Integer complaintNumber;
    private String complaintReason;
    private Integer serviceNumberTotal;
    private BigDecimal serviceMoneyTotal;
    private BigDecimal applyCardMoneyTotal;
    private Double score;

    private boolean status = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTechnicianNo() {
        return technicianNo;
    }

    public void setTechnicianNo(String technicianNo) {
        this.technicianNo = technicianNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserAuthority() {
        return userAuthority;
    }

    public void setUserAuthority(String userAuthority) {
        this.userAuthority = userAuthority;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Double getSeniority() {
        return seniority;
    }

    public void setSeniority(Double seniority) {
        this.seniority = seniority;
    }

    public Double getInformationIntegrity() {
        return informationIntegrity;
    }

    public void setInformationIntegrity(Double informationIntegrity) {
        this.informationIntegrity = informationIntegrity;
    }

    public Integer getComplaintNumber() {
        return complaintNumber;
    }

    public void setComplaintNumber(Integer complaintNumber) {
        this.complaintNumber = complaintNumber;
    }

    public String getComplaintReason() {
        return complaintReason;
    }

    public void setComplaintReason(String complaintReason) {
        this.complaintReason = complaintReason;
    }

    public Integer getServiceNumberTotal() {
        return serviceNumberTotal;
    }

    public void setServiceNumberTotal(Integer serviceNumberTotal) {
        this.serviceNumberTotal = serviceNumberTotal;
    }

    public BigDecimal getServiceMoneyTotal() {
        return serviceMoneyTotal;
    }

    public void setServiceMoneyTotal(BigDecimal serviceMoneyTotal) {
        this.serviceMoneyTotal = serviceMoneyTotal;
    }

    public BigDecimal getApplyCardMoneyTotal() {
        return applyCardMoneyTotal;
    }

    public void setApplyCardMoneyTotal(BigDecimal applyCardMoneyTotal) {
        this.applyCardMoneyTotal = applyCardMoneyTotal;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TechnicianManage{" +
                "id=" + id +
                ", technicianNo='" + technicianNo + '\'' +
                ", name='" + name + '\'' +
                ", departmentId=" + departmentId +
                ", createTime=" + createTime +
                ", mobile='" + mobile + '\'' +
                ", userAuthority='" + userAuthority + '\'' +
                ", grade='" + grade + '\'' +
                ", seniority=" + seniority +
                ", informationIntegrity=" + informationIntegrity +
                ", complaintNumber=" + complaintNumber +
                ", complaintReason='" + complaintReason + '\'' +
                ", serviceNumberTotal=" + serviceNumberTotal +
                ", serviceMoneyTotal=" + serviceMoneyTotal +
                ", applyCardMoneyTotal=" + applyCardMoneyTotal +
                ", score=" + score +
                ", status=" + status +
                '}';
    }
}
