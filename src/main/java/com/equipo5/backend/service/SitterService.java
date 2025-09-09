package com.equipo5.backend.service;

import com.equipo5.backend.model.dtos.request.ServiceEntityRequestDTO;
import com.equipo5.backend.model.dtos.response.services.ServiceEntityResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface SitterService {

    Page<ServiceEntityResponseDTO> getSittersDTO(Pageable pageable);

    Optional<ServiceEntityResponseDTO> getSitterById(Long id);

    ServiceEntityResponseDTO createSitter(Long id, ServiceEntityRequestDTO SitterDTO);

    Optional<ServiceEntityResponseDTO> updateSitter(Long id, ServiceEntityRequestDTO SitterDTO);

    void deleteSitter(Long id);

}
