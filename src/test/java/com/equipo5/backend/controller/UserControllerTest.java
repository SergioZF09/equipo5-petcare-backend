package com.equipo5.backend.controller;

import com.equipo5.backend.model.UserEntity;
import com.equipo5.backend.model.dtos.request.UserRequestDTO;
import com.equipo5.backend.model.dtos.response.UserResponseDTO;
import com.equipo5.backend.model.enums.Role;
import com.equipo5.backend.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private UserEntity user;
    private UserRequestDTO fullRequest;
    private UserResponseDTO fullResponse;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Crear un usuario de ejemplo
        user = new UserEntity();
        user.setId(1L);

        // DTO de request completo
        fullRequest = new UserRequestDTO(
                "John Doe",
                "john@example.com",
                "pass",
                "123123",
                "address",
                "avatar"
        );

        // DTO de response completo
        fullResponse = new UserResponseDTO(
                1L,
                Role.ADMINISTRATOR,
                "John Doe",
                "john@example.com",
                "pass",
                "123123",
                "address",
                "avatar",
                List.of(), // pets
                List.of(), // services
                List.of()  // bookings
        );
    }

    @Test
    void createUser_ShouldReturnCreatedResponse() {
        when(userService.createUser(fullRequest)).thenReturn(1L);
        when(userService.readUser(1L)).thenReturn(fullResponse);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance();
        ResponseEntity<UserResponseDTO> response = userController.createUser(fullRequest, uriBuilder);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals(fullResponse, response.getBody());
        assertEquals(URI.create("/api/v3/users/1"), response.getHeaders().getLocation());

        verify(userService, times(1)).createUser(fullRequest);
        verify(userService, times(1)).readUser(1L);
    }

    @Test
    void read_ShouldReturnUser() {
        when(userService.readUser(1L)).thenReturn(fullResponse);

        ResponseEntity<UserResponseDTO> response = userController.read(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(fullResponse, response.getBody());
        verify(userService, times(1)).readUser(1L);
    }

    @Test
    void update_ShouldReturnNoContent() {
        ResponseEntity<Void> response = userController.update(fullRequest, 1L);

        assertEquals(204, response.getStatusCodeValue());
        verify(userService, times(1)).updateUser(fullRequest, 1L);
    }

    @Test
    void readAll_ShouldReturnPagedUsers() {
        UserResponseDTO user1 = fullResponse;
        UserResponseDTO user2 = new UserResponseDTO(
                2L,
                Role.ADMINISTRATOR,
                "Jane Doe",
                "jane@example.com",
                "pass2",
                "456456",
                "address2",
                "avatar2",
                List.of(),
                List.of(),
                List.of()
        );

        Page<UserResponseDTO> page = new PageImpl<>(List.of(user1, user2));
        when(userService.readAll(ArgumentMatchers.any(Pageable.class))).thenReturn(page);

        ResponseEntity<Page<UserResponseDTO>> response = userController.readAll(Pageable.unpaged());

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().getContent().size());
        verify(userService, times(1)).readAll(ArgumentMatchers.any(Pageable.class));
    }

    @Test
    void delete_ShouldReturnNoContent() {
        ResponseEntity<Void> response = userController.delete(1L);

        assertEquals(204, response.getStatusCodeValue());
        verify(userService, times(1)).deleteUser(1L);
    }
}
