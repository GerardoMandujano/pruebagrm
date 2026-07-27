package com.gmr.pruebagmr.service;


import com.gmr.pruebagmr.Client.PetStoreClient;
import com.gmr.pruebagmr.dto.request.CreatePetRequest;
import com.gmr.pruebagmr.dto.request.CreatePetResponse;
import com.gmr.pruebagmr.dto.PetStorePet;
import com.gmr.pruebagmr.dto.response.PetResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
public class PetService implements  IPetService{

    private final PetStoreClient petStoreClient;

    public PetService(PetStoreClient petStoreClient) {
        this.petStoreClient = petStoreClient;
    }

    @Override
    public PetResponse obtenerPet(Long id) {
        return new PetResponse(
                id,
                "testing",
               "available"
        );

    }

    public CreatePetResponse crear(CreatePetRequest request) {

        PetStorePet pet = new PetStorePet(
                request.id(),
                request.name(),
                request.status()
        );

        PetStorePet petCreado = petStoreClient.crear(pet);

        log.info("Respuesta obtenida de Petstore: {}", petCreado);

        return new CreatePetResponse(
                UUID.randomUUID(),
                LocalDateTime.now(),
                petCreado.status(),
                petCreado.name()
        );
    }

}
