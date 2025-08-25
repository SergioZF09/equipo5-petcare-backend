package com.equipo5.backend.model.mappers;

import com.equipo5.backend.model.ServiceEntity;
import com.equipo5.backend.model.dtos.request.ServiceEntityRequestDTO;
import com.equipo5.backend.model.dtos.response.ServiceEntityResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServiceEntityMapper {

    ServiceEntity toService(ServiceEntityRequestDTO serviceDTO);

    ServiceEntityResponseDTO toServiceDTO(ServiceEntity service);

    List<ServiceEntityResponseDTO> toServiceDTOs(List<ServiceEntity> serviceList);
}