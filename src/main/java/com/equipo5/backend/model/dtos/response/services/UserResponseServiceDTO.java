package com.equipo5.backend.model.dtos.response.services;

import com.equipo5.backend.model.enums.Role;

public record UserResponseServiceDTO(
        Long id,
        Role rol,
        String name,
        String email,
        String password,
        String phone,
        String address,
        String avatarUser) {
}
