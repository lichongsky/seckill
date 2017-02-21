package com.lichong.exception;

/**
 * 秒杀异常
 * Created by lichongsky on 2017/2/21.
 */
public class SecKillException extends RuntimeException {
    public SecKillException(String message) {
        super(message);
    }

    public SecKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
