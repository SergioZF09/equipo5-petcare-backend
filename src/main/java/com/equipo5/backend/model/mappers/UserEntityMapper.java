package com.equipo5.backend.model.mappers;

import com.equipo5.backend.model.Booking;
import com.equipo5.backend.model.Pet;
import com.equipo5.backend.model.ServiceEntity;
import com.equipo5.backend.model.UserEntity;
import com.equipo5.backend.model.dtos.request.UserRequestDTO;
import com.equipo5.backend.model.dtos.response.UserResponseBookingsDTO;
import com.equipo5.backend.model.dtos.response.UserResponseDTO;
import com.equipo5.backend.model.dtos.response.UserResponsePetsDTO;
import com.equipo5.backend.model.dtos.response.UserResponseServicesDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    UserEntity toUser(UserRequestDTO userDTO);

    UserResponseDTO toUserDTO(UserEntity user);

    List<UserResponseDTO> toUserDTOs(List<UserEntity> user);

    List<UserResponsePetsDTO> toUserPetsDTOs(List<Pet> pet);

    List<UserResponseBookingsDTO> toUserBookingsDTOs(List<Booking> booking);

    List<UserResponseServicesDTO> toUserResponseServicesDTOs(List<ServiceEntity> userResponseServices);
}