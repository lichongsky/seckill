package com.lichong.entity;

import java.util.Date;

/**
 * Created by Administrator on 2017/2/20.
 */
public class SuccessKilledTO {

    private long successKilledId;

    private long userPhone;

    private short state;

    private Date createTime;

    private SecondKillTO secondKillTO;

    public long getSuccessKilledId() {
        return successKilledId;
    }

    public void setSuccessKilledId(long successKilledId) {
        this.successKilledId = successKilledId;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public SecondKillTO getSecondKillTO() {
        return secondKillTO;
    }

    public void setSecondKillTO(SecondKillTO secondKillTO) {
        this.secondKillTO = secondKillTO;
    }

    @Override
    public String toString() {
        return "SuccessKilledTO{" +
                "successKilledId=" + successKilledId +
                ", userPhone=" + userPhone +
                ", state=" + state +
                ", createTime=" + createTime +
                ", secondKillTO=" + secondKillTO +
                '}';
    }
}
