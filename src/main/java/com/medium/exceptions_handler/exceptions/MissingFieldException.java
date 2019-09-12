package com.medium.exceptions_handler.exceptions;

import com.medium.exceptions_handler.enums.InternalErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class MissingFieldException extends GenericException {

    public MissingFieldException(String message, InternalErrorCode code) {
        super(message, code);
    }

}
