package com.example.shorturlservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dto for Request")
public record UrlDTORequest(@Schema(description = "full url") String url) {
}
