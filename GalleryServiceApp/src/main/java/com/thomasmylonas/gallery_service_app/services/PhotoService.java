package com.thomasmylonas.gallery_service_app.services;

import com.thomasmylonas.gallery_service_app.dtos.photos_dtos.PhotoRequestDto;
import com.thomasmylonas.gallery_service_app.dtos.photos_dtos.PhotoResponseDto;
import com.thomasmylonas.gallery_service_app.entities.Photo;

import java.util.List;

public interface PhotoService {

    PhotoResponseDto findPhotoById(Long id);

    List<PhotoResponseDto> findAllPhotos();

    PhotoResponseDto savePhoto(PhotoRequestDto photoRequestDto);

    List<PhotoResponseDto> saveAllPhotos(List<PhotoRequestDto> photoRequestDtos);

    PhotoResponseDto updatePhoto(PhotoRequestDto photoRequestDto, Long id);

    void deletePhotoById(Long id);
}
