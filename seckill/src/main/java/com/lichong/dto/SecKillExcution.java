package com.lichong.dto;

import com.lichong.entity.SuccessKilledTO;

/**
 * Created by lichongsky on 2017/2/21.
 * 秒杀执行结果DTO
 */
public class SecKillExcution {

    private long secKillId;

    private int state;

    private String stateInfo;

    private SuccessKilledTO successKilledTO;

    public SecKillExcution(long secKillId, String stateInfo, int state) {
        this.secKillId = secKillId;
        this.stateInfo = stateInfo;
        this.state = state;
    }

    public SecKillExcution(long secKillId, int state, String stateInfo, SuccessKilledTO successKilledTO) {
        this.secKillId = secKillId;
        this.state = state;
        this.stateInfo = stateInfo;
        this.successKilledTO = successKilledTO;
    }

    public long getSecKillId() {
        return secKillId;
    }

    public void setSecKillId(long secKillId) {
        this.secKillId = secKillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKilledTO getSuccessKilledTO() {
        return successKilledTO;
    }

    public void setSuccessKilledTO(SuccessKilledTO successKilledTO) {
        this.successKilledTO = successKilledTO;
    }

}
