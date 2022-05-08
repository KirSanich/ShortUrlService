package com.example.shorturlservice.service;

import com.example.shorturlservice.entity.Url;

import java.util.Map;

public interface UrlService {

    void save(Url url);

    Url getFullUrlByShort(String shortUrl);

    Map<Long, Url> getAllUrlsData();

    void deleteUrl(Url url);

}
