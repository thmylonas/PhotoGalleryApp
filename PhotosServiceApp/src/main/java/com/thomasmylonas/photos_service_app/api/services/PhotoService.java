package com.thomasmylonas.photos_service_app.api.services;

import com.thomasmylonas.photos_service_app.api.dtos.photo_dtos.PhotoResponseDto;

import java.util.List;

public interface PhotoService {

    List<PhotoResponseDto> findAllPhotosByRestTemplateAndSaveAllPhotos();

    List<PhotoResponseDto> findAllPhotosByWebClientAndSaveAllPhotos();

    List<PhotoResponseDto> saveAllPhotosAndSendPhotosToGalleryServiceApp();
}
