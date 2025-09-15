package com.equipo5.backend.controller;

import com.equipo5.backend.model.dtos.request.PetRequestDTO;
import com.equipo5.backend.model.dtos.response.PetResponseDTO;
import com.equipo5.backend.service.PetService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/pets")
public class PetController {

    private final PetService petService;

    @PostMapping
    public ResponseEntity<PetResponseDTO> createPet(@RequestBody @Valid PetRequestDTO petRequestDTO) {
        PetResponseDTO petResponseDTO = petService.createPet(petRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(petResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<PetResponseDTO>> listAllPets() {
        List<PetResponseDTO> petResponseDTO = petService.listAllPets();

        return ResponseEntity.status(HttpStatus.OK).body(petResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetResponseDTO> listPet(@PathVariable Long id) {
        PetResponseDTO petResponseDTO = petService.listPet(id);

        return ResponseEntity.status(HttpStatus.OK).body(petResponseDTO);
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<PetResponseDTO>> listPetsByOwnerId(@PathVariable Long ownerId) {
        List<PetResponseDTO> petResponseDTO = petService.listPetsByOwnerId(ownerId);

        return ResponseEntity.status(HttpStatus.OK).body(petResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetResponseDTO> updatePet(@PathVariable Long id, @RequestBody @Valid PetRequestDTO petRequestDTO) {
        PetResponseDTO petResponseDTO = petService.updatePet(id, petRequestDTO);

        return ResponseEntity.status(HttpStatus.OK).body(petResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePet(@PathVariable Long id) {
        petService.deletePet(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}