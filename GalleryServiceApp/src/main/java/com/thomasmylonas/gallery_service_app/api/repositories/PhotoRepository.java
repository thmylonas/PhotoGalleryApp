package com.thomasmylonas.gallery_service_app.api.repositories;

import com.thomasmylonas.gallery_service_app.api.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
