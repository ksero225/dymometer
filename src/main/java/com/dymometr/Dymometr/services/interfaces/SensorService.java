package com.dymometr.Dymometr.services.interfaces;

import com.dymometr.Dymometr.domain.entity.SensorDataEntity;
import com.dymometr.Dymometr.domain.entity.SensorEntity;

import java.util.List;
import java.util.Optional;

public interface SensorService {
    SensorEntity save(SensorEntity sensorEntity);

    List<SensorEntity> findAll();

    Optional<SensorEntity> findOne(Long sensorId);

    SensorEntity partialUpdate(SensorEntity sensorEntity);

    void deleteById(Long sensorId);

    List<SensorEntity> getSensorBasedOnVoivodeshipAndTown(String voivodeship, String town);

    Optional<SensorDataEntity> getSensorLatestData(Long sensorId);
}
