package com.equipo5.backend.serviceImpl;

import com.equipo5.backend.exception.NoResultsException;
import com.equipo5.backend.exception.PetNotFoundException;
import com.equipo5.backend.model.Pet;
import com.equipo5.backend.model.UserEntity;
import com.equipo5.backend.model.dtos.request.EditPetRequestDTO;
import com.equipo5.backend.model.dtos.request.PetRequestDTO;
import com.equipo5.backend.model.dtos.response.PetResponseDTO;
import com.equipo5.backend.model.enums.Role;
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
    public PetResponseDTO createPet(Long id, PetRequestDTO petRequestDTO) {

        UserEntity owner = userRepository.findById(id)
                .orElseThrow(() -> NoResultsException.of(id));

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

        if (petFounded.isEmpty()) throw PetNotFoundException.of(id);

        return petMapper.toPetDTO(petRepository.getReferenceById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PetResponseDTO> listPetsByOwnerId(Long ownerId) {
        Optional<UserEntity> owner = userRepository.findByIdAndRole(ownerId, Role.OWNER);

        if (owner.isEmpty()) {
            throw NoResultsException.of(ownerId);
        }

        List<Pet> ownerWithPets = petRepository.findByOwnerId(ownerId);

        return petMapper.toPetListDTOs(ownerWithPets);
    }

    @Override
    @Transactional
    public PetResponseDTO updatePet(Long id, EditPetRequestDTO editPetRequestDTO) {
        Optional<Pet> petFounded = petRepository.findById(id);

        if (petFounded.isEmpty()) throw PetNotFoundException.of(id);

        Pet petNotModified = petRepository.getReferenceById(id);

        if (editPetRequestDTO.name() != null) petNotModified.setName(editPetRequestDTO.name());

        if (editPetRequestDTO.species() != null) petNotModified.setSpecies(editPetRequestDTO.species());

        if (editPetRequestDTO.breed() != null) petNotModified.setBreed(editPetRequestDTO.breed());

        if (editPetRequestDTO.age() != null) petNotModified.setAge(editPetRequestDTO.age());

        if (editPetRequestDTO.specialNotes() != null) petNotModified.setSpecialNotes(editPetRequestDTO.specialNotes());

        Pet petModified = petRepository.save(petNotModified);
        return petMapper.toPetDTO(petModified);
    }

    @Override
    @Transactional
    public void deletePet(Long id) {
        Optional<Pet> petFounded = petRepository.findById(id);

        if (petFounded.isEmpty()) throw PetNotFoundException.of(id);

        petRepository.deleteById(id);
    }

}
