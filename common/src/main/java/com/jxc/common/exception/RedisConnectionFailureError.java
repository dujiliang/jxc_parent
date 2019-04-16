package com.jxc.common.exception;

public class RedisConnectionFailureError extends Exception{

    public RedisConnectionFailureError() {
        super();
    }

    public RedisConnectionFailureError(String message) {
        super(message);
    }

}
