package com.example.shorturlservice.exception;

public class UrlAlreadyHasShortUrlException extends RuntimeException{
    public UrlAlreadyHasShortUrlException() {
    }

    public UrlAlreadyHasShortUrlException(String message) {
        super(message);
    }

    public UrlAlreadyHasShortUrlException(String message, Throwable cause) {
        super(message, cause);
    }

    public UrlAlreadyHasShortUrlException(Throwable cause) {
        super(cause);
    }
}
