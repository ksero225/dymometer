package com.dymometr.Dymometr.repositories;

import com.dymometr.Dymometr.domain.entity.SensorDataEntity;
import com.dymometr.Dymometr.domain.entity.SensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<SensorEntity, Long>, JpaSpecificationExecutor<SensorEntity> {
}
