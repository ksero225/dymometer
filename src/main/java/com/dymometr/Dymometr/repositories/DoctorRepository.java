package com.dymometr.Dymometr.repositories;

import com.dymometr.Dymometr.domain.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long>,
        PagingAndSortingRepository<DoctorEntity, Long>,
        JpaSpecificationExecutor<DoctorEntity> {
    boolean existsDoctorEntityByDoctorId(Long doctorId);

    @Query("SELECT DISTINCT d.doctorSpecialization FROM DoctorEntity d")
    List<String> findDistinctSpecializations();
}
