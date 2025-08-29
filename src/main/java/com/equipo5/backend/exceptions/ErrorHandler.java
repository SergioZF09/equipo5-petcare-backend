package com.equipo5.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotExistException.class)
    public ResponseEntity<DataEntityNotExist> entityNotExistHandler(EntityNotExistException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DataEntityNotExist(e.getMessage()));
    }

    private record DataEntityNotExist(String mensaje) {}

}
