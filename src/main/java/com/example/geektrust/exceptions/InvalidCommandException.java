package com.example.geektrust.exceptions;

public class InvalidCommandException extends RuntimeException {
    private String msg;

    public InvalidCommandException(String msg) {
        this.msg = msg;
    }

    public InvalidCommandException(String message, String msg) {
        super(message);
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
