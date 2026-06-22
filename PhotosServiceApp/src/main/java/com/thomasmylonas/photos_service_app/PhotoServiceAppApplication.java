package com.thomasmylonas.photos_service_app;

import com.thomasmylonas.photos_service_app.dtos.photos_dtos.PhotoResponseDto;
import com.thomasmylonas.photos_service_app.services.PhotoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@PropertySource(value = "classpath:properties/properties.properties")
@Slf4j
public class PhotoServiceAppApplication {

    private final PhotoService photoService;

    public static void main(String[] args) {
        SpringApplication.run(PhotoServiceAppApplication.class, args);
    }

    //@Bean
    protected CommandLineRunner commandLineRunner() {
        return args -> {
            //List<PhotoResponseDto> photoResponseDtos = photoService.findAllPhotosByRestTemplate();
            List<PhotoResponseDto> photoResponseDtos = photoService.findAllPhotosByWebClient();
            photoResponseDtos.forEach(photoResponseDto -> log.info(photoResponseDto.toString()));
        };
    }
}
