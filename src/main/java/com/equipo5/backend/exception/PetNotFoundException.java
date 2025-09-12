package com.equipo5.backend.exception;

public class PetNotFoundException extends RuntimeException {

    public PetNotFoundException(Long petTd) {
        super("Pet not found with id: " + petTd);
    }

    public static PetNotFoundException of(Long petTd) {
        return new PetNotFoundException(petTd);
    }

}
