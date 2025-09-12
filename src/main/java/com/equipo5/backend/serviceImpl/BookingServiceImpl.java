package com.equipo5.backend.serviceImpl;

import com.equipo5.backend.exception.ConflictBookingsException;
import com.equipo5.backend.exception.NoResultsException;
import com.equipo5.backend.model.Booking;
import com.equipo5.backend.model.Pet;
import com.equipo5.backend.model.ServiceEntity;
import com.equipo5.backend.model.UserEntity;
import com.equipo5.backend.model.dtos.request.BookingRequestDTO;
import com.equipo5.backend.model.dtos.response.BookingResponseDTO;
import com.equipo5.backend.model.enums.Role;
import com.equipo5.backend.model.mappers.BookingMapper;
import com.equipo5.backend.repository.BookingRepository;
import com.equipo5.backend.repository.PetRepository;
import com.equipo5.backend.repository.ServiceRepository;
import com.equipo5.backend.repository.UserRepository;
import com.equipo5.backend.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    private final UserRepository userRepository;

    private final ServiceRepository serviceRepository;

    private final PetRepository petRepository;

    private final BookingMapper bookingMapper;

    @Override
    @Transactional
    public BookingResponseDTO createBooking(BookingRequestDTO bookingRequestDTO) {
        Optional<Booking> conflictBookings = bookingRepository.findConflictsBookings(bookingRequestDTO.startTime(), bookingRequestDTO.endTime());

        if (conflictBookings.isPresent()) {
            throw ConflictBookingsException.of("A booking with the same schedule already exists");
        }

        Optional<UserEntity> owner = userRepository.findByIdAndRol(bookingRequestDTO.id_user(), Role.OWNER);

        if (owner.isEmpty()) {
            throw NoResultsException.of(bookingRequestDTO.id_user());
        }

        ServiceEntity service = serviceRepository.findById(bookingRequestDTO.id_service())
                .orElseThrow(() -> NoResultsException.of(bookingRequestDTO.id_service()));

        Pet pet = petRepository.findById(bookingRequestDTO.id_pet())
                .orElseThrow(() -> NoResultsException.of(bookingRequestDTO.id_pet()));

        Booking booking = bookingMapper.toBooking(bookingRequestDTO);
        booking.setOwners(owner.get());
        booking.setServices(service);
        booking.setPets(pet);
        Booking newBooking = bookingRepository.save(booking);

        return bookingMapper.toBookingDTO(newBooking);
    }

    @Override
    @Transactional
    public List<BookingResponseDTO> listAllBookings() {
        return bookingMapper.toBookingDTOs(bookingRepository.findAll());
    }

    @Override
    public void cancelBooking(Long id) {
        Optional<Booking> bookingFounded = bookingRepository.findById(id);

        if (bookingFounded.isPresent()) {
            bookingRepository.deleteById(id);
        } else {
            throw NoResultsException.of(id);
        }
    }

}
