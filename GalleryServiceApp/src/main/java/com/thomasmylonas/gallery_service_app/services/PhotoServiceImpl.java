package com.thomasmylonas.gallery_service_app.services;

import com.thomasmylonas.gallery_service_app.dtos.photos_dtos.PhotoRequestDto;
import com.thomasmylonas.gallery_service_app.dtos.photos_dtos.PhotoResponseDto;
import com.thomasmylonas.gallery_service_app.entities.Photo;
import com.thomasmylonas.gallery_service_app.exceptions.RequestedResourceNotFoundException;
import com.thomasmylonas.gallery_service_app.repositories.PhotoRepository;
import com.thomasmylonas.gallery_service_app.services.mappers.PhotoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service(value = "photoService")
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {

    private final PhotoRepository photoRepository;
    private final PhotoMapper photoMapper;

    @Override
    public PhotoResponseDto findPhotoById(Long id) {
        Photo photo = photoRepository.findById(id)
                .orElseThrow(() -> new RequestedResourceNotFoundException(id, Photo.class.getSimpleName()));
        return photoMapper.fromPhoto(photo);
    }

    @Override
    public List<PhotoResponseDto> findAllPhotos() {
        return photoRepository.findAll().stream().map(photoMapper::fromPhoto).toList();
    }

    @Override
    public PhotoResponseDto savePhoto(PhotoRequestDto photoRequestDto) {
        Photo photoToSave = photoMapper.toPhoto(photoRequestDto);
        Photo savedPhoto = photoRepository.save(photoToSave);
        return photoMapper.fromPhoto(savedPhoto);
    }

    @Override
    public List<PhotoResponseDto> saveAllPhotos(List<PhotoRequestDto> photoRequestDtos) {
        return photoRequestDtos.stream().map(this::savePhoto).toList();
    }

    @Override
    public PhotoResponseDto updatePhoto(PhotoRequestDto photoRequestDto, Long id) {

        Photo photoToUpdate = photoRepository.findById(id)
                .orElseThrow(() -> new RequestedResourceNotFoundException(id, Photo.class.getSimpleName()));

        if (Objects.nonNull(photoRequestDto.albumId())) {
            photoToUpdate.setAlbumId(photoRequestDto.albumId());
        }
        if (StringUtils.hasLength(photoRequestDto.title())) {
            photoToUpdate.setTitle(photoRequestDto.title());
        }
        if (StringUtils.hasLength(photoRequestDto.url())) {
            photoToUpdate.setUrl(photoRequestDto.url());
        }
        if (StringUtils.hasLength(photoRequestDto.thumbnailUrl())) {
            photoToUpdate.setThumbnailUrl(photoRequestDto.thumbnailUrl());
        }
        Photo updatedPhoto = photoRepository.save(photoToUpdate);
        return photoMapper.fromPhoto(updatedPhoto);
    }

    @Override
    public void deletePhotoById(Long id) {
        photoRepository.deleteById(id);
    }
}
