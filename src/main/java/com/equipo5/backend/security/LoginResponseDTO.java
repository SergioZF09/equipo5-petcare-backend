package com.equipo5.backend.security;

import com.equipo5.backend.model.dtos.response.user.UserResponseDTO;

public record LoginResponseDTO(String token, UserResponseDTO user) {}