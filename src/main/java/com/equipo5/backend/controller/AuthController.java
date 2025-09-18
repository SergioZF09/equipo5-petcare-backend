package com.equipo5.backend.controller;

import com.equipo5.backend.model.dtos.request.user.UserLoginDto;
import com.equipo5.backend.model.dtos.request.user.UserRequestDTO;
import com.equipo5.backend.model.dtos.response.user.UserResponseDTO;
import com.equipo5.backend.model.enums.Role;
import com.equipo5.backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping
@AllArgsConstructor
@Slf4j
public class AuthController {

    // Recibe: LOGIN, REGISTER, VERIFY
    // Para: ADMIN, SITTER Y OWNER

    private final UserService userService;

    // FALTA IMPLEMENTAR SEGURIDAD :S
    //private final AuthenticationManager authenticationManager;
    //private final JWTTokenService tokenService;
    @Operation(summary = "Endpoint para registrar un cuidador")
    @PostMapping("/sitters/register")
    public ResponseEntity<UserResponseDTO> registerSitter(@RequestBody @Valid UserRequestDTO request, UriComponentsBuilder uriBuilder) {
        return registerUser(request, uriBuilder, Role.SITTER);
    }

    @Operation(summary = "Endpoint para registrar un dueño")
    @PostMapping("/owners/register")
    public ResponseEntity<UserResponseDTO> registerOwner(@RequestBody @Valid UserRequestDTO request, UriComponentsBuilder uriBuilder) {
        return registerUser(request, uriBuilder, Role.OWNER);
    }

    @Operation(summary = "Endpoint para registrar un administrador")
    @PostMapping("/admin/register")
    public ResponseEntity<UserResponseDTO> registerAdmin(@RequestBody @Valid UserRequestDTO request, UriComponentsBuilder uriBuilder) {
        return registerUser(request, uriBuilder, Role.ADMINISTRATOR);
    }

    private ResponseEntity<UserResponseDTO> registerUser(UserRequestDTO request, UriComponentsBuilder uriBuilder, Role expectedRole) {
        log.info("CREATE -> New User: {}", request);
        if (!request.role().equals(expectedRole)) throw new IllegalArgumentException("Invalid ROL at this endpoint.");

        Long id = userService.createUser(request);
        UserResponseDTO dto = userService.readUser(id);
        URI location = uriBuilder.path("/users/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(location).body(dto);
    }

    @Operation(summary = "Endpoint para iniciar sesión ya sea un cuidador, dueño o administrador")
    @PostMapping({"/sitters/login", "/owners/login", "/admin/login"})
    public ResponseEntity<UserResponseDTO> login(@RequestBody @Valid UserLoginDto request) {
        // DEBERIA DEVOVLER TokenResponseDto usando USER DETAILS

        //Authentication authToken = new UsernamePasswordAuthenticationToken(request.username(),
        //        request.password());
        //var usuarioAutenticado = authenticationManager.authenticate(authToken);
        //var JWTtoken = tokenService.createToken((User) usuarioAutenticado.getPrincipal());
        //return ResponseEntity.ok(new JWTTokenDto(JWTtoken));
        log.info("LOGIN -> User EMAIL: {}", request.email());
        UserResponseDTO userDto = userService.readUser(request.email());
        return ResponseEntity.ok(userDto);
    }

    @Operation(summary = "Endpoint para verificar el token ya sea un cuidador, dueño o administrador")
    @PostMapping({"/sitters/verify", "/owners/verify", "/admin/verify"})
    //@PreAuthorize("isAuthenticated()")
    //@SecurityRequirement(name = "bearer-key")
    public ResponseEntity<String> verify() {
        return ResponseEntity.ok("Token verified (stub)");
    }

}
