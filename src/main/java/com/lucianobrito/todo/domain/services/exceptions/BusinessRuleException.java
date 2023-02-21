package com.lucianobrito.todo.domain.services.exceptions;

import java.io.Serializable;

public class BusinessRuleException extends RuntimeException implements Serializable {

    public BusinessRuleException(String msg) {
        super(msg);
    }

}
