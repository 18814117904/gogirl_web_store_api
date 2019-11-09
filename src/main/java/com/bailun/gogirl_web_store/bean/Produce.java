package com.bailun.gogirl_web_store.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by yinyong on 2018/8/20.
 */
public class Produce implements Serializable {

    private Integer id;
    private String name;
    private String picturePath;
    private String type;
    private String label;
    private Integer shopSort;
    private String reqGrade;
    private String remark;
    private String status;
    private String details;

    private Integer serveId;
    private String serveName;
    private BigDecimal price;
    private Integer serviceDuration;
    private Integer sortOrder;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getShopSort() {
        return shopSort;
    }

    public void setShopSort(Integer shopSort) {
        this.shopSort = shopSort;
    }

    public Integer getServeId() {
        return serveId;
    }

    public void setServeId(Integer serveId) {
        this.serveId = serveId;
    }

    public String getReqGrade() {
        return reqGrade;
    }

    public String getServeName() {
        return serveName;
    }

    public void setServeName(String serveName) {
        this.serveName = serveName;
    }

    public void setReqGrade(String reqGrade) {
        this.reqGrade = reqGrade;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getServiceDuration() {
        return serviceDuration;
    }

    public void setServiceDuration(Integer serviceDuration) {
        this.serviceDuration = serviceDuration;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public String toString() {
        return "Produce{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picturePath='" + picturePath + '\'' +
                ", type='" + type + '\'' +
                ", label='" + label + '\'' +
                ", shopSort=" + shopSort +
                ", reqGrade='" + reqGrade + '\'' +
                ", remark='" + remark + '\'' +
                ", status='" + status + '\'' +
                ", details='" + details + '\'' +
                ", serveId=" + serveId +
                ", serveName='" + serveName + '\'' +
                ", price=" + price +
                ", serviceDuration=" + serviceDuration +
                ", sortOrder=" + sortOrder +
                '}';
    }
}
