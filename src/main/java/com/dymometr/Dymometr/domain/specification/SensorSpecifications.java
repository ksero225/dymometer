package com.dymometr.Dymometr.domain.specification;

import com.dymometr.Dymometr.domain.entity.SensorEntity;
import org.springframework.data.jpa.domain.Specification;

public class SensorSpecifications {
    public static Specification<SensorEntity> hasVoivodeship(String voivodeship) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("sensorLocalization").get("sensorVoivodeship"), voivodeship));
    }

    public static Specification<SensorEntity> hasTown(String town) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("sensorLocalization").get("sensorTown"), town);
    }
}
