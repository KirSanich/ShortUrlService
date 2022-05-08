package com.example.shorturlservice.validator;

import com.example.shorturlservice.entity.Url;
import com.example.shorturlservice.exception.ShortUrlTimeExpiredException;
import com.example.shorturlservice.exception.UrlAlreadyHasShortUrlException;
import com.example.shorturlservice.service.UrlService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
@Slf4j
@AllArgsConstructor
public class UrlValidatorServiceImpl implements UrlValidatorService {

    @Autowired
    private final UrlService urlService;

    @Override
    public boolean isUrlHasAlreadyShort(String url) {
        var urlFromRedis = urlService.getAllUrlsData().values().stream()
                .map(Url::getUrl)
                .filter(url1 -> url1.equals(url))
                .findAny();
        return urlFromRedis.isPresent();
    }

    @Override
    public boolean urlIsValid(String url) {
        UrlValidator urlValidator = new UrlValidator(new String[]{"http", "https"});
        if (!isUrlHasAlreadyShort(url)) {
            return urlValidator.isValid(url);
        } else throw new UrlAlreadyHasShortUrlException("Url:" + url + " has already short url");
    }
}
