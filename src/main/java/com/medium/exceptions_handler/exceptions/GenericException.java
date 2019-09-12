package com.medium.exceptions_handler.exceptions;

import com.medium.exceptions_handler.enums.InternalErrorCode;

public abstract class GenericException extends RuntimeException {

    private final InternalErrorCode code;

    public GenericException(String message, InternalErrorCode code) {
        super(message);
        this.code = code;
    }

    public InternalErrorCode getCode() {
        return code;
    }
}
