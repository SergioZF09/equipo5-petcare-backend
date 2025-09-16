package com.equipo5.backend.controller;

import com.equipo5.backend.model.dtos.request.BookingRequestDTO;
import com.equipo5.backend.model.dtos.response.BookingResponseDTO;
import com.equipo5.backend.service.BookingService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@AllArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody @Valid BookingRequestDTO bookingRequestDTO) {
        BookingResponseDTO bookingResponseDTO = bookingService.createBooking(bookingRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(bookingResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<BookingResponseDTO>> listAllBookings() {
        List<BookingResponseDTO> bookingResponseDTOS = bookingService.listAllBookings();

        return ResponseEntity.status(HttpStatus.OK).body(bookingResponseDTOS);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelBooking(@PathVariable Long id) {
        bookingService.cancelBooking(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
