package com.dymometr.Dymometr.controllers;

import com.dymometr.Dymometr.domain.dto.SensorDto;
import com.dymometr.Dymometr.domain.entity.SensorDataEntity;
import com.dymometr.Dymometr.domain.entity.SensorEntity;
import com.dymometr.Dymometr.mapper.Mapper;
import com.dymometr.Dymometr.services.interfaces.SensorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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

    @GetMapping(path = "/sensor/{sensorId}")
    public ResponseEntity<SensorDto> getOneSensor(@PathVariable("sensorId") Long sensorId) {
        Optional<SensorEntity> foundSensor = sensorService.findOne(sensorId);

        return foundSensor.map(SensorEntity -> {
            Optional<SensorDataEntity> foundSensorLatestData = sensorService.getSensorLatestData(sensorId);
            SensorDto sensorDto = sensorMapper.mapTo(SensorEntity);
            foundSensorLatestData.ifPresent(sensorDto::setLastSensorData);
            return new ResponseEntity<>(
                    sensorDto,
                    HttpStatus.OK
            );
        }).orElse(
                new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    }

    //todo change it to pageable

    @GetMapping(path = "/sensor")
    public List<SensorDto> filterSensor(
            @RequestParam(value = "voivodeship", required = false) String voivodeship,
            @RequestParam(value = "town", required = false) String town
    ) {
        List<SensorEntity> foundSensorEntities = sensorService.getSensorBasedOnVoivodeshipAndTown(voivodeship, town);
        foundSensorEntities.forEach(SensorEntity -> {
            Optional<SensorDataEntity> foundSensorLatestData = sensorService.getSensorLatestData(SensorEntity.getSensorId());
            foundSensorLatestData.ifPresent(SensorEntity::setLastSensorData);
        });

        return foundSensorEntities.stream()
                .map(sensorMapper::mapTo)
                .collect(Collectors.toList());
    }


    @PutMapping(path = "/sensor/{sensorId}")
    public ResponseEntity<SensorDto> fullUpdateSensor(
            @PathVariable("sensorId") Long sensorId,
            @RequestBody SensorDto sensorDto
    ) {
        Optional<SensorEntity> foundSensor = sensorService.findOne(sensorId);

        if (foundSensor.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        SensorEntity sensorEntity = sensorMapper.mapFrom(sensorDto);
        sensorEntity.setSensorId(sensorId);
        SensorEntity savedSensorEntity = sensorService.save(sensorEntity);

        return new ResponseEntity<>(
                sensorMapper.mapTo(savedSensorEntity),
                HttpStatus.OK
        );
    }

    @PatchMapping(path = "/sensor/{sensorId}")
    public ResponseEntity<SensorDto> partialUpdateSensor(
            @PathVariable("sensorId") Long sensorId,
            @RequestBody SensorDto sensorDto
    ) {
        Optional<SensorEntity> foundSensor = sensorService.findOne(sensorId);

        if (foundSensor.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        SensorEntity sensorEntity = sensorMapper.mapFrom(sensorDto);
        sensorEntity.setSensorId(sensorId);
        SensorEntity savedSensorEntity = sensorService.partialUpdate(sensorEntity);

        return new ResponseEntity<>(
                sensorMapper.mapTo(savedSensorEntity),
                HttpStatus.OK
        );
    }

    @DeleteMapping(path = "/sensor/{sensorId}")
    public ResponseEntity<Void> deleteSensor(@PathVariable("sensorId") Long sensorId) {
        sensorService.deleteById(sensorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
