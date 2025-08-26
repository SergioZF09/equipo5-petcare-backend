package com.equipo5.backend.model.mappers;

import com.equipo5.backend.model.Pet;
import com.equipo5.backend.model.dtos.request.PetRequestDTO;
import com.equipo5.backend.model.dtos.response.PetResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PetMapper {

    Pet toPet(PetRequestDTO petDTO);

    PetResponseDTO toPetDTO(Pet pet);

    List<PetResponseDTO> toPetListDTOs(List<Pet> petList);
}