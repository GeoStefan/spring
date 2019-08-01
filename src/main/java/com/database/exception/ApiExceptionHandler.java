package com.database.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ApiExceptionHandler {
    private static final Logger LOGGER = LogManager.getLogger();

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<Object> handleDatabaseException(Exception e, WebRequest request) {
        return handleException(e, request, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Object> handleException(Exception e, WebRequest request, HttpStatus httpStatus) {
        LOGGER.info("Caught {} while processing request [message={}]", e.getClass().getSimpleName(), e.getMessage());
        ApiErrorResponse response = ApiErrorResponse.ApiErrorResponseBuilder.getInstance()
                .withTimestamp(new Date())
                .withError(httpStatus.toString())
                .withErrorCode(httpStatus.value())
                .withMessage(e.getMessage())
                .withPath(getPath(request))
                .build();
        return new ResponseEntity<>(response, httpStatus);

    }

    private String getPath(WebRequest request) {
        return ((ServletWebRequest) request).getRequest().getRequestURI().substring(request.getContextPath().length());
    }
}
