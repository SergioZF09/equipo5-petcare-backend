package com.equipo5.backend.exception;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String email) {
        super("Email already exists: %s".formatted(email));
    }

    public static EmailAlreadyExistsException of(String email) {
        return new EmailAlreadyExistsException(email);
    }
}