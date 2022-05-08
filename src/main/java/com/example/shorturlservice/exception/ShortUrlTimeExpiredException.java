package com.example.shorturlservice.exception;

public class ShortUrlTimeExpiredException extends RuntimeException{
    public ShortUrlTimeExpiredException() {
    }

    public ShortUrlTimeExpiredException(String message) {
        super(message);
    }

    public ShortUrlTimeExpiredException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShortUrlTimeExpiredException(Throwable cause) {
        super(cause);
    }
}
