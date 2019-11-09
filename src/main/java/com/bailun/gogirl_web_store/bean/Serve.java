package com.bailun.gogirl_web_store.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by yinyong on 2018/8/20.
 */
public class Serve implements Serializable {

    private Integer id;
    private String name;
    private String picturePath;
    private String type;
    private String label;
    private BigDecimal price;
    private Integer shopSort;
    private String status;
    private String produces;
    private String remark;
    private String details;
    private Double serviceDuration;
    private List<Produce> listProduce;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getShopSort() {
        return shopSort;
    }

    public void setShopSort(Integer shopSort) {
        this.shopSort = shopSort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getProduces() {
        return produces;
    }

    public void setProduces(String produces) {
        this.produces = produces;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Double getServiceDuration() {
        return serviceDuration;
    }

    public void setServiceDuration(Double serviceDuration) {
        this.serviceDuration = serviceDuration;
    }

    public List<Produce> getListProduce() {
        return listProduce;
    }

    public void setListProduce(List<Produce> listProduce) {
        this.listProduce = listProduce;
    }

    @Override
    public String toString() {
        return "Serve{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picturePath='" + picturePath + '\'' +
                ", type='" + type + '\'' +
                ", label='" + label + '\'' +
                ", price=" + price +
                ", shopSort=" + shopSort +
                ", status='" + status + '\'' +
                ", produces='" + produces + '\'' +
                ", remark='" + remark + '\'' +
                ", details='" + details + '\'' +
                ", serviceDuration=" + serviceDuration +
                ", listProduce=" + listProduce +
                '}';
    }
}
