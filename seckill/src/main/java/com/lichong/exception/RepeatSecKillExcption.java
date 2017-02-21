package com.lichong.exception;

/**
 * Created by lichongsky on 2017/2/21.
 * 重复秒杀异常
 */
public class RepeatSecKillExcption extends SecKillException{

    public RepeatSecKillExcption(String message) {
        super(message);
    }

    public RepeatSecKillExcption(String message, Throwable cause) {
        super(message, cause);
    }
}
