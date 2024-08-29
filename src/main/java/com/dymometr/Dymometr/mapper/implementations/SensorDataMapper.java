package com.dymometr.Dymometr.mapper.implementations;

import com.dymometr.Dymometr.domain.dto.SensorDataDto;
import com.dymometr.Dymometr.domain.entity.SensorDataEntity;
import com.dymometr.Dymometr.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SensorDataMapper implements Mapper<SensorDataEntity, SensorDataDto> {

    private final ModelMapper modelMapper;

    public SensorDataMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public SensorDataDto mapTo(SensorDataEntity sensorDataEntity) {
        return modelMapper.map(sensorDataEntity, SensorDataDto.class);
    }

    @Override
    public SensorDataEntity mapFrom(SensorDataDto sensorDataDto) {
        return modelMapper.map(sensorDataDto, SensorDataEntity.class);
    }
}
