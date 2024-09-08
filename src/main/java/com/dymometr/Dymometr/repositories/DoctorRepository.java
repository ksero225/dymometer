package com.dymometr.Dymometr.repositories;

import com.dymometr.Dymometr.domain.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long>,
        PagingAndSortingRepository<DoctorEntity, Long>,
        JpaSpecificationExecutor<DoctorEntity> {
}
