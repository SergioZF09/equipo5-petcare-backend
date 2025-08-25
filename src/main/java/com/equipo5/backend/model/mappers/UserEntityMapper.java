package com.equipo5.backend.model.mappers;

import com.equipo5.backend.model.UserEntity;
import com.equipo5.backend.model.dtos.request.UserRequestDTO;
import com.equipo5.backend.model.dtos.response.UserResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    UserEntity toUser(UserRequestDTO userDTO);

    UserResponseDTO toUserDTO(UserEntity user);

    List<UserResponseDTO> toUserDTOs(List<UserEntity> user);
}