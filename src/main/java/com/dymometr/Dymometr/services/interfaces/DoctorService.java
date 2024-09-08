package com.dymometr.Dymometr.services.interfaces;

import com.dymometr.Dymometr.domain.entity.DoctorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DoctorService {
    Page<DoctorEntity> findAll(Pageable pageable, String doctorName, String doctorSpecialization, String doctorTown);
}
