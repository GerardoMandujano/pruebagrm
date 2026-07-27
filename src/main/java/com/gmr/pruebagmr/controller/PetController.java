package com.gmr.pruebagmr.controller;

import com.gmr.pruebagmr.dto.request.CreatePetRequest;
import com.gmr.pruebagmr.dto.request.CreatePetResponse;
import com.gmr.pruebagmr.dto.response.PetResponse;
import com.gmr.pruebagmr.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/pet")
@Tag(
        name = "Pets",
        description = "Operaciones para consultar y registrar mascotas"
)
public class PetController {


    PetService petService;
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @Operation(
            summary = "Obtener una mascota",
            description = "Consulta una mascota en Swagger Petstore usando su identificador"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Mascota encontrada"),
            @ApiResponse(responseCode = "404", description = "Mascota no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno")
    })
    @GetMapping("/{petId}")
    public ResponseEntity<PetResponse> obtener(
            @Parameter(
                    description = "Identificador numérico de la mascota",
                    example = "10000011"
            )
            @PathVariable Long petId
    ) {
        return ResponseEntity.ok(petService.obtenerPet(petId));
    }




    @Operation(
            summary = "Crear una mascota",
            description = "Registra una nueva mascota en el sistema externo PetStore y devuelve la información de la transacción."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Mascota creada correctamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping
    public ResponseEntity<CreatePetResponse> crear(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Información de la mascota a registrar",
                    required = true
            )
            @RequestBody CreatePetRequest request) {

        CreatePetResponse response = petService.crear(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}