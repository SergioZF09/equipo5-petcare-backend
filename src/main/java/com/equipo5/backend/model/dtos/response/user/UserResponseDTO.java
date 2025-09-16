package com.equipo5.backend.model.dtos.response.user;

import com.equipo5.backend.model.enums.Role;

import java.util.List;

public record UserResponseDTO(
        Long id,
        Role role,
        String name,
        String email,
        //String password,
        String phone,
        String address,
        String avatarUser,
        List<UserResponsePetsDTO> pets,
        List<UserResponseServicesDTO> services,
        List<UserResponseBookingsDTO> bookings
) {}