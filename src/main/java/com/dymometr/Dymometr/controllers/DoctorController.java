package com.dymometr.Dymometr.controllers;

import com.dymometr.Dymometr.domain.dto.DoctorDto;
import com.dymometr.Dymometr.domain.entity.DoctorEntity;
import com.dymometr.Dymometr.mapper.Mapper;
import com.dymometr.Dymometr.services.interfaces.DoctorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
    private final DoctorService doctorService;
    private final Mapper<DoctorEntity, DoctorDto> doctorMapper;

    public DoctorController(DoctorService doctorService, Mapper<DoctorEntity, DoctorDto> doctorMapper) {
        this.doctorService = doctorService;
        this.doctorMapper = doctorMapper;
    }

    @GetMapping(path = "/doctors")
    public Page<DoctorDto> getListOfDoctors(
            Pageable pageable,
            @RequestParam(value = "doctorName", required = false) String doctorName,
            @RequestParam(value = "doctorSpecialization", required = false) String doctorSpecialization,
            @RequestParam(value = "doctorTown", required = false) String doctorTown
    ) {

        Page<DoctorEntity> listOfDoctors = doctorService.findAll(pageable, doctorName, doctorSpecialization, doctorTown);
        return listOfDoctors.map(doctorMapper::mapTo);
    }
}
