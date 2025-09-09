package com.equipo5.backend.model.dtos.response;

import com.equipo5.backend.model.dtos.request.PetRequestDTO;
import com.equipo5.backend.model.dtos.response.services.ServiceEntityResponseDTO;
import com.equipo5.backend.model.enums.Role;

import java.util.List;

public record UserResponseDTO(
        Long id,
        Role rol,
        String name,
        String email,
        String password,
        String phone,
        String address,
        String avatarUser,
        List<PetRequestDTO> pets,
        List<ServiceEntityResponseDTO> services,
        List<BookingResponseDTO> bookings) {
}
