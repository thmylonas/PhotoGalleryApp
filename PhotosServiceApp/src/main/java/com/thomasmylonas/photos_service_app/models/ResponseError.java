package com.thomasmylonas.photos_service_app.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public record ResponseError(

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonProperty(value = "timestamp")
        LocalDateTime timestamp,

        @JsonProperty(value = "status_code")
        int statusCode,

        @JsonProperty(value = "message")
        String message,

        @JsonProperty(value = "path")
        String path,

        @JsonProperty(value = "stacktrace")
        String stacktrace
) {
}
