package com.equipo5.backend.model.dtos.response;

import com.equipo5.backend.model.dtos.request.BookingRequestDTO;
import com.equipo5.backend.model.dtos.request.UserRequestDTO;

import java.util.List;

public record PetResponseDTO(
        String name,
        String species,
        String breed,
        UserRequestDTO owner,
        List<BookingRequestDTO> bookings) {
}
