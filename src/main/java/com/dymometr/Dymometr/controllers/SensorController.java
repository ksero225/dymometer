package com.dymometr.Dymometr.controllers;

import com.dymometr.Dymometr.domain.dto.SensorDto;
import com.dymometr.Dymometr.domain.entity.SensorEntity;
import com.dymometr.Dymometr.mapper.Mapper;
import com.dymometr.Dymometr.services.interfaces.SensorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SensorController {
    private final SensorService sensorService;
    private final Mapper<SensorEntity, SensorDto> sensorMapper;

    public SensorController(SensorService sensorService, Mapper<SensorEntity, SensorDto> sensorMapper) {
        this.sensorService = sensorService;
        this.sensorMapper = sensorMapper;
    }

    @PostMapping(path = "/sensor")
    public ResponseEntity<SensorDto> createSensor(@RequestBody SensorDto sensorDto) {
        SensorEntity sensorEntity = sensorMapper.mapFrom(sensorDto);

        SensorEntity savedSensorEntity = sensorService.save(sensorEntity);

        return new ResponseEntity<>(
                sensorMapper.mapTo(savedSensorEntity),
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "/sensor")
    public List<SensorDto> listSensor(){
        List<SensorEntity> sensorEntityList = sensorService.findAll();
        //todo check if list is empty

        return sensorEntityList.stream().map(sensorMapper::mapTo).collect(Collectors.toList());
    }
}
