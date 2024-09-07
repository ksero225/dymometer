package com.dymometr.Dymometr.mapper.implementations;

import com.dymometr.Dymometr.domain.dto.DoctorDto;
import com.dymometr.Dymometr.domain.entity.DoctorEntity;
import com.dymometr.Dymometr.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper implements Mapper<DoctorEntity, DoctorDto> {
    private final ModelMapper modelMapper;

    public DoctorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public DoctorDto mapTo(DoctorEntity doctorEntity) {
        return modelMapper.map(doctorEntity, DoctorDto.class);
    }

    @Override
    public DoctorEntity mapFrom(DoctorDto doctorDto) {
        return modelMapper.map(doctorDto, DoctorEntity.class);
    }
}
