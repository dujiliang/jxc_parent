package com.jxc.common.exception;

public class CacheLockException extends Throwable{
	private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CacheLockException(String msg) {
        this.msg = msg;
    }

    public CacheLockException() {
    }

}
