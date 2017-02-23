package com.lichong.dto;

/**
 * Created by lichongsky on 2017/2/23 0023.
 */
public class SecKillRusltTO<T> {
    private boolean success;

    private String error;

    private T data;

    public SecKillRusltTO(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public SecKillRusltTO(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
