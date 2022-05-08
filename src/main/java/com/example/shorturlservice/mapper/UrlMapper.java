package com.example.shorturlservice.mapper;

import com.example.shorturlservice.dto.UrlDTORequest;
import com.example.shorturlservice.dto.UrlDTOResponse;
import com.example.shorturlservice.entity.Url;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class UrlMapper {

    @Autowired
    private ModelMapper urlMapper;

    public Url fromDTORequestToUrl(UrlDTORequest urlDTORequest, String shortUrl) {
        return Url.builder()
                .id(ThreadLocalRandom.current().nextLong())
                .url(urlDTORequest.url())
                .shortUrl(shortUrl)
                .creationDate(LocalDateTime.now())
                .expirationDate(LocalDateTime.now().plusMinutes(10))
                .build();
    }

    public UrlDTOResponse fromUrlToUrlDTOResponse(Url url) {
        return new UrlDTOResponse(url.getUrl(), url.getExpirationDate());
    }
}
