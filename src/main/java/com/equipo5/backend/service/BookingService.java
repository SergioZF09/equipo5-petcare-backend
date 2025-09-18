package com.equipo5.backend.service;

import com.equipo5.backend.model.dtos.request.BookingRequestDTO;
import com.equipo5.backend.model.dtos.response.BookingResponseDTO;

import java.util.List;

public interface BookingService {

    BookingResponseDTO createBooking(BookingRequestDTO bookingRequestDTO);

    List<BookingResponseDTO> listAllBookings();

    List<BookingResponseDTO> listBookingsByOwnerId(Long ownerId);

    void cancelBooking(Long id);

}
