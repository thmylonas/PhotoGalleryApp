package com.thomasmylonas.photos_service_app.services;

import com.thomasmylonas.photos_service_app.dtos.photos_dtos.PhotoResponseDto;

import java.util.List;

public interface PhotoService {

    List<PhotoResponseDto> fetchPhotosByRestTemplate();

    List<PhotoResponseDto> fetchPhotosByWebClient();
}
