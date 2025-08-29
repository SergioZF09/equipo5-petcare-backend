package com.equipo5.backend.model.dtos.response;

import com.equipo5.backend.model.Booking;
import com.equipo5.backend.model.Pet;
import com.equipo5.backend.model.ServiceEntity;
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
        List<Pet> pets,
        List<ServiceEntity> services,
        List<Booking> bookings) {
}
