package com.equipo5.backend.serviceImpl;

import com.equipo5.backend.exception.NoResultsException;
import com.equipo5.backend.model.Pet;
import com.equipo5.backend.model.UserEntity;
import com.equipo5.backend.model.dtos.request.PetRequestDTO;
import com.equipo5.backend.model.dtos.response.PetResponseDTO;
import com.equipo5.backend.model.mappers.PetMapper;
import com.equipo5.backend.repository.PetRepository;
import com.equipo5.backend.repository.UserRepository;
import com.equipo5.backend.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    private final UserRepository userRepository;

    private final PetMapper petMapper;

    @Override
    @Transactional
    public PetResponseDTO createPet(PetRequestDTO petRequestDTO) {

        UserEntity owner = userRepository.findById(petRequestDTO.ownerId())
                .orElseThrow(() -> NoResultsException.of(petRequestDTO.ownerId()));

        Pet pet = petMapper.toPet(petRequestDTO);
        pet.setOwner(owner);
        Pet newPet = petRepository.save(pet);

        return petMapper.toPetDTO(newPet);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PetResponseDTO> listAllPets() {
        return petMapper.toPetListDTOs(petRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public PetResponseDTO listPet(Long id) {
        Optional<Pet> petFounded = petRepository.findById(id);

        if (petFounded.isEmpty()) throw NoResultsException.of(id);

        return petMapper.toPetDTO(petRepository.getReferenceById(id));
    }

    @Override
    @Transactional
    public PetResponseDTO updatePet(Long id, PetRequestDTO petRequestDTO) {
        Optional<Pet> petFounded = petRepository.findById(id);

        if (petFounded.isEmpty()) throw NoResultsException.of(id);

        UserEntity owner = userRepository.findById(petRequestDTO.ownerId())
                .orElseThrow(() -> NoResultsException.of(petRequestDTO.ownerId()));

        Pet petNotModified = petRepository.getReferenceById(id);

        if (petRequestDTO.name() != null) petNotModified.setName(petRequestDTO.name());

        if (petRequestDTO.species() != null) petNotModified.setSpecies(petRequestDTO.species());

        if (petRequestDTO.breed() != null) petNotModified.setBreed(petRequestDTO.breed());

        if (petRequestDTO.ownerId() != null) petNotModified.setOwner(owner);

        if (petRequestDTO.age() != null) petNotModified.setAge(petRequestDTO.age());

        if (petRequestDTO.specialNotes() != null) petNotModified.setSpecialNotes(petRequestDTO.specialNotes());

        Pet petModified = petRepository.save(petNotModified);
        return petMapper.toPetDTO(petModified);
    }

    @Override
    @Transactional
    public void deletePet(Long id) {
        Optional<Pet> petFounded = petRepository.findById(id);

        if (petFounded.isEmpty()) throw NoResultsException.of(id);

        petRepository.deleteById(id);
    }

}
