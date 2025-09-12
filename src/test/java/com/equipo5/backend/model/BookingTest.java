package com.equipo5.backend.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

    @Test
    void testBookingFieldsAndRelations() {

        UserEntity user = new UserEntity();
        Pet pet = new Pet();
        ServiceEntity service = new ServiceEntity();

        Booking booking = new Booking();
        booking.setStartTime(LocalDateTime.of(2025, 8, 26, 12, 00));
        booking.setEndTime(LocalDateTime.of(2025, 8, 27, 12, 00));
        booking.setStatus(true);

        booking.setOwners(user);
        booking.setPets(pet);
        booking.setServices(service);

        assertEquals(LocalDate.of(2025, 8, 26), booking.getStartTime());
        assertEquals(LocalDate.of(2025, 8, 27), booking.getEndTime());
        assertTrue(booking.getStatus());

        assertEquals(user, booking.getOwners());
        assertEquals(pet, booking.getPets());
        assertEquals(service, booking.getServices());
    }

}