package com.thomasmylonas.photos_service_app.controllers;

import com.thomasmylonas.photos_service_app.dtos.photos_dtos.PhotoResponseDto;
import com.thomasmylonas.photos_service_app.models.ResponseBuilder;
import com.thomasmylonas.photos_service_app.models.ResponseSuccess;
import com.thomasmylonas.photos_service_app.services.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
     * Endpoint:
     * - POST, "http://localhost:8080/api/v1/photos/rest-template"
     *
     * @return The ResponseEntity<ResponseSuccess>
     */
    @PostMapping(path = {"/rest-template"})
    public ResponseEntity<ResponseSuccess> findAllPhotosByRestTemplateAndSaveAllPhotos() {
        final String message = "Success: The photos are found (by RestTemplate)!";
        List<PhotoResponseDto> photoResponseDtos = photoService.findAllPhotosByRestTemplateAndSaveAllPhotos();
        return responseBuilder.buildResponseSuccess(HttpStatus.OK, message, Map.of("photos_response", photoResponseDtos));
    }

    /**
     * Endpoint:
     * - POST, "http://localhost:8080/api/v1/photos/web-client"
     *
     * @return The ResponseEntity<ResponseSuccess>
     */
    @PostMapping(path = {"/web-client"})
    public ResponseEntity<ResponseSuccess> findAllPhotosByWebClientAndSaveAllPhotos() {
        final String message = "Success: The photos are found (by WebClient)!";
        List<PhotoResponseDto> photoResponseDtos = photoService.findAllPhotosByWebClientAndSaveAllPhotos();
        return responseBuilder.buildResponseSuccess(HttpStatus.OK, message, Map.of("photos_response", photoResponseDtos));
    }
}
