package com.thomasmylonas.gallery_service_app.dtos.photos_dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record PhotoRequestDto(
        @JsonProperty(value = "album_id")
        Long albumId,

        @JsonProperty(value = "title")
        String title,

        @JsonProperty(value = "url")
        String url,

        @JsonProperty(value = "thumbnail_url")
        String thumbnailUrl
) {
}
