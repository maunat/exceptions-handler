package com.medium.exceptions_handler.handler;

import com.medium.exceptions_handler.exceptions.ForbiddenOperationException;
import com.medium.exceptions_handler.exceptions.GenericException;
import com.medium.exceptions_handler.exceptions.MissingFieldException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import org.springframework.http.HttpHeaders;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = MissingFieldException.class)
    public ResponseEntity handleMissingFieldsException(MissingFieldException e, WebRequest wr) {
        return handleExceptionInternal(e, null, httpHeaders(e), HttpStatus.BAD_REQUEST, wr);
    }

    @ExceptionHandler(value = ForbiddenOperationException.class)
    public ResponseEntity handleForbiddenOperationException(ForbiddenOperationException e, WebRequest wr) {
        return handleExceptionInternal(e, null, httpHeaders(e), HttpStatus.FORBIDDEN, wr);
    }

    private static HttpHeaders httpHeaders(GenericException genericException) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("MSG", genericException.getMessage());
        httpHeaders.add("INTERNAL_CODE", genericException.getCode().name());
        return httpHeaders;
    }

}
