package com.lucianobrito.todo.domain.services.exceptions;

import java.io.Serializable;

public class ResourceNotFoundException extends RuntimeException implements Serializable {

    public ResourceNotFoundException(String msg) {
        super(msg);
    }

}
