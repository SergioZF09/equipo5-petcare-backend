package com.equipo5.backend.controller;

import com.equipo5.backend.exception.NoResultsException;
import com.equipo5.backend.model.dtos.request.ServiceEntityRequestDTO;
import com.equipo5.backend.model.dtos.response.services.ServiceEntityResponseDTO;
import com.equipo5.backend.service.SitterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*Auth:
POST /sitters/register - Registro de cuidador
POST /sitters/login - Login de cuidador
POST /sitters/verify - Verificación de token de cuidador
---------------------------------------------------------

GET /services/available - Obtener servicios disponibles ✅
GET /services/sitter/{sitterId} - Obtener servicios por cuidador✅
POST /services - Crear nuevo servicio✅
PUT /services/{id} - Actualizar servicio existente✅
DELETE /services/{id} - Eliminar servicio✅
*/
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('SITTER','ADMINISTRATOR')")
public class ServiceController {

    private final SitterService sitterService;

    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Endpoint para listar todos los servicios")
    @GetMapping("/available")
    public ResponseEntity<Page<ServiceEntityResponseDTO>> getServices(
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return new ResponseEntity<>(sitterService.getSittersDTO(pageable), HttpStatus.OK);
    }

    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Endpoint para listar un servicio por su id")
    @GetMapping("/sitter/{id}")
    public ResponseEntity<ServiceEntityResponseDTO> getService(@PathVariable Long id){
        return sitterService.getSitterById(id)
                .map(response -> new ResponseEntity<>(response, HttpStatus.OK))
                .orElseThrow(() -> new NoResultsException(id));
    }

    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Endpoint para crear un servicio")
    @PostMapping("/{id}")
    public ResponseEntity<ServiceEntityResponseDTO> createService(
            @PathVariable Long id, @RequestBody @Valid ServiceEntityRequestDTO serviceRequestDTO){
        return new ResponseEntity<>(sitterService.createSitter(id, serviceRequestDTO), HttpStatus.CREATED);
    }

    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Endpoint para actualizar un servicio por su id")
    @PutMapping("/{id}")
    public ResponseEntity<ServiceEntityResponseDTO> updateService(
            @PathVariable Long id, @RequestBody ServiceEntityRequestDTO serviceRequestDTO){
            return new ResponseEntity<>(sitterService.updateSitter(id, serviceRequestDTO)
                    .orElseThrow(() -> new NoResultsException(id)), HttpStatus.ACCEPTED);
    }

    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Endpoint para eliminar un servicio por su id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id){
        sitterService.deleteSitter(id);
        return ResponseEntity.ok().build();
    }

}
