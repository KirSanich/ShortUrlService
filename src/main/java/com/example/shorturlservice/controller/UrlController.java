package com.example.shorturlservice.controller;

import com.example.shorturlservice.dto.UrlDTORequest;
import com.example.shorturlservice.dto.UrlDTOResponse;
import com.example.shorturlservice.entity.Url;
import com.example.shorturlservice.mapper.UrlMapper;
import com.example.shorturlservice.service.ShortUrlService;
import com.example.shorturlservice.service.UrlService;
import com.example.shorturlservice.validator.UrlValidatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Tag(name = "url-shortener",description = "main controller for url requests")
public class UrlController {

    @Autowired
    private ShortUrlService shortUrlService;

    @Autowired
    private UrlService urlService;

    @Autowired
    private UrlMapper urlMapper;

    @Operation(summary = "get short url by full")
    @PostMapping("/short")
    public ResponseEntity<String> getShortUrl(@RequestBody UrlDTORequest urlDTORequest) {
        String shortUrl = shortUrlService.createShortUrl(urlDTORequest.url());
        Url url = urlMapper.fromDTORequestToUrl(urlDTORequest, shortUrl);
        urlService.save(url);
        return new ResponseEntity<>(shortUrl, HttpStatus.OK);
    }

    @Operation(summary = "get full url by id short")
    @GetMapping("/short/{id}")
    public ResponseEntity<UrlDTOResponse> getFullUrlByShort(@PathVariable("id") String shortUrl) {
        Url url = urlService.getFullUrlByShort(shortUrl);
        UrlDTOResponse urlDTOResponse = urlMapper.fromUrlToUrlDTOResponse(url);
        return new ResponseEntity<>(urlDTOResponse, HttpStatus.OK);
    }

    @Operation(summary = "do request with short-full url")
    @SneakyThrows
    @GetMapping("/pass/{id}")
    public void getFullUrlByShort(@PathVariable("id") String shortUrl, HttpServletResponse httpServletResponse) {
        Url url = urlService.getFullUrlByShort(shortUrl);
        UrlDTOResponse urlDTOResponse = urlMapper.fromUrlToUrlDTOResponse(url);
        httpServletResponse.sendRedirect(urlDTOResponse.shortUrl());
    }

}
