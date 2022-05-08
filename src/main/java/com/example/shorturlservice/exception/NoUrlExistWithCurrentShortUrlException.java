package com.example.shorturlservice.exception;

public class NoUrlExistWithCurrentShortUrlException extends RuntimeException{
    public NoUrlExistWithCurrentShortUrlException() {
    }

    public NoUrlExistWithCurrentShortUrlException(String message) {
        super(message);
    }

    public NoUrlExistWithCurrentShortUrlException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoUrlExistWithCurrentShortUrlException(Throwable cause) {
        super(cause);
    }
}
