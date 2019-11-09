package com.bailun.gogirl_web_store.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by yinyong on 2018/9/28.
 */
public class ScheduleManage implements Serializable {

    private Integer id;
    private String scheduledNo;
    private Date scheduledTime; //下单时间
    private Date lastUpdateTime; //最近修改时间
    private Integer scheduledUser; //下单人
    private String storeScheduleUsername; //店铺端预约用户名
    private String telephone; //店铺端预约手机号码
    private String arriveTime; //预约到达时间
    private Date lastServiceTime; //上次服务时间
    private String arriveUser; //到店人
    private Integer departmentId; //下单门店
    private String remark; //备注
    private Date openbillTime; //开单时间
    private Integer status; //已预约#1  失约#2  守约#3  已取消#4
    private String createUser;  //创建人
    private Integer scheduledType;
    private List<ScheduleServe> listScheduleServer; //预约下服务列表
    private Customer customer; //预约用户信息
    private String deleteServe;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScheduledNo() {
        return scheduledNo;
    }

    public void setScheduledNo(String scheduledNo) {
        this.scheduledNo = scheduledNo;
    }

    public Date getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(Date scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getScheduledUser() {
        return scheduledUser;
    }

    public void setScheduledUser(Integer scheduledUser) {
        this.scheduledUser = scheduledUser;
    }

    public String getStoreScheduleUsername() {
        return storeScheduleUsername;
    }

    public void setStoreScheduleUsername(String storeScheduleUsername) {
        this.storeScheduleUsername = storeScheduleUsername;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Date getLastServiceTime() {
        return lastServiceTime;
    }

    public void setLastServiceTime(Date lastServiceTime) {
        this.lastServiceTime = lastServiceTime;
    }

    public String getArriveUser() {
        return arriveUser;
    }

    public void setArriveUser(String arriveUser) {
        this.arriveUser = arriveUser;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getOpenbillTime() {
        return openbillTime;
    }

    public void setOpenbillTime(Date openbillTime) {
        this.openbillTime = openbillTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<ScheduleServe> getListScheduleServer() {
        return listScheduleServer;
    }

    public void setListScheduleServer(List<ScheduleServe> listScheduleServer) {
        this.listScheduleServer = listScheduleServer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getDeleteServe() {
		return deleteServe;
	}

	public void setDeleteServe(String deleteServe) {
		this.deleteServe = deleteServe;
	}

	public Integer getScheduledType() {
		return scheduledType;
	}

	public void setScheduledType(Integer scheduledType) {
		this.scheduledType = scheduledType;
	}

	@Override
    public String toString() {
        return "ScheduleManage{" +
                "id=" + id +
                ", scheduledNo='" + scheduledNo + '\'' +
                ", scheduledTime=" + scheduledTime +
                ", lastUpdateTime=" + lastUpdateTime +
                ", scheduledUser=" + scheduledUser +
                ", storeScheduleUsername='" + storeScheduleUsername + '\'' +
                ", telephone='" + telephone + '\'' +
                ", arriveTime='" + arriveTime + '\'' +
                ", lastServiceTime=" + lastServiceTime +
                ", arriveUser='" + arriveUser + '\'' +
                ", departmentId=" + departmentId +
                ", remark='" + remark + '\'' +
                ", openbillTime=" + openbillTime +
                ", status=" + status +
                ", createUser='" + createUser + '\'' +
                ", listScheduleServer=" + listScheduleServer +
                ", customer=" + customer +
                '}';
    }
}
