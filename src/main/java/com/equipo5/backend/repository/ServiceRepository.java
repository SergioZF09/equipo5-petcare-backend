package com.equipo5.backend.repository;

import com.equipo5.backend.model.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
    List<ServiceEntity> findBySittersId(Long sittersId);
}
