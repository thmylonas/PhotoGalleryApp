package com.thomasmylonas.gallery_service_app.api.services;

import com.thomasmylonas.gallery_service_app.api.dtos.photo_dtos.PhotoRequestDto;
import com.thomasmylonas.gallery_service_app.api.dtos.photo_dtos.PhotoResponseDto;
import com.thomasmylonas.gallery_service_app.api.entities.Photo;
import com.thomasmylonas.gallery_service_app.api.exceptions.RequestedResourceNotFoundException;
import com.thomasmylonas.gallery_service_app.api.repositories.PhotoRepository;
import com.thomasmylonas.gallery_service_app.api.services.mappers.PhotoMapper;
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
                .orElseThrow(() -> new RequestedResourceNotFoundException(Photo.class.getSimpleName(), id));
        return photoMapper.fromPhoto(photo);
    }

    @Override
    public List<PhotoResponseDto> findAllPhotos() {
        List<Photo> photos = photoRepository.findAll();
        return photos.stream().map(photoMapper::fromPhoto).toList();
    }

    @Override
    public PhotoResponseDto savePhoto(PhotoRequestDto photoRequestDto) {
        Photo photo = photoMapper.toPhoto(photoRequestDto);
        Photo savedPhoto = photoRepository.save(photo);
        return photoMapper.fromPhoto(savedPhoto);
    }

    @Override
    public List<PhotoResponseDto> saveAllPhotos(List<PhotoRequestDto> photoRequestDtos) {
        return photoRequestDtos.stream().map(this::savePhoto).toList();
    }

    @Override
    public PhotoResponseDto updatePhoto(PhotoRequestDto photoRequestDto, Long id) {

        Photo photoToUpdate = photoRepository.findById(id)
                .orElseThrow(() -> new RequestedResourceNotFoundException(Photo.class.getSimpleName(), id));
        Photo photo = photoMapper.toPhoto(photoRequestDto);

        if (Objects.nonNull(photo.getAlbumId())) {
            photoToUpdate.setAlbumId(photo.getAlbumId());
        }
        if (StringUtils.hasLength(photo.getTitle())) {
            photoToUpdate.setTitle(photo.getTitle());
        }
        if (StringUtils.hasLength(photo.getUrl())) {
            photoToUpdate.setUrl(photo.getUrl());
        }
        if (StringUtils.hasLength(photo.getThumbnailUrl())) {
            photoToUpdate.setThumbnailUrl(photo.getThumbnailUrl());
        }
        Photo updatedPhoto = photoRepository.save(photoToUpdate);
        return photoMapper.fromPhoto(updatedPhoto);
    }

    @Override
    public void deletePhotoById(Long id) {
        photoRepository.deleteById(id);
    }
}
