package com.thomasmylonas.photos_service_app.services.mappers;

import com.thomasmylonas.photos_service_app.dtos.todo_dtos.PhotoResponseDto;
import com.thomasmylonas.photos_service_app.entities.Photo;
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
