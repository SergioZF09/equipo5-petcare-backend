package com.equipo5.backend.controller;

import java.net.URI;

import com.equipo5.backend.model.dtos.request.UserRequestDTO;
import com.equipo5.backend.model.dtos.response.UserResponseDTO;
import com.equipo5.backend.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v3/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO request, UriComponentsBuilder uriBuilder) {
        log.info("CREATE -> New User: {}", request);
        Long id = userService.createUser(request);
        URI location = uriBuilder
                .path("/api/v3/users/{id}")
                .buildAndExpand(id)
                .toUri();

        UserResponseDTO dto = userService.readUser(id);
        // Devolver DTO en body + Location en header
        return ResponseEntity
                .created(location)
                .body(dto);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponseDTO> read(@PathVariable("id") Long id) {
        log.info("READ -> User ID: {}", id);
        return ResponseEntity.ok(userService.readUser(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> update(
            @RequestBody @Valid UserRequestDTO request,
            @PathVariable("id") Long id)
    {
        log.info("UPDATE -> User ID: {}, Data: {}", id, request);
        userService.updateUser(request, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<Page<UserResponseDTO>> readAll(
            @PageableDefault(size = 10, sort = "name") Pageable pageable) {
        log.info("READ ALL -> Users");
        return ResponseEntity.ok(userService.readAll(pageable));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        log.info("DELETE -> User ID: {}", id);
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
