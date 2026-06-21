package com.thomasmylonas.photos_service_app.controllers.advice_controllers;

import com.thomasmylonas.photos_service_app.exceptions.RequestedResourceNotFoundException;
import com.thomasmylonas.photos_service_app.models.ResponseBuilder;
import com.thomasmylonas.photos_service_app.models.ResponseError;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionsHandlerController {

    private final ResponseBuilder responseBuilder;

    @ExceptionHandler(value = {RequestedResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND) // 404: "Not Found"
    public ResponseEntity<ResponseError> handleRequestedResourceNotFoundException(RequestedResourceNotFoundException e, WebRequest webRequest) {
        final String message = e.getMessage();
        return responseBuilder.buildResponseError(HttpStatus.NOT_FOUND.value(), message, "", e, webRequest);
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500: "Internal Server Error"
    public ResponseEntity<ResponseError> handleException(Exception e, WebRequest webRequest) {
        final String message = e.getMessage();
        return responseBuilder.buildResponseError(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, "", e, webRequest);
    }
}
