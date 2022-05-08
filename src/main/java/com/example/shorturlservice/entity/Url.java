package com.example.shorturlservice.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDateTime;

@RedisHash(value = "URL")
@Data
@Builder
public class Url implements Serializable {

    @Id
    private Long id;

    private String url;

    private String shortUrl;

    private LocalDateTime creationDate;

    private LocalDateTime expirationDate;

}
