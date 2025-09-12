package com.equipo5.backend.model.mappers;

import com.equipo5.backend.model.ServiceEntity;
import com.equipo5.backend.model.dtos.request.ServiceEntityRequestDTO;
import com.equipo5.backend.model.dtos.response.services.ServiceEntityResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserEntityMapper.class, BookingMapper.class})
public interface ServiceEntityMapper {

    @Mapping(source = "idSitter", target = "sitters.id")
    ServiceEntity toService(ServiceEntityRequestDTO serviceDTO);

    @Mapping(source = "sitters", target = "owners")
    ServiceEntityResponseDTO toServiceDTO(ServiceEntity service);

    List<ServiceEntityResponseDTO> toServiceDTOs(List<ServiceEntity> serviceList);

    default Page<ServiceEntityResponseDTO> toServicesPagebleDTO(Page<ServiceEntity> pageable){
        List<ServiceEntityResponseDTO> dtoList = toServiceDTOs(pageable.getContent());
        return new PageImpl<>(dtoList, pageable.getPageable(), pageable.getTotalElements());
    }
}