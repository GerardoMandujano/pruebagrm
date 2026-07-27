package com.gmr.pruebagmr.Client;


import com.gmr.pruebagmr.dto.PetStorePet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class PetStoreClient {

    private final RestClient restClient;

    public PetStorePet crear(PetStorePet pet) {
        return restClient.post()
                .uri("/pet")
                .contentType(MediaType.APPLICATION_JSON)
                .body(pet)
                .retrieve()
                .body(PetStorePet.class);
    }
}