package com.dymometr.Dymometr.services.interfaces;

import com.dymometr.Dymometr.domain.entity.SensorEntity;

import java.util.List;

public interface SensorService {
    SensorEntity save(SensorEntity sensorEntity);

    List<SensorEntity> findAll();
}
