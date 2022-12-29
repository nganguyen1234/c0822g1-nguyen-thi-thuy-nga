package com.example.service;

import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {
    Page<Facility> searchName(String name, Pageable pageable);
    Page<Facility> searchNameAndFacilityType(String name,Integer typeId,Pageable pageable);
}
