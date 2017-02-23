package com.lichong.dto;

import com.lichong.entity.SuccessKilledTO;
import com.lichong.enums.SeckillstateEnum;

/**
 * Created by lichongsky on 2017/2/21.
 * 秒杀执行结果DTO
 */
public class SecKillExcution {

    private long secKillId;

    private int state;

    private SeckillstateEnum seckillstateEnum;

    private String stateInfo;

    private SuccessKilledTO successKilledTO;

    public SecKillExcution(long secKillId, SeckillstateEnum seckillstateEnum) {
        this.secKillId = secKillId;
        this.stateInfo = seckillstateEnum.getStateInfo();
        this.state = seckillstateEnum.getState();
    }

    public SecKillExcution(long secKillId, SeckillstateEnum seckillstateEnum, SuccessKilledTO successKilledTO) {
        this.secKillId = secKillId;
        this.state = seckillstateEnum.getState();
        this.stateInfo = seckillstateEnum.getStateInfo();
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
