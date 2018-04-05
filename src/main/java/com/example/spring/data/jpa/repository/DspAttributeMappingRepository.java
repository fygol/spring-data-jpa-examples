package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.model.DspAttributeMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DspAttributeMappingRepository
        extends JpaRepository<DspAttributeMapping, Integer>,
        JpaSpecificationExecutor,
        DspAttributeMappingRepositoryCustom {
}
