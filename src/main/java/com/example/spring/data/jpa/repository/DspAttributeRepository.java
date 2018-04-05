package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.model.DspAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DspAttributeRepository extends JpaRepository<DspAttribute, Long>, JpaSpecificationExecutor {
}
