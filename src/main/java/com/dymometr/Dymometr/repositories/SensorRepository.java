package com.dymometr.Dymometr.repositories;

import com.dymometr.Dymometr.domain.dto.SensorDto;
import com.dymometr.Dymometr.domain.entity.SensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<SensorEntity, Long> {
}
