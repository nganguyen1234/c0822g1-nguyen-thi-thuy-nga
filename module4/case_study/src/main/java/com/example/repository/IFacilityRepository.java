package com.example.repository;

import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    Page<Facility> findByNameAndAndFacilityType(String name, Integer facilityTypeId, Pageable pageable);

    Page<Facility> findByName(String name,Pageable pageable);
}
