package com.thomasmylonas.gallery_service_app;

import com.thomasmylonas.gallery_service_app.helpers.TestDataProvider;
import com.thomasmylonas.gallery_service_app.services.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class GalleryServiceAppApplication {

    private final PhotoService photoService;

    public static void main(String[] args) {
        SpringApplication.run(GalleryServiceAppApplication.class, args);
    }

    //@Bean
    public CommandLineRunner commandLineRunner() {
        return args -> photoService.saveAllPhotos(TestDataProvider.PHOTO_REQUEST_DTOS);
    }
}
