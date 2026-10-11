package com.thomasmylonas.photos_service_app.api.controllers;

import com.thomasmylonas.photos_service_app.api.dtos.photo_dtos.PhotoResponseDto;
import com.thomasmylonas.photos_service_app.api.models.ResponseBuilder;
import com.thomasmylonas.photos_service_app.api.models.ResponseSuccess;
import com.thomasmylonas.photos_service_app.api.services.PhotoService;
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
public class InteractWithGalleryServiceAppController {

    private final PhotoService photoService;
    private final ResponseBuilder responseBuilder;

    /**
     * Endpoint:
     * - POST, "http://localhost:8080/api/v1/photos"
     *
     * @return The ResponseEntity<ResponseSuccess>
     */
    @PostMapping
    public ResponseEntity<ResponseSuccess> saveAllPhotosAndSendPhotosToGalleryServiceApp() {
        final String message = "Success: The photos are send to 'GalleryServiceApp'!";
        List<PhotoResponseDto> photoResponseDtos = photoService.saveAllPhotosAndSendPhotosToGalleryServiceApp();
        return responseBuilder.buildResponseSuccess(HttpStatus.OK, message, Map.of("photos_response", photoResponseDtos));
    }
}
