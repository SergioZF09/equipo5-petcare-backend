package com.equipo5.backend.serviceImpl;

import com.equipo5.backend.exception.NoResultsException;
import com.equipo5.backend.model.ServiceEntity;
import com.equipo5.backend.model.UserEntity;
import com.equipo5.backend.model.dtos.request.ServiceEntityRequestDTO;
import com.equipo5.backend.model.dtos.response.services.ServiceEntityResponseDTO;
import com.equipo5.backend.model.mappers.ServiceEntityMapper;
import com.equipo5.backend.repository.ServiceRepository;
import com.equipo5.backend.repository.UserRepository;
import com.equipo5.backend.service.SitterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SitterServiceImpl implements SitterService {

    private final ServiceRepository serviceRepository;

    private final ServiceEntityMapper serviceMapper;

    private final UserRepository userRepository;

    @Override
    public Page<ServiceEntityResponseDTO> getSittersDTO(Pageable pageable) {
        return serviceMapper.toServicesPagebleDTO(serviceRepository.findAll(pageable));
    }

    @Override
    public Optional<ServiceEntityResponseDTO> getSitterById(Long id) {
        return Optional.ofNullable(serviceRepository.findById(id)
                .map(serviceMapper::toServiceDTO)
                .orElseThrow(() -> NoResultsException.of(id)));
    }

    @Override
    @Transactional
    public ServiceEntityResponseDTO createSitter(Long id, ServiceEntityRequestDTO sitterDTO) {
        UserEntity owners = userRepository.findById(id)
                .orElseThrow(() -> NoResultsException.of(id));

        ServiceEntity sitterService = serviceMapper.toService(sitterDTO);
        sitterService.setSitters(owners);

        return serviceMapper.toServiceDTO(serviceRepository.save(sitterService));
    }

    @Override
    @Transactional
    public Optional<ServiceEntityResponseDTO> updateSitter(Long id, ServiceEntityRequestDTO sitterDTO) {
        /*
        * todo: asegurarse con el contextHolder de spring security que solo los cuidadores asignados a
        *  su propio servicio puedan cambiarlo/actualizarlo
        * */

        ServiceEntity modifiedSitter = serviceRepository.findById(id)
                .orElseThrow(() -> NoResultsException.of(id));

        if (sitterDTO.type() != null){
            modifiedSitter.setType(sitterDTO.type());
        }

        if (sitterDTO.description() != null){
            modifiedSitter.setDescription(sitterDTO.description());
        }

        if (sitterDTO.rate() != null){
            modifiedSitter.setRate(sitterDTO.rate());
        }

        return Optional.of(serviceMapper.toServiceDTO(modifiedSitter));
    }

    @Override
    @Transactional
    public void deleteSitter(Long id) {
        if (serviceRepository.existsById(id)){
            serviceRepository.deleteById(id);
        }
        else {
            throw NoResultsException.of(id);
        }
    }
}
