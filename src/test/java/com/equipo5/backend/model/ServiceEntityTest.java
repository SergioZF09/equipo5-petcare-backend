package com.equipo5.backend.model;

import com.equipo5.backend.model.enums.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceEntityTest {

    @Test
    void testServiceEntityFieldsAndRelations() {

        UserEntity user = new UserEntity();
        user.setName("John Doe");
        user.setEmail("john@example.com");
        user.setPassword("12345");
        user.setRol(Role.ADMINISTRATOR);

        Booking booking = new Booking();

        ServiceEntity service = new ServiceEntity();
        service.setRate(11.11);
        service.setDescription("test");
        service.setOwners(user);
        service.getBookings().add(booking);

        assertTrue(service.getBookings().contains(booking));
        assertEquals(service.getOwners(), user);
        assertEquals("test", service.getDescription());
        assertEquals(11.11, service.getRate());
    }

}