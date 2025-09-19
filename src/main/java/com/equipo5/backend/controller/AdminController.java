package com.equipo5.backend.controller;

import com.equipo5.backend.model.dtos.response.BookingResponseDTO;
import com.equipo5.backend.model.dtos.response.user.UserResponseDTO;
import com.equipo5.backend.model.dtos.response.services.ServiceEntityResponseDTO;
import com.equipo5.backend.service.BookingService;
import com.equipo5.backend.service.SitterService;
import com.equipo5.backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMINISTRATOR')")
public class AdminController {

    private final UserService userService;
    private final BookingService bookingService;
    private final SitterService sitterService;

    // FALTA IMPLEMENTAR SEGURIDAD :S
    //private final AuthenticationManager authenticationManager;
    //private final JWTTokenService tokenService;

    //GET /admin/users → Obtener todos los usuarios
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Endpoint para listar todos los usuarios")
    @GetMapping("/users")
    public ResponseEntity<Page<UserResponseDTO>> getAllUsers(
            @PageableDefault(size = 10, sort = "name") Pageable pageable) {
        log.info("READ ALL -> Users");
        return ResponseEntity.ok(userService.readAll(pageable));
    }

    //GET /admin/users/id → Obtener un usuario
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Endpoint para listar un usuario por su id")
    @GetMapping(path = "/users/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable("id") Long id) {
        log.info("READ -> User ID: {}", id);
        return ResponseEntity.ok(userService.readUser(id));
    }

    //GET /admin/services → Obtener todos los servicios
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Endpoint para listar todos los servicios")
    @GetMapping("/services")
    public ResponseEntity<Page<ServiceEntityResponseDTO>> getAllServices(
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        log.info("READ ALL -> Services");
        return ResponseEntity.ok(sitterService.getSittersDTO(pageable));
    }

    //GET /admin/bookings → Obtener todas las reservas
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Endpoint para listar todas las reservas")
    @GetMapping("/bookings")
    public ResponseEntity<List<BookingResponseDTO> > getAllBookings() {
        log.info("READ ALL -> Bookings [List]");
        List<BookingResponseDTO> bookings = bookingService.listAllBookings();
        return ResponseEntity.ok(bookings);
    }

    //PUT /admin/users/:userId/block → Bloquear usuario
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Endpoint para bloquear un usuario por su id")
    @PutMapping("/users/{id}/block")
    public ResponseEntity<String> blockUser(@PathVariable Long id) {
        return ResponseEntity.ok("User " + id + " blocked (stub)");
    }

    //PUT /admin/users/:userId/unblock → Desbloquear usuario
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Endpoint para desbloquear un usuario por su id")
    @PutMapping("/users/{id}/unblock")
    public ResponseEntity<String> unblockUser(@PathVariable Long id) {
        return ResponseEntity.ok("User " + id + " unblocked (stub)");
    }

}