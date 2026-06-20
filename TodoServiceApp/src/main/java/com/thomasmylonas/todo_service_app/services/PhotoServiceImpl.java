package com.thomasmylonas.todo_service_app.services;

import com.thomasmylonas.todo_service_app.dtos.todo_dtos.PhotoResponseDto;
import com.thomasmylonas.todo_service_app.entities.Photo;
import com.thomasmylonas.todo_service_app.exceptions.RequestedResourceNotFoundException;
import com.thomasmylonas.todo_service_app.repositories.PhotoRepository;
import com.thomasmylonas.todo_service_app.services.mappers.PhotoMapper;
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

    @Value(value = "${jsonplaceholder.url}")
    private String jsonplaceholderUrl;

    private final PhotoRepository photoRepository;
    private final PhotoMapper photoMapper;
    private final RestTemplate restTemplate;
    private final WebClient webClient;

    @Override
    public List<PhotoResponseDto> fetchPhotosByRestTemplate() {

        ResponseEntity<List<Photo>> photosWrapperResponseEntity = restTemplate.exchange(
                jsonplaceholderUrl + "/photos",
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                });

        List<Photo> photos = photosWrapperResponseEntity.getBody();
        if (photos == null) {
            throw new RequestedResourceNotFoundException("The requested resource is not found");
        }
        photoRepository.saveAll(photos);
        return photos.stream().map(photoMapper::fromPhoto).toList();
    }


    @Override
    public List<PhotoResponseDto> fetchPhotosByWebClient() {

        List<Photo> photos = webClient
                .get()
                .uri("/photos")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Photo>>() {
                })
                .block();

        if (photos == null) {
            throw new RequestedResourceNotFoundException("The requested resource is not found");
        }
        photoRepository.saveAll(photos);
        return photos.stream().map(photoMapper::fromPhoto).toList();
    }
}
