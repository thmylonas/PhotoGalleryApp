package com.thomasmylonas.photos_service_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClientsConfig {

    @Bean(value = "restTemplate")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean(value = "webClient")
    public WebClient webClient() {
        return WebClient
                .builder()
                .codecs(codecs -> codecs
                        .defaultCodecs()
                        .maxInMemorySize(500 * 1024 * 1024)
                )
                .build();
    }
}
