package com.thomasmylonas.photos_service_app.models;

import com.thomasmylonas.photos_service_app.helpers.HelperClass;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.Map;

@Component
public class ResponseBuilder {

    @Value(value = "${stacktrace.display}")
    private boolean stacktrace;

    public ResponseEntity<ResponseSuccess> buildResponseSuccess(int statusCode, String message, Map<String, ?> data) {
        return buildResponseSuccess(statusCode, message, ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString(), data);
    }

    public ResponseEntity<ResponseSuccess> buildResponseSuccess(int statusCode, String message, String path, Map<String, ?> data) {

        ResponseSuccess responseSuccess = ResponseSuccess.builder()
                .timestamp(LocalDateTime.now())
                .statusCode(statusCode)
                .message(message)
                .path(path)
                .data(data)
                .build();
        return ResponseEntity.status(statusCode).header(HttpHeaders.LOCATION, path).body(responseSuccess);
    }

    public ResponseEntity<ResponseError> buildResponseError(int statusCode, String message, String path, Exception e, WebRequest webRequest) {

        ResponseError.ResponseErrorBuilder responseErrorBuilder = ResponseError.builder()
                .timestamp(LocalDateTime.now())
                .statusCode(statusCode)
                .message(message)
                .path(path);
        if (displayStacktrace(webRequest)) {
            responseErrorBuilder.stacktrace(HelperClass.stringifyStacktrace(e));
        }
        ResponseError responseError = responseErrorBuilder.build();
        return ResponseEntity.status(statusCode).header(HttpHeaders.LOCATION, path).body(responseError);
    }

    private boolean displayStacktrace(WebRequest webRequest) {
        String stacktraceParam = webRequest.getParameter("stacktrace");
        return stacktrace && StringUtils.isNotBlank(stacktraceParam) && stacktraceParam.equals("true");
    }
}
