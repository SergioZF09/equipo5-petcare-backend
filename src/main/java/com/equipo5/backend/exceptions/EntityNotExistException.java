package com.equipo5.backend.exceptions;

public class EntityNotExistException extends RuntimeException{
    public EntityNotExistException(String message) {
        super(message);
    }
}
