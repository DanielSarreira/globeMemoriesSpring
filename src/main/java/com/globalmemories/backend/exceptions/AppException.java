package com.globalmemories.backend.exceptions;

import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException {

    private final HttpStatus status;
    private final Exception exception;

    public AppException(String message, HttpStatus status, Exception exception) {
        super(message);
        this.status = status;
        this.exception = exception;
    }

    public AppException(String message, HttpStatus status) {
        super(message);
        this.status = status;
        this.exception = null;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Exception getException() {
        return exception;
    }
}
