package com.equipo5.backend.serviceImpl;

import com.equipo5.backend.exceptions.EntityNotExistException;
import com.equipo5.backend.model.Pet;
import com.equipo5.backend.model.UserEntity;
import com.equipo5.backend.model.dtos.request.PetRequestDTO;
import com.equipo5.backend.model.dtos.response.PetResponseDTO;
import com.equipo5.backend.model.mappers.PetMapper;
import com.equipo5.backend.repository.PetRepository;
import com.equipo5.backend.repository.UserRepository;
import com.equipo5.backend.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PetMapper petMapper;

    @Override
    public PetResponseDTO createPet(PetRequestDTO petRequestDTO) {

        UserEntity owner = userRepository.findById(petRequestDTO.ownerId())
                .orElseThrow(() -> new EntityNotExistException("User not found"));

        Pet pet = petMapper.toPet(petRequestDTO);
        pet.setOwner(owner);
        Pet newPet = petRepository.save(pet);

        return petMapper.toPetDTO(newPet);
    }

    @Override
    public List<PetResponseDTO> getAllPets() {
        return petMapper.toPetListDTOs(petRepository.findAll());
    }

}
