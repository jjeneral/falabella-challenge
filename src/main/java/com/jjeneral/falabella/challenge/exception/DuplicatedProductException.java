package com.jjeneral.falabella.challenge.exception;

public class DuplicatedProductException extends RuntimeException {
    public DuplicatedProductException(String message) {
        super(message);
    }

    public DuplicatedProductException(String message, Throwable cause) {
        super(message, cause);
    }
}
