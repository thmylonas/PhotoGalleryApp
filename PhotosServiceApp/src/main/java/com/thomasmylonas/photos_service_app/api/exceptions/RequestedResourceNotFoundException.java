package com.thomasmylonas.photos_service_app.api.exceptions;

public class RequestedResourceNotFoundException extends RuntimeException {

    public RequestedResourceNotFoundException(String message) {
        super(message);
    }
}
