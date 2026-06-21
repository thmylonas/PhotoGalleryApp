package com.thomasmylonas.gallery_service_app.repositories;

import com.thomasmylonas.gallery_service_app.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
