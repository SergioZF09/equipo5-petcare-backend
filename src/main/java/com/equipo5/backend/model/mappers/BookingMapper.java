package com.equipo5.backend.model.mappers;

import com.equipo5.backend.model.Booking;
import com.equipo5.backend.model.dtos.request.BookingRequestDTO;
import com.equipo5.backend.model.dtos.response.BookingResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    Booking toBooking(BookingRequestDTO bookingDTO);

    @Mapping(target = "user", source = "owners")
    @Mapping(target = "service", source = "services")
    @Mapping(target = "pet", source = "pets")
    BookingResponseDTO toBookingDTO(Booking booking);

    List<BookingResponseDTO> toBookingDTOs(List<Booking> bookingList);
}