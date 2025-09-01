package com.equipo5.backend.exception;

public class NoResultsException extends RuntimeException {

    public NoResultsException(Long id) {
        super("No results for: %s".formatted(id));
    }

    public static NoResultsException of(Long id) {
        return new NoResultsException(id);
    }
}