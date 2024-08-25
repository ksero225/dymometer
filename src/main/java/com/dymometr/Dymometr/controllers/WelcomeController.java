package com.dymometr.Dymometr.controllers;

import com.dymometr.Dymometr.domain.dto.SensorDto;
import com.dymometr.Dymometr.domain.entity.SensorEntity;
import com.dymometr.Dymometr.mapper.Mapper;
import com.dymometr.Dymometr.services.interfaces.SensorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    private final SensorService sensorService;
    private final Mapper<SensorEntity, SensorDto> sensorMapper;

    public WelcomeController(SensorService sensorService, Mapper<SensorEntity, SensorDto> sensorMapper) {
        this.sensorService = sensorService;
        this.sensorMapper = sensorMapper;
    }

    //Ping controller
    @GetMapping(path = "/")
    public String ping(){
        return "You are connected to API";
    }
}
