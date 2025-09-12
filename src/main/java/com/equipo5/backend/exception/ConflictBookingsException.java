package com.equipo5.backend.exception;

public class ConflictBookingsException extends RuntimeException {
    public ConflictBookingsException(String message) {
        super(message);
    }

    public static ConflictBookingsException of(String message) {
        return new ConflictBookingsException(message);
    }
}
