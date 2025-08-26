package com.equipo5.backend.model;

import jakarta.validation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    @Test
    void testPetFieldsAndRelations() {
        // Crear objetos relacionados
        UserEntity owner = new UserEntity();

        // Crear lista de bookings
        List<Booking> bookings = new ArrayList<>();
        Booking booking1 = new Booking();
        Booking booking2 = new Booking();
        bookings.add(booking1);
        bookings.add(booking2);

        // Crear la entidad Pet y asignar campos
        Pet pet = new Pet();
        pet.setName("Fido");
        pet.setSpecies("Dog");
        pet.setBreed("Labrador");
        pet.setOwner(owner);
        pet.setBookings(bookings);

        // Assert campos simples
        assertEquals("Fido", pet.getName());
        assertEquals("Dog", pet.getSpecies());
        assertEquals("Labrador", pet.getBreed());

        // Assert relaciones
        assertEquals(owner, pet.getOwner());
        assertEquals(2, pet.getBookings().size());
        assertTrue(pet.getBookings().contains(booking1));
        assertTrue(pet.getBookings().contains(booking2));
    }

    // Este test demuestra que estamos permitiendo entidades con campos null dado que no hay validaciones!
    // Recomendable agregar a TODAS las entidades para evitar futuros errores de integridad.

    // Ejemplos:
    // @NotBlank(message = "Pet name cannot be blank")
    // @NotNull(message = "Pet must have an owner")
    // Esto Nos permite usar @Valid antes de persistir para verificas que este correcta.
    @Test
    void testPetValidation() {
        Pet pet = new Pet();
        pet.setName(""); // inválido
        pet.setSpecies(null); // inválido
        pet.setOwner(null); // inválido

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Pet>> violations = validator.validate(pet);

        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("name")));
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("species")));
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("owner")));
    }
}