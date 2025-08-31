package com.equipo5.backend.model.mappers;

import com.equipo5.backend.model.Pet;
import com.equipo5.backend.model.dtos.request.PetRequestDTO;
import com.equipo5.backend.model.dtos.response.PetResponseDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring"/*, uses = {UserEntityMapper.class, BookingMapper.class}*/)
public interface PetMapper {

//    @Mappings({
//            @Mapping(source = "name", target = "name"),
//            @Mapping(source = "species", target = "species"),
//            @Mapping(source = "breed", target = "breed")
//    })
    Pet toPet(PetRequestDTO petDTO);

//    @InheritInverseConfiguration
    PetResponseDTO toPetDTO(Pet pet);

    List<PetResponseDTO> toPetListDTOs(List<Pet> petList);
}