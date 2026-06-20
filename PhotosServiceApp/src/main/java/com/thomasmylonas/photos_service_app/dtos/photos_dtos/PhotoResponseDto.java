package com.thomasmylonas.photos_service_app.dtos.photos_dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record PhotoResponseDto(
        @JsonProperty(value = "Id")
        Long id,

        @JsonProperty(value = "Album_Id")
        Long albumId,

        @JsonProperty(value = "Title")
        String title,

        @JsonProperty(value = "Url")
        String url,

        @JsonProperty(value = "Thumbnail_Url")
        String thumbnailUrl
) {
}
