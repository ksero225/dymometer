package com.dymometr.Dymometr.mapper.implementations;

import com.dymometr.Dymometr.mapper.Mapper;
import com.dymometr.Dymometr.domain.dto.SensorDto;
import com.dymometr.Dymometr.domain.entity.SensorEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SensorMapper implements Mapper<SensorEntity, SensorDto> {
    private final ModelMapper modelMapper;

    public SensorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public SensorDto mapTo(SensorEntity sensorEntity) {
        return modelMapper.map(sensorEntity, SensorDto.class);
    }

    @Override
    public SensorEntity mapFrom(SensorDto sensorDto) {
        return modelMapper.map(sensorDto, SensorEntity.class);
    }
}
