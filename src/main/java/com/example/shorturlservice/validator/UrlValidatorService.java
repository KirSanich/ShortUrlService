package com.example.shorturlservice.validator;

public interface UrlValidatorService {

    boolean urlIsValid(String url);

    boolean isUrlHasAlreadyShort(String url);

}
