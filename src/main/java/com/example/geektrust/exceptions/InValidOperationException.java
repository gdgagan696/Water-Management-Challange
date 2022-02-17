package com.example.geektrust.exceptions;

public class InValidOperationException extends RuntimeException {

    public InValidOperationException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}