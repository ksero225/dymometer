package com.dymometr.Dymometr.services.implementations;

import com.dymometr.Dymometr.domain.entity.SensorEntity;
import com.dymometr.Dymometr.repositories.SensorRepository;
import com.dymometr.Dymometr.services.interfaces.SensorService;
import org.springframework.stereotype.Service;

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
}
