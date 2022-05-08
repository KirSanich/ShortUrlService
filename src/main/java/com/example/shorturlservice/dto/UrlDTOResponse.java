package com.example.shorturlservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Dto for response")
public record UrlDTOResponse(@Schema(description = "short url") String shortUrl,
                             @Schema(description = "expiration time") LocalDateTime expirationDate) {
}
