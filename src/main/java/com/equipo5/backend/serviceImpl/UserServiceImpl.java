package com.equipo5.backend.serviceImpl;

import com.equipo5.backend.exception.EmailAlreadyExistsException;
import com.equipo5.backend.exception.NoResultsException;
import com.equipo5.backend.model.UserEntity;
import com.equipo5.backend.model.dtos.request.UserRequestDTO;
import com.equipo5.backend.model.dtos.response.UserResponseDTO;
import com.equipo5.backend.model.mappers.UserEntityMapper;
import com.equipo5.backend.repository.UserRepository;

import com.equipo5.backend.service.UserService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserEntityMapper mapper;
    private final UserRepository repository;

    @Override
    @Transactional
    public Long createUser(UserRequestDTO request) {
        if (repository.existsByEmail(request.email())) {
            throw EmailAlreadyExistsException.of(request.email());
        }
        UserEntity user = mapper.toUser(request);
        UserEntity savedUser = repository.save(user);
        return savedUser.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponseDTO readUser(Long id) {
        UserEntity user = getUser(id);
        return mapper.toUserDTO(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserResponseDTO> readAll(Pageable pageable) {
        Page<UserEntity> users = repository.findAll(PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSortOr(Sort.by(Sort.Direction.ASC, "name")))
        );
        if (users.getContent().isEmpty()) {
            return Page.empty();
        }
        return users.map(mapper::toUserDTO);
    }

    // Solo Update de 'name, email, password, address, avatar'.
    @Override
    @Transactional
    public void updateUser(UserRequestDTO request, Long id) {
        UserEntity user = getUser(id);
        if (!user.getEmail().equals(request.email())
                && repository.existsByEmail(request.email())) {
            throw EmailAlreadyExistsException.of(request.email());
        }
        user.setEmail(request.email());
        user.setPhone(request.phone());
        user.setName(request.name());
        user.setPassword(request.password());
        user.setAddress(request.address());
        user.setAvatarUser(request.avatarUser());
        repository.saveAndFlush(user);
    }


    @Override
    @Transactional
    public void deleteUser(Long id) {
        // Solo permite desactivar, no borra de la DB.
        //setInactive(id);
        if (!repository.existsById(id)) {
            throw NoResultsException.of(id);
        }
        repository.deleteById(id);
    }

    // Metodo de Consulta unica para centralizar flujo de excepciones
    private UserEntity getUser(Long id) throws NoResultsException {
        if (id == null) {
            throw NoResultsException.of(null);
        }
        return repository.findById(id)
                .orElseThrow(() -> NoResultsException.of(id));

    }

    //private void setInactive(Long id) {
    //    UserEntity user = getUser(id);
    //    user.setInactive();
    //    repository.saveAndFlush(user);
    //}
    //private void setActive(Long id) {
    //    UserEntity user = getUser(id);
    //    user.setActive();
    //    repository.saveAndFlush(user);
    //}
}
