package com.lichong.enums;

/**
 * Created by lichongsky on 2017/2/24 0024.
 */
public enum SeckillstateEnum {
    SUCCESS(1, "秒杀成功"),
    END(0, "秒杀结束"),
    REPEATKILL(-1, "重复秒杀"),
    INNER_ERROR(-2, "系统异常"),
    DATA_REWRITE(-3, "数据篡改");

    private int    state;
    private String stateInfo;

    SeckillstateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
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

    public static SeckillstateEnum stateOf(int index) {
        for (SeckillstateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
