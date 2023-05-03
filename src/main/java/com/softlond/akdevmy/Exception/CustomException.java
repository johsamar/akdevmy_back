package com.softlond.akdevmy.Exception;

public class CustomException extends Exception{
    private int statusCode;

    public CustomException(String message, Throwable cause, int statusCode) {
        super(message, cause);
        this.statusCode = statusCode;
    }

    public CustomException(String message, Throwable cause) {
        this(message, cause, 400);
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
