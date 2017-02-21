package com.lichong.entity;

import java.util.Date;

/**
 * Created by Administrator on 2017/2/20.
 */
public class SuccessKilledTO {

    private long seckillId;

    private long userPhone;

    private short state;

    private Date createTime;

    private SecKillTO secKillTO;

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
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

    public SecKillTO getSecKillTO() {
        return secKillTO;
    }

    public void setSecKillTO(SecKillTO secKillTO) {
        this.secKillTO = secKillTO;
    }

    @Override
    public String toString() {
        return "SuccessKilledTO{" +
                "seckillId=" + seckillId +
                ", userPhone=" + userPhone +
                ", state=" + state +
                ", createTime=" + createTime +
                ", secKillTO=" + secKillTO +
                '}';
    }
}
