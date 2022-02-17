package com.example.geektrust.exceptions;

public class InvalidCommandException extends RuntimeException {

    public InvalidCommandException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
