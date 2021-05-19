package com.training.trainingproject.domain.exception;

public class BussinesException extends RuntimeException {

    public static final long serialVersionUID = 1L;

    public BussinesException(String message) {
        super(message);
    }
}
