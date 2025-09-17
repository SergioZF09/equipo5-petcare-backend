package com.equipo5.backend.model.dtos.response;

import com.equipo5.backend.model.dtos.request.BookingRequestDTO;
import com.equipo5.backend.model.dtos.request.user.UserRequestDTO;
import com.equipo5.backend.model.enums.Species;

import java.util.List;

public record PetResponseDTO(
        Long id,
        String name,
        Species species,
        String breed,
        Integer age,
        String specialNotes,
        UserRequestDTO owner,
        List<BookingRequestDTO> bookings) {
}
