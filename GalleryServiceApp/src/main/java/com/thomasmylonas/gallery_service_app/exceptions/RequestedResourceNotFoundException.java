package com.thomasmylonas.gallery_service_app.exceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RequestedResourceNotFoundException extends RuntimeException {

    public RequestedResourceNotFoundException(Long resourceId, String clazz) {
        super(String.format("%s: The %s with ID %d not found!",
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss").format(LocalDateTime.now()),
                clazz, resourceId));
    }
}
