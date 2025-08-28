package com.equipo5.backend.model;

import jakarta.validation.*;
import org.junit.jupiter.api.Test;
import com.equipo5.backend.model.enums.Role;

import java.time.Instant;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserEntityTest {

    @Test
    void testUserEntitySettersAndGetters() {
        UserEntity user = new UserEntity();
        user.setName("John Doe");
        user.setEmail("john@example.com");
        user.setPassword("12345");
        user.setAddress("Calle");
        user.setPhone("123123123");
        user.setAvatarUser("avatar user");
        user.setRol(Role.ADMINISTRATOR);

        assertEquals("John Doe", user.getName());
        assertEquals("john@example.com", user.getEmail());
        assertEquals("12345", user.getPassword());
        assertEquals(Role.ADMINISTRATOR, user.getRol());
    }

    //Test de manipulacion de Listas, no hay Persistencia ni Cascada
    @Test
    void testAddPetsServicesBookings() {
        UserEntity user = new UserEntity();

        Pet pet = new Pet();
        user.getPets().add(pet);
        assertTrue(user.getPets().contains(pet));

        ServiceEntity service = new ServiceEntity();
        user.getServices().add(service);
        assertTrue(user.getServices().contains(service));

        Booking booking = new Booking();
        user.getBookings().add(booking);
        assertTrue(user.getBookings().contains(booking));
    }

    @Test
    void testPrePersistSetsCreatedAndUpdated() {
        UserEntity user = new UserEntity();
        user.prePersist();

        assertNotNull(user.getCreatedAt());
        assertNotNull(user.getUpdatedAt());
        assertEquals(user.getCreatedAt(), user.getUpdatedAt());
    }

    @Test
    void testPreUpdateSetsUpdated() throws InterruptedException {
        UserEntity user = new UserEntity();
        user.prePersist();

        Instant beforeUpdate = user.getUpdatedAt();
        Thread.sleep(10); // asegurar que pasa un tiempo
        user.preUpdate();

        assertTrue(user.getUpdatedAt().isAfter(beforeUpdate));
    }

    // Validacion: debe fallar si no llamamos a los metodos prePersist y preUpdate
    @Test
    void testValidationFailsWithoutPrePersist() {
        UserEntity user = new UserEntity();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);

        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("createdAt")));
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("updatedAt")));
    }
}