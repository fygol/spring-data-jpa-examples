package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.model.DspAttribute;

import java.util.List;

public interface DspAttributeMappingRepositoryCustom {
    List<String> findDspHavingAllAttributes(List<DspAttribute> attributes);
}
