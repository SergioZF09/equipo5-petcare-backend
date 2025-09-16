package com.equipo5.backend.model.enums;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum Role {
    OWNER,
    SITTER,
    ADMINISTRATOR;

    @JsonCreator
    public static Role fromString(String key) {
        if (key == null) throw new IllegalArgumentException("ROL cannot be Null");
        try {
            return Role.valueOf(key.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid ROL: " + key);
        }
    }
}
