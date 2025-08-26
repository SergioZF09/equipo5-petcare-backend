package com.equipo5.backend.model.dtos;

import com.equipo5.backend.model.dtos.request.UserRequestDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import jakarta.validation.*;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class UserRequestDTOTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void shouldPassValidationWhenAllFieldsAreValid() {
        var dto = new UserRequestDTO("John", "john@mail.com", "secret");
        Set<ConstraintViolation<UserRequestDTO>> violations = validator.validate(dto);
        assertThat(violations).isEmpty();
    }

    @Test
    void shouldFailValidationWhenNameIsBlank() {
        var dto = new UserRequestDTO(" ", "john@mail.com", "secret");
        Set<ConstraintViolation<UserRequestDTO>> violations = validator.validate(dto);
        assertThat(violations).extracting("message")
                .contains("Incomplete attribute: 'name'");
    }

    @Test
    void shouldFailValidationWhenEmailIsBlank() {
        var dto = new UserRequestDTO("John", "", "secret");
        Set<ConstraintViolation<UserRequestDTO>> violations = validator.validate(dto);
        assertThat(violations).extracting("message")
                .contains("Incomplete attribute: 'email'");
    }

    @Test
    void shouldFailValidationWhenPasswordIsBlank() {
        var dto = new UserRequestDTO("John", "john@mail.com", " ");
        Set<ConstraintViolation<UserRequestDTO>> violations = validator.validate(dto);
        assertThat(violations).extracting("message")
                .contains("Incomplete attribute: 'password'");
    }

    @Test
    void shouldFailValidationWhenAnyFieldIsNull() {
        var dto1 = new UserRequestDTO("John", "john@mail.com", null);
        var dto2 = new UserRequestDTO("John", null, "123");
        var dto3 = new UserRequestDTO(null, "john@mail.com", "123");
        Set<ConstraintViolation<UserRequestDTO>> violations1 = validator.validate(dto1);
        Set<ConstraintViolation<UserRequestDTO>> violations2 = validator.validate(dto2);
        Set<ConstraintViolation<UserRequestDTO>> violations3 = validator.validate(dto3);
        assertThat(violations1).extracting("message")
                .contains("Incomplete attribute: 'password'");
        assertThat(violations2).extracting("message")
                .contains("Incomplete attribute: 'email'");
        assertThat(violations3).extracting("message")
                .contains("Incomplete attribute: 'name'");
    }

    @Test
    void shouldCreateUserRequestDTO() {
        // Arrange
        String name = "John Doe";
        String email = "john.doe@example.com";
        String password = "secret123";

        // Act
        UserRequestDTO dto = new UserRequestDTO(name, email, password);

        // Assert
        assertThat(dto.name()).isEqualTo(name);
        assertThat(dto.email()).isEqualTo(email);
        assertThat(dto.password()).isEqualTo(password);
    }

    @Test
    void shouldCompareDTOsByValues() {
        UserRequestDTO dto1 = new UserRequestDTO("Jane", "jane@example.com", "pass");
        UserRequestDTO dto2 = new UserRequestDTO("Jane", "jane@example.com", "pass");

        assertThat(dto1).isEqualTo(dto2);
        assertThat(dto1.hashCode()).isEqualTo(dto2.hashCode());
    }

    @Test
    void shouldGenerateToString() {
        UserRequestDTO dto = new UserRequestDTO("Alice", "alice@example.com", "pass");

        String result = dto.toString();

        assertThat(result).contains("Alice");
        assertThat(result).contains("alice@example.com");
    }
}