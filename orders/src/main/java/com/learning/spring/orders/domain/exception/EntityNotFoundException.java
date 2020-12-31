package com.learning.spring.orders.domain.exception;

import com.learning.spring.orders.domain.exception.BusinessException;

public class EntityNotFoundException extends BusinessException {

    public EntityNotFoundException(String message) {
        super(message);
    }
}
