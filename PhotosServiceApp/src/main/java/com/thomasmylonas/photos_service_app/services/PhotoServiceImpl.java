package com.thomasmylonas.photos_service_app.services;

import com.thomasmylonas.photos_service_app.dtos.photos_dtos.PhotoResponseDto;
import com.thomasmylonas.photos_service_app.entities.Photo;
import com.thomasmylonas.photos_service_app.exceptions.RequestedResourceNotFoundException;
import com.thomasmylonas.photos_service_app.repositories.PhotoRepository;
import com.thomasmylonas.photos_service_app.services.mappers.PhotoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service(value = "photoService")
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {

    @Value(value = "${json_placeholder.url}")
    private String jsonPlaceholderUrl;

    private final PhotoRepository photoRepository;
    private final PhotoMapper photoMapper;
    private final RestTemplate restTemplate;
    private final WebClient webClient;

    @Override
    public List<PhotoResponseDto> findAllPhotosByRestTemplate() {

        ResponseEntity<List<Photo>> photosResponseEntity = restTemplate.exchange(
                jsonPlaceholderUrl + "/photos",
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                });

        List<Photo> photos = photosResponseEntity.getBody();
        if (photos == null) {
            throw new RequestedResourceNotFoundException("The requested photos are not found!");
        }
        photoRepository.saveAll(photos);
        return photos.stream().map(photoMapper::fromPhoto).toList();
    }

    @Override
    public List<PhotoResponseDto> findAllPhotosByWebClient() {

        List<Photo> photos = webClient
                .get()
                .uri(jsonPlaceholderUrl + "/photos")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Photo>>() {
                })
                .block();

        if (photos == null) {
            throw new RequestedResourceNotFoundException("The requested photos are not found!");
        }
        photoRepository.saveAll(photos);
        return photos.stream().map(photoMapper::fromPhoto).toList();
    }
}
