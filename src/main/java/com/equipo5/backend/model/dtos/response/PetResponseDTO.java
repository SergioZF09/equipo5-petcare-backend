package com.equipo5.backend.model.dtos.response;

import com.equipo5.backend.model.Booking;
import com.equipo5.backend.model.UserEntity;

import java.util.List;

public record PetResponseDTO(
        String name,
        String species,
        String breed,
        UserEntity owner,
        List<Booking> bookings) {
}
