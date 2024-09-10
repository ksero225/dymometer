package com.dymometr.Dymometr.services.implementations;

import com.dymometr.Dymometr.domain.entity.DoctorEntity;
import com.dymometr.Dymometr.domain.specification.DoctorSpecifications;
import com.dymometr.Dymometr.repositories.DoctorRepository;
import com.dymometr.Dymometr.services.interfaces.DoctorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<String> findAllSpecializations() {
        return doctorRepository.findDistinctSpecializations();
    }

    @Override
    public Page<DoctorEntity> findAll(Pageable pageable, String doctorName, String doctorSpecialization, String doctorTown) {
        Specification<DoctorEntity> spec = Specification.where(null);

        if (doctorName != null && !doctorName.isEmpty()) {
            spec = spec.and(DoctorSpecifications.hasDoctorName(doctorName));
        }
        if (doctorSpecialization != null && !doctorSpecialization.isEmpty()) {
            spec = spec.and(DoctorSpecifications.hasDoctorSpecialization(doctorSpecialization));
        }
        if (doctorTown != null && !doctorTown.isEmpty()) {
            spec = spec.and(DoctorSpecifications.hasDoctorTown(doctorTown));
        }

        return doctorRepository.findAll(spec, pageable);
    }

    @Override
    public Optional<DoctorEntity> existsById(Long doctorId) {
        return doctorRepository.findById(doctorId);
    }
}
