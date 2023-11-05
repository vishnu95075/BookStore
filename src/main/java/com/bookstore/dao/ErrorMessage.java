package com.bookstore.dao;

public class ErrorMessage {
    Integer statusCode;

    Integer time_now;

    String errorMessage;

    String message;

    public ErrorMessage(Integer statusCode, Integer time_now, String errorMessage, String message) {
        this.statusCode = statusCode;
        this.time_now = time_now;
        this.errorMessage = errorMessage;
        this.message = message;
    }
    public ErrorMessage() {
       super();
    }
    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getTime_now() {
        return time_now;
    }

    public void setTime_now(Integer time_now) {
        this.time_now = time_now;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
