package com.lichong.exception;

/**
 * Created by lichongsky on 2017/2/21.
 * 秒杀结束异常
 */
public class SecKillCloseExcption extends SecKillException {
    public SecKillCloseExcption(String message) {
        super(message);
    }

    public SecKillCloseExcption(String message, Throwable cause) {
        super(message, cause);
    }
}
