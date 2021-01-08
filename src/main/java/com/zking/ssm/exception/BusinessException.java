package com.zking.ssm.exception;

public class BusinessException extends RuntimeException{

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }
}
