package com.training.trainingproject.domain.exception;

public class BusinessException extends RuntimeException {

    public static final long serialVersionUID = 1L;

    public BusinessException(String message) {
        super(message);
    }
}
