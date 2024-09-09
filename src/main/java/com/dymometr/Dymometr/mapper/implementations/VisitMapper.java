package com.dymometr.Dymometr.mapper.implementations;

import com.dymometr.Dymometr.domain.dto.VisitDto;
import com.dymometr.Dymometr.domain.entity.VisitEntity;
import com.dymometr.Dymometr.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VisitMapper implements Mapper<VisitEntity, VisitDto> {
    private final ModelMapper modelMapper;

    public VisitMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public VisitDto mapTo(VisitEntity visitEntity) {
        return modelMapper.map(visitEntity, VisitDto.class);
    }

    @Override
    public VisitEntity mapFrom(VisitDto visitDto) {
        return modelMapper.map(visitDto, VisitEntity.class);
    }
}
