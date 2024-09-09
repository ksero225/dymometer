package com.dymometr.Dymometr.services.interfaces;

import com.dymometr.Dymometr.domain.entity.DoctorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DoctorService {
    Page<DoctorEntity> findAll(Pageable pageable, String doctorName, String doctorSpecialization, String doctorTown);

    Optional<DoctorEntity> existsById(Long doctorId);
}
