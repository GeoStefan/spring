package com.database.exception;

import java.util.Date;

public class ApiErrorResponse {
    private String error;
    private int errorCode;
    private Date timestamp;
    private String message;
    private String path;

    static final class ApiErrorResponseBuilder {
        private String error;
        private int errorCode;
        private Date timestamp;
        private String message;
        private String path;

        private ApiErrorResponseBuilder() {
        }

        static ApiErrorResponseBuilder getInstance() {
            return new ApiErrorResponseBuilder();
        }

        ApiErrorResponseBuilder withError(String error) {
            this.error = error;
            return this;
        }

        ApiErrorResponseBuilder withErrorCode(int errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        ApiErrorResponseBuilder withTimestamp(Date timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        ApiErrorResponseBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        ApiErrorResponseBuilder withPath(String path) {
            this.path = path;
            return this;
        }

        ApiErrorResponse build() {
            ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
            apiErrorResponse.error = this.error;
            apiErrorResponse.errorCode = this.errorCode;
            apiErrorResponse.timestamp = this.timestamp;
            apiErrorResponse.message = this.message;
            apiErrorResponse.path = this.path;
            return apiErrorResponse;
        }
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
