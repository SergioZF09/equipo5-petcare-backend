package com.equipo5.backend.service;

import com.equipo5.backend.model.dtos.request.UserRequestDTO;
import com.equipo5.backend.model.dtos.response.UserResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

// C createUser
// R readUser, readAll
// U updateUser
// D deleteUser
public interface UserService {

    public Long createUser(UserRequestDTO request) ;
    public UserResponseDTO readUser(Long id) ;
    public Page<UserResponseDTO> readAll(Pageable pageable) ;
    public void updateUser(UserRequestDTO request, Long id) ;
    public void deleteUser(Long id) ;
}
