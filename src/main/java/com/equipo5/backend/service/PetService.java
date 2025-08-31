package com.equipo5.backend.service;

import com.equipo5.backend.model.dtos.request.PetRequestDTO;
import com.equipo5.backend.model.dtos.response.PetResponseDTO;

import java.util.List;

public interface PetService {

    PetResponseDTO createPet(PetRequestDTO petRequestDTO);

    List<PetResponseDTO> getAllPets();

}
