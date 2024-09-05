package com.dymometr.Dymometr.repositories;

import com.dymometr.Dymometr.domain.entity.SensorDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorDataEntity, Long> {
    Optional<SensorDataEntity> findTopBySensorSensorIdOrderBySensorDataSendDateDesc(Long sensorId);
}
