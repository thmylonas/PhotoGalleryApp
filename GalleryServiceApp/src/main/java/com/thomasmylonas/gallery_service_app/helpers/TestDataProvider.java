package com.thomasmylonas.gallery_service_app.helpers;

import com.thomasmylonas.gallery_service_app.dtos.photos_dtos.PhotoRequestDto;

import java.util.List;

public class TestDataProvider {

    public static final List<PhotoRequestDto> PHOTO_REQUEST_DTOS = List.of(
            PhotoRequestDto.builder()
                    .albumId(1L)
                    .title("sequi sunt enim aut at")
                    .url("https://via.placeholder.com/600/e5109")
                    .thumbnailUrl("https://via.placeholder.com/150/e5109")
                    .build(),
            PhotoRequestDto.builder()
                    .albumId(3L)
                    .title("voluptatem ab aliquam dolorum vel voluptas qui repellendus")
                    .url("https://via.placeholder.com/600/b3db9a")
                    .thumbnailUrl("https://via.placeholder.com/150/b3db9a")
                    .build(),
            PhotoRequestDto.builder()
                    .albumId(5L)
                    .title("sunt amet autem exercitationem fuga consequatur")
                    .url("https://via.placeholder.com/600/13454b")
                    .thumbnailUrl("https://via.placeholder.com/150/13454b")
                    .build(),
            PhotoRequestDto.builder()
                    .albumId(8L)
                    .title("qui quo cumque distinctio aut voluptas")
                    .url("https://via.placeholder.com/600/315aa6")
                    .thumbnailUrl("https://via.placeholder.com/150/315aa6")
                    .build(),
            PhotoRequestDto.builder()
                    .albumId(100L)
                    .title("in voluptate sit officia non nesciunt quis")
                    .url("https://via.placeholder.com/600/1b9d08")
                    .thumbnailUrl("https://via.placeholder.com/150/1b9d08")
                    .build()
    );
}
