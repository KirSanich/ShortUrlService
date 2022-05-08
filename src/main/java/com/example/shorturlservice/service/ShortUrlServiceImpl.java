package com.example.shorturlservice.service;

import com.example.shorturlservice.entity.Url;
import com.example.shorturlservice.exception.ShortUrlCreationException;
import com.example.shorturlservice.validator.UrlValidatorService;
import com.google.common.hash.Hashing;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@Slf4j
@AllArgsConstructor
public class ShortUrlServiceImpl implements ShortUrlService {

    @Autowired
    private UrlValidatorService urlValidatorService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String createShortUrl(String url) {

        if (urlValidatorService.urlIsValid(url)) {
            String id = Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
            log.info("Creating URL ID:" + id);
            stringRedisTemplate.opsForValue().set(id, url);
            return id;
        } else throw new ShortUrlCreationException("Exception when trying create short url id:");

    }


}
