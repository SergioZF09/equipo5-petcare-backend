package com.equipo5.backend.model.mappers;

import com.equipo5.backend.model.Booking;
import com.equipo5.backend.model.dtos.request.BookingRequestDTO;
import com.equipo5.backend.model.dtos.response.BookingResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    Booking toBooking(BookingRequestDTO bookingDTO);

    BookingResponseDTO toBookingDTO(Booking booking);

    List<BookingResponseDTO> toBookingDTOs(List<Booking> bookingList);
}