package com.example.shorturlservice.exception;

public class ShortUrlCreationException extends RuntimeException {
    public ShortUrlCreationException() {
    }

    public ShortUrlCreationException(String message) {
        super(message);
    }

    public ShortUrlCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShortUrlCreationException(Throwable cause) {
        super(cause);
    }
}
