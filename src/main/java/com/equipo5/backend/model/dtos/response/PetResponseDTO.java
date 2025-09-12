package com.equipo5.backend.model.dtos.response;

import com.equipo5.backend.model.dtos.request.BookingRequestDTO;
import com.equipo5.backend.model.dtos.request.UserRequestDTO;
import com.equipo5.backend.model.enums.Species;

import java.util.List;

public record PetResponseDTO(
        String name,
        Species species,
        String breed,
        UserRequestDTO owner,
        List<BookingRequestDTO> bookings) {
}
