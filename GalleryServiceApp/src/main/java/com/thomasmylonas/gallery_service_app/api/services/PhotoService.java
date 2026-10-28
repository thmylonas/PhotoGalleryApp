package com.thomasmylonas.gallery_service_app.api.services;

import com.thomasmylonas.gallery_service_app.api.dtos.photo_dtos.PhotoRequestDto;
import com.thomasmylonas.gallery_service_app.api.dtos.photo_dtos.PhotoResponseDto;
import com.thomasmylonas.gallery_service_app.api.exceptions.RequestedResourceNotFoundException;

import java.util.List;

public interface PhotoService {

    PhotoResponseDto findPhotoById(Long id) throws RequestedResourceNotFoundException;

    List<PhotoResponseDto> findAllPhotos();

    PhotoResponseDto savePhoto(PhotoRequestDto photoRequestDto);

    List<PhotoResponseDto> saveAllPhotos(List<PhotoRequestDto> photoRequestDtos);

    PhotoResponseDto updatePhoto(PhotoRequestDto photoRequestDto, Long id) throws RequestedResourceNotFoundException;

    void deletePhotoById(Long id);
}
