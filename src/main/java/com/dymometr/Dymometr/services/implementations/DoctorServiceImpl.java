package com.dymometr.Dymometr.services.implementations;

import com.dymometr.Dymometr.domain.entity.DoctorEntity;
import com.dymometr.Dymometr.repositories.DoctorRepository;
import com.dymometr.Dymometr.services.interfaces.DoctorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Page<DoctorEntity> findAll(Pageable pageable) {
        return doctorRepository.findAll(pageable);
    }
}
