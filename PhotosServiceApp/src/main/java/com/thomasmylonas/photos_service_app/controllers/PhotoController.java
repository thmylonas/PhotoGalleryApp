package com.thomasmylonas.photos_service_app.controllers;

import com.thomasmylonas.photos_service_app.dtos.photos_dtos.PhotoResponseDto;
import com.thomasmylonas.photos_service_app.models.ResponseBuilder;
import com.thomasmylonas.photos_service_app.models.ResponseSuccess;
import com.thomasmylonas.photos_service_app.services.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = {"/api/v1/photos"})
@RequiredArgsConstructor
public class PhotoController {

    private final PhotoService photoService;
    private final ResponseBuilder responseBuilder;

    /**
     * http://localhost:8080/api/v1/photos/rest-template
     *
     * @return The ResponseEntity<ResponseSuccess>
     */
    @GetMapping(path = {"rest-template"})
    public ResponseEntity<ResponseSuccess> findAllPhotosByRestTemplate() {
        final String message = "Success: The photos are found (by RestTemplate)!";
        List<PhotoResponseDto> photoResponseDtos = photoService.findAllPhotosByRestTemplate();
        return responseBuilder.buildResponseSuccess(HttpStatus.OK.value(), message, Map.of("photos_response", photoResponseDtos));
    }

    /**
     * http://localhost:8080/api/v1/photos/web-client
     *
     * @return The ResponseEntity<ResponseSuccess>
     */
    @GetMapping(path = {"web-client"})
    public ResponseEntity<ResponseSuccess> findAllPhotosByWebClient() {
        final String message = "Success: The photos are found (by WebClient)!";
        List<PhotoResponseDto> photoResponseDtos = photoService.findAllPhotosByWebClient();
        return responseBuilder.buildResponseSuccess(HttpStatus.OK.value(), message, Map.of("photos_response", photoResponseDtos));
    }
}
