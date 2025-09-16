package com.equipo5.backend.model.dtos.response;

import com.equipo5.backend.model.dtos.request.BookingRequestDTO;
import com.equipo5.backend.model.dtos.response.user.UserResponseDTO;

import java.util.List;

public record ServiceEntityResponseDTO(
        String type,
        String description,
        Double rate,
        UserResponseDTO owners,
        List<BookingRequestDTO> bookings) {
}
