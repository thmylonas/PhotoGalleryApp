package com.thomasmylonas.photos_service_app.controllers;

import com.thomasmylonas.photos_service_app.dtos.photos_dtos.PhotoResponseDto;
import com.thomasmylonas.photos_service_app.services.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = {"/api/v1/photos"})
@RequiredArgsConstructor
public class PhotoController {

    private final PhotoService photoService;

    @GetMapping(path = {"rest-template"})
    public List<PhotoResponseDto> findAllPhotosByRestTemplate() {

        List<PhotoResponseDto> photoResponseDtos = photoService.fetchPhotosByRestTemplate();
        return null;
    }
}
