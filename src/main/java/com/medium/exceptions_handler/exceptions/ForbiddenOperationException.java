package com.medium.exceptions_handler.exceptions;

import com.medium.exceptions_handler.enums.InternalErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class ForbiddenOperationException extends GenericException {

    public ForbiddenOperationException(String message, InternalErrorCode code) {
        super(message, code);
    }

}
