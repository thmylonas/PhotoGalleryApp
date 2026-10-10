package com.thomasmylonas.gallery_service_app.controllers;

import com.thomasmylonas.gallery_service_app.dtos.photos_dtos.PhotoRequestDto;
import com.thomasmylonas.gallery_service_app.dtos.photos_dtos.PhotoResponseDto;
import com.thomasmylonas.gallery_service_app.models.ResponseBuilder;
import com.thomasmylonas.gallery_service_app.models.ResponseSuccess;
import com.thomasmylonas.gallery_service_app.services.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = {"/api/v1/photos"})
@RequiredArgsConstructor
public class PhotoController {

    private static final String REQUEST_MAPPING = "/api/v1/photos";

    private final PhotoService photoService;
    private final ResponseBuilder responseBuilder;

    /**
     * Endpoint:
     * - GET, "http://localhost:8081/api/v1/photos/{id}"
     *
     * @param photoId The "photoId"
     * @return The ResponseEntity<ResponseSuccess>
     */
    @GetMapping(path = {"/{id}"})
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<ResponseSuccess> findPhotoById(@PathVariable(value = "id") Long photoId) {
        final String message = "Success: The Photo with ID " + photoId + " is found!";
        PhotoResponseDto photoResponseDto = photoService.findPhotoById(photoId);
        return responseBuilder.buildResponseSuccess(HttpStatus.OK, message, Map.of("photo_response", photoResponseDto));
    }

    /**
     * Endpoint:
     * - GET, "http://localhost:8081/api/v1/photos"
     *
     * @return The ResponseEntity<ResponseSuccess>
     */
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<ResponseSuccess> findAllPhotos() {
        final String message = "Success: The Photos are found!";
        List<PhotoResponseDto> photoResponseDtos = photoService.findAllPhotos();
        return responseBuilder.buildResponseSuccess(HttpStatus.OK, message, Map.of("photos_response", photoResponseDtos));
    }

    /**
     * Endpoint:
     * - POST, "http://localhost:8081/api/v1/photos"
     *
     * @param photoRequestDto The "photoRequestDto"
     * @return The ResponseEntity<ResponseSuccess>
     */
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<ResponseSuccess> savePhoto(@RequestBody PhotoRequestDto photoRequestDto) {

        final String message = "Created: The Photo has been created successfully!";
        PhotoResponseDto savedPhotoResponseDto = photoService.savePhoto(photoRequestDto);
        String savedPhotoUri = ServletUriComponentsBuilder
                .fromCurrentContextPath() // "http://localhost:8081"
                .path(REQUEST_MAPPING + "/{id}")
                .buildAndExpand(savedPhotoResponseDto.id())
                .toUriString();
        return responseBuilder.buildResponseSuccess(HttpStatus.CREATED, message, savedPhotoUri, Map.of("saved_photo_response", savedPhotoResponseDto));
    }

    /**
     * Endpoint:
     * - POST, "http://localhost:8081/api/v1/photos/all"
     *
     * @param photoRequestDtos The "photoRequestDtos"
     * @return The ResponseEntity<ResponseSuccess>
     */
    @PostMapping(path = {"/all"})
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<ResponseSuccess> saveAllPhotos(@RequestBody List<PhotoRequestDto> photoRequestDtos) {
        final String message = "Created: The Photos have been created successfully!";
        List<PhotoResponseDto> savedPhotoResponseDtos = photoService.saveAllPhotos(photoRequestDtos);
        return responseBuilder.buildResponseSuccess(HttpStatus.CREATED, message, Map.of("saved_photos_response", savedPhotoResponseDtos));
    }

    /**
     * Endpoint:
     * - PUT, "http://localhost:8081/api/v1/photos/{id}"
     *
     * @param photoRequestDto The "photoRequestDto"
     * @param photoId         The "photoId"
     * @return The ResponseEntity<ResponseSuccess>
     */
    @PutMapping(path = {"/{id}"})
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<ResponseSuccess> updatePhoto(@RequestBody PhotoRequestDto photoRequestDto, @PathVariable(value = "id") Long photoId) {
        final String message = "Success: The Photo with ID " + photoId + " has been updated successfully!";
        PhotoResponseDto updatedPhotoResponseDto = photoService.updatePhoto(photoRequestDto, photoId);
        return responseBuilder.buildResponseSuccess(HttpStatus.OK, message, Map.of("updated_photo_response", updatedPhotoResponseDto));
    }

    /**
     * Endpoint:
     * - DELETE, "http://localhost:8081/api/v1/photos/{id}"
     *
     * @param photoId The "photoId"
     * @return The ResponseEntity<ResponseSuccess>
     */
    @DeleteMapping(path = {"/{id}"})
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<ResponseSuccess> deletePhotoById(@PathVariable(value = "id") Long photoId) {
        final String message = "Success: The Photo with ID " + photoId + " has been deleted successfully!";
        photoService.deletePhotoById(photoId);
        return responseBuilder.buildResponseSuccess(HttpStatus.OK, message, Map.of("message", message));
    }
}
