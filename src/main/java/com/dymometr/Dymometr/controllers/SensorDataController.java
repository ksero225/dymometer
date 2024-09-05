package com.dymometr.Dymometr.controllers;

import com.dymometr.Dymometr.domain.dto.SensorDataDto;
import com.dymometr.Dymometr.domain.entity.SensorDataEntity;
import com.dymometr.Dymometr.domain.entity.SensorEntity;
import com.dymometr.Dymometr.mapper.Mapper;
import com.dymometr.Dymometr.services.interfaces.SensorDataService;
import com.dymometr.Dymometr.services.interfaces.SensorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class SensorDataController {
    private final SensorDataService sensorDataService;
    private final SensorService sensorService;
    private final Mapper<SensorDataEntity, SensorDataDto> sensorDataMapper;

    public SensorDataController(SensorDataService sensorDataService, SensorService sensorService, Mapper<SensorDataEntity, SensorDataDto> sensorDataMapper) {
        this.sensorDataService = sensorDataService;
        this.sensorService = sensorService;
        this.sensorDataMapper = sensorDataMapper;
    }

    @PostMapping(path = "/sensorData")
    public ResponseEntity<SensorDataDto> createSensorData(@RequestBody SensorDataDto sensorDataDto, @RequestParam("sensorId") Long sensorId) {

        Optional<SensorEntity> foundSensorEntity = sensorService.findOne(sensorId);

        if (foundSensorEntity.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Sensor not found"
            );
        }

        sensorDataDto.setSensor(foundSensorEntity.get());

        SensorDataEntity sensorDataEntity = sensorDataMapper.mapFrom(sensorDataDto);

        SensorDataEntity savedSensorDataEntity = sensorDataService.save(sensorDataEntity);

        return new ResponseEntity<>(
                sensorDataMapper.mapTo(savedSensorDataEntity),
                HttpStatus.CREATED
        );
    }
}
