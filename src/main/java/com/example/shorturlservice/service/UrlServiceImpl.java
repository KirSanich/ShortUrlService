package com.example.shorturlservice.service;

import com.example.shorturlservice.entity.Url;
import com.example.shorturlservice.exception.NoUrlExistWithCurrentShortUrlException;
import com.example.shorturlservice.redis.RedisConfiguration;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {

    private static final String HASH_KEY = "URL";

    private HashOperations<String, Long, Url> hashOperations;

    @Autowired
    private RedisConfiguration redisConfiguration;

    @PostConstruct
    private void initializeHashOperations() {
        hashOperations = redisConfiguration.redisTemplate().opsForHash();
    }

    @Override
    public void save(Url url) {
        log.info("Saving url" + url.toString());
        hashOperations.putIfAbsent(HASH_KEY, url.getId(), url);
    }

    @Override
    public Url getFullUrlByShort(String shortUrl) {
        log.info("Get url by shortUrl");
        return getAllUrlsData().values().stream()
                .filter(url -> url.getShortUrl().equals(shortUrl))
                .findAny()
                .orElseThrow(NoUrlExistWithCurrentShortUrlException::new);
    }

    @Override
    public Map<Long, Url> getAllUrlsData() {
        log.info("Getting all urls");
        return hashOperations.entries(HASH_KEY);
    }

    @Override
    public void deleteUrl(Url url) {
        log.info("Trying delete url");
        hashOperations.delete("URL", url.getId());
    }
}
