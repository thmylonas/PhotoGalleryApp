package com.thomasmylonas.todo_service_app.exceptions;

public class RequestedResourceNotFoundException extends RuntimeException {

    public RequestedResourceNotFoundException(String message) {
        super(message);
    }
}
