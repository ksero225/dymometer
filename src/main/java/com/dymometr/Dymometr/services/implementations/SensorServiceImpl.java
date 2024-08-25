package com.dymometr.Dymometr.services.implementations;

import com.dymometr.Dymometr.domain.entity.SensorEntity;
import com.dymometr.Dymometr.repositories.SensorRepository;
import com.dymometr.Dymometr.services.interfaces.SensorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public List<SensorEntity> findAll() {
        return new ArrayList<>(sensorRepository.findAll());
    }
}
