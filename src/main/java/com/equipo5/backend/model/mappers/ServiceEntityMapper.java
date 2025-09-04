package com.equipo5.backend.model.mappers;

import com.equipo5.backend.model.ServiceEntity;
import com.equipo5.backend.model.dtos.request.ServiceEntityRequestDTO;
import com.equipo5.backend.model.dtos.response.ServiceEntityResponseDTO;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServiceEntityMapper {

    ServiceEntity toService(ServiceEntityRequestDTO serviceDTO);

    ServiceEntityResponseDTO toServiceDTO(ServiceEntity service);

    List<ServiceEntityResponseDTO> toServiceDTOs(List<ServiceEntity> serviceList);

    default Page<ServiceEntityResponseDTO> toServicesPagebleDTO(Page<ServiceEntity> pageable){
        List<ServiceEntityResponseDTO> dtoList = toServiceDTOs(pageable.getContent());
        return new PageImpl<>(dtoList, pageable.getPageable(), pageable.getTotalElements());
    }
}