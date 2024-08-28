package com.dymometr.Dymometr.services.implementations;

import com.dymometr.Dymometr.domain.entity.SensorEntity;
import com.dymometr.Dymometr.domain.specification.SensorSpecifications;
import com.dymometr.Dymometr.repositories.SensorRepository;
import com.dymometr.Dymometr.services.interfaces.SensorService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SensorServiceImpl implements SensorService {
    private final SensorRepository sensorRepository;

    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public SensorEntity save(SensorEntity sensorEntity) {
        return sensorRepository.save(sensorEntity);
    }

    @Override
    public Optional<SensorEntity> findOne(Long sensorId) {
        return sensorRepository.findById(sensorId);
    }

    @Override
    public List<SensorEntity> findAll() {
        return new ArrayList<>(sensorRepository.findAll());
    }

    @Override
    public List<SensorEntity> getSensorBasedOnVoivodeshipAndTown(String voivodeship, String town) {
        Specification<SensorEntity> spec = Specification.where(null);

        if (voivodeship != null && !voivodeship.isEmpty())
            spec = spec.and(SensorSpecifications.hasVoivodeship(voivodeship));

        if (town != null && !town.isEmpty())
            spec = spec.and(SensorSpecifications.hasTown(town));

        return sensorRepository.findAll(spec);
    }

    @Override
    public SensorEntity partialUpdate(SensorEntity sensorEntity) {
        Optional<SensorEntity> foundSensor = sensorRepository.findById(sensorEntity.getSensorId());

        return foundSensor.map(existingSensor -> {
            Optional.ofNullable(sensorEntity.getSensorName()).ifPresent(existingSensor::setSensorName);
            Optional.ofNullable(sensorEntity.getSensorLocalization()).ifPresent(existingSensor::setSensorLocalization);
            Optional.ofNullable(sensorEntity.getSensorDataList()).ifPresent(existingSensor::setSensorDataList);

            return sensorRepository.save(existingSensor);
        }).orElseThrow(() -> new RuntimeException("Sensor does not exist"));
    }

    @Override
    public void deleteById(Long sensorId) {
        sensorRepository.deleteById(sensorId);
    }
}
