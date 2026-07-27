package com.gmr.pruebagmr.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreatePetResponse(

        @Schema(
                description = "Identificador único de la transacción",
                example = "550e8400-e29b-41d4-a716-446655440000"
        )
        UUID transactionId,

        @Schema(
                description = "Fecha y hora de creación de la transacción",
                example = "2026-07-27T14:30:15-06:00"
        )
        LocalDateTime dateCreated,

        @Schema(
                description = "Estado de la mascota",
                example = "available"
        )
        String status,

        @Schema(
                description = "Nombre de la mascota",
                example = "Firulais"
        )
        String name
) {
}