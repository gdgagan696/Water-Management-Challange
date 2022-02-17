package com.example.geektrust.exceptions;

public class InValidOperationException extends RuntimeException {
    private String msg;

    public InValidOperationException(String msg) {
        this.msg = msg;
    }

    public InValidOperationException(String message, String msg) {
        super(message);
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}