package com.bailun.gogirl_web_store.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yinyong on 2018/9/21.
 */
public class OrderServe implements Serializable {

    private Integer id;
    private Integer orderId;
    private String technicianId;
    private Integer serveId;
    private String produceName;
    private BigDecimal servePrice;
    private BigDecimal serveChangePrice;
    private Integer serveNumber;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
    private Date startTime;
    @JsonFormat (pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date startDate;
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
    private Date endTime;
    private Integer executionStatus;
    private Integer updateType = 0;

    private String serveType;  // 服务分类
    private String serveName;  // 服务名称

    private Serve serve;

    private TechnicianManage technicianManage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(String technicianId) {
        this.technicianId = technicianId;
    }

    public Integer getServeId() {
        return serveId;
    }

    public void setServeId(Integer serveId) {
        this.serveId = serveId;
    }

    public String getProduceName() {
        return produceName;
    }

    public void setProduceName(String produceName) {
        this.produceName = produceName;
    }

    public BigDecimal getServePrice() {
        return servePrice;
    }

    public void setServePrice(BigDecimal servePrice) {
        this.servePrice = servePrice;
    }

    public BigDecimal getServeChangePrice() {
        return serveChangePrice;
    }

    public void setServeChangePrice(BigDecimal serveChangePrice) {
        this.serveChangePrice = serveChangePrice;
    }

    public Integer getServeNumber() {
        return serveNumber;
    }

    public void setServeNumber(Integer serveNumber) {
        this.serveNumber = serveNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getServeType() {
        return serveType;
    }

    public void setServeType(String serveType) {
        this.serveType = serveType;
    }

    public String getServeName() {
        return serveName;
    }

    public void setServeName(String serveName) {
        this.serveName = serveName;
    }

    public Serve getServe() {
        return serve;
    }

    public void setServe(Serve serve) {
        this.serve = serve;
    }

    public TechnicianManage getTechnicianManage() {
        return technicianManage;
    }

    public void setTechnicianManage(TechnicianManage technicianManage) {
        this.technicianManage = technicianManage;
    }

    public Integer getUpdateType() {
        return updateType;
    }

    public void setUpdateType(Integer updateType) {
        this.updateType = updateType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(Integer executionStatus) {
        this.executionStatus = executionStatus;
    }

    @Override
    public String toString() {
        return "OrderServe{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", technicianId='" + technicianId + '\'' +
                ", serveId=" + serveId +
                ", produceName='" + produceName + '\'' +
                ", servePrice=" + servePrice +
                ", serveChangePrice=" + serveChangePrice +
                ", serveNumber=" + serveNumber +
                ", createTime=" + createTime +
                ", startTime=" + startTime +
                ", startDate=" + startDate +
                ", endTime=" + endTime +
                ", executionStatus=" + executionStatus +
                ", updateType=" + updateType +
                ", serveType='" + serveType + '\'' +
                ", serveName='" + serveName + '\'' +
                ", serve=" + serve +
                ", technicianManage=" + technicianManage +
                '}';
    }
}
