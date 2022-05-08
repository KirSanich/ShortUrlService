package com.example.shorturlservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class UrlControllerAdvice {

    @ExceptionHandler(UrlAlreadyHasShortUrlException.class)
    public ResponseEntity<?> handleItemNotFoundException(UrlAlreadyHasShortUrlException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
