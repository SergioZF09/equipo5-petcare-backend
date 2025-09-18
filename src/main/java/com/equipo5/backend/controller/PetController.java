package com.equipo5.backend.controller;

import com.equipo5.backend.model.dtos.request.EditPetRequestDTO;
import com.equipo5.backend.model.dtos.request.PetRequestDTO;
import com.equipo5.backend.model.dtos.response.PetResponseDTO;
import com.equipo5.backend.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/pets")
@PreAuthorize("hasAnyAuthority('OWNER','ADMINISTRATOR')")
public class PetController {

    private final PetService petService;

    @Operation(summary = "Endpoint para crear una mascota")
    @PostMapping
    public ResponseEntity<PetResponseDTO> createPet(@RequestBody @Valid PetRequestDTO petRequestDTO) {
        PetResponseDTO petResponseDTO = petService.createPet(petRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(petResponseDTO);
    }

    @Operation(summary = "Endpoint para listar todas las mascotas")
    @GetMapping
    public ResponseEntity<List<PetResponseDTO>> listAllPets() {
        List<PetResponseDTO> petResponseDTO = petService.listAllPets();

        return ResponseEntity.status(HttpStatus.OK).body(petResponseDTO);
    }

    @Operation(summary = "Endpoint para listar una mascota por su id")
    @GetMapping("/{id}")
    public ResponseEntity<PetResponseDTO> listPet(@PathVariable Long id) {
        PetResponseDTO petResponseDTO = petService.listPet(id);

        return ResponseEntity.status(HttpStatus.OK).body(petResponseDTO);
    }

    @Operation(summary = "Endpoint para listar todas las mascotas de un dueño por el id del dicho dueño")
    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<PetResponseDTO>> listPetsByOwnerId(@PathVariable Long ownerId) {
        List<PetResponseDTO> petResponseDTO = petService.listPetsByOwnerId(ownerId);

        return ResponseEntity.status(HttpStatus.OK).body(petResponseDTO);
    }

    @Operation(summary = "Endpoint para actualizar una mascota por su id")
    @PutMapping("/{id}")
    public ResponseEntity<PetResponseDTO> updatePet(@PathVariable Long id, @RequestBody @Valid EditPetRequestDTO editPetRequestDTO) {
        PetResponseDTO petResponseDTO = petService.updatePet(id, editPetRequestDTO);

        return ResponseEntity.status(HttpStatus.OK).body(petResponseDTO);
    }

    @Operation(summary = "Endpoint para eliminar una mascota por su id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePet(@PathVariable Long id) {
        petService.deletePet(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}