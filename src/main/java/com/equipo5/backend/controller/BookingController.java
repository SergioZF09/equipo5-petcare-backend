package com.equipo5.backend.controller;

import com.equipo5.backend.model.dtos.request.BookingRequestDTO;
import com.equipo5.backend.model.dtos.response.BookingResponseDTO;
import com.equipo5.backend.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bookings")
@AllArgsConstructor
@PreAuthorize("hasAnyAuthority('OWNER','ADMINISTRATOR')")
public class BookingController {

    private final BookingService bookingService;

    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Endpoint para crear una reserva")
    @PostMapping
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody @Valid BookingRequestDTO bookingRequestDTO) {
        BookingResponseDTO bookingResponseDTO = bookingService.createBooking(bookingRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(bookingResponseDTO);
    }

    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Endpoint para listar todas las reservas")
    @GetMapping
    public ResponseEntity<List<BookingResponseDTO>> listAllBookings() {
        List<BookingResponseDTO> bookingResponseDTOS = bookingService.listAllBookings();

        return ResponseEntity.status(HttpStatus.OK).body(bookingResponseDTOS);
    }

    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Endpoint para listar todas las reservas de un dueño por su id")
    @GetMapping("owner/{ownerId}")
    public ResponseEntity<List<BookingResponseDTO>> listBookingsByOwnerId(@PathVariable Long ownerId) {
        List<BookingResponseDTO> bookingsResponseDTO = bookingService.listBookingsByOwnerId(ownerId);

        return ResponseEntity.status(HttpStatus.OK).body(bookingsResponseDTO);
    }

    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Endpoint para cancelar/eliminar una reserva por su id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelBooking(@PathVariable Long id) {
        bookingService.cancelBooking(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
