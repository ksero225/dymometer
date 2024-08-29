package com.dymometr.Dymometr.services.implementations;


import com.dymometr.Dymometr.domain.entity.SensorDataEntity;
import com.dymometr.Dymometr.repositories.SensorDataRepository;
import com.dymometr.Dymometr.services.interfaces.SensorDataService;
import org.springframework.stereotype.Service;

@Service
public class SensorDataServiceImpl implements SensorDataService {
    private final SensorDataRepository sensorDataRepository;

    public SensorDataServiceImpl(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    @Override
    public SensorDataEntity save(SensorDataEntity sensorDataEntity) {
        return sensorDataRepository.save(sensorDataEntity);
    }
}
