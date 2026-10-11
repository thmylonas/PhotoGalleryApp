package com.thomasmylonas.photos_service_app.api.services.mappers;

import com.thomasmylonas.photos_service_app.api.dtos.photo_dtos.PhotoResponseDto;
import com.thomasmylonas.photos_service_app.api.entities.Photo;
import org.springframework.stereotype.Service;

@Service
public class PhotoMapper {

    public PhotoResponseDto fromPhoto(Photo photo) {
        return PhotoResponseDto.builder()
                .id(photo.getId())
                .albumId(photo.getAlbumId())
                .title(photo.getTitle())
                .url(photo.getUrl())
                .thumbnailUrl(photo.getThumbnailUrl())
                .build();
    }
}
