package com.gmr.pruebagmr.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreatePetRequest(

        @Schema(
                description = "Identificador de la mascota",
                example = "10000011",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotNull
        Long id,

        @Schema(
                description = "Nombre de la mascota",
                example = "Firulais",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotBlank
        String name,

        @Schema(
                description = "Estado de la mascota",
                example = "available",
                allowableValues = {"available", "pending", "sold"},
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotBlank
        String status
) {
}