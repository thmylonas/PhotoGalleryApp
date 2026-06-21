package com.thomasmylonas.gallery_service_app.services.mappers;

import com.thomasmylonas.gallery_service_app.dtos.photos_dtos.PhotoRequestDto;
import com.thomasmylonas.gallery_service_app.dtos.photos_dtos.PhotoResponseDto;
import com.thomasmylonas.gallery_service_app.entities.Photo;
import org.springframework.stereotype.Service;

@Service
public class PhotoMapper {

    public Photo toPhoto(PhotoRequestDto photoRequestDto) {
        return Photo.builder()
                .albumId(photoRequestDto.albumId())
                .title(photoRequestDto.url())
                .url(photoRequestDto.url())
                .thumbnailUrl(photoRequestDto.thumbnailUrl())
                .build();
    }

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
