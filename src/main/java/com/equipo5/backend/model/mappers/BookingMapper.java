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

    @Mapping(target = "id_user", source = "owners.id")
    @Mapping(target = "id_service", source = "services.id")
    @Mapping(target = "id_pet", source = "pets.id")
    BookingResponseDTO toBookingDTO(Booking booking);

    List<BookingResponseDTO> toBookingDTOs(List<Booking> bookingList);
}