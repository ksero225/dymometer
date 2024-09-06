package com.dymometr.Dymometr;

import com.dymometr.Dymometr.domain.dto.SensorDto;
import com.dymometr.Dymometr.domain.entity.SensorDataEntity;
import com.dymometr.Dymometr.domain.entity.SensorEntity;
import com.dymometr.Dymometr.domain.entity.SensorLocalizationEntity;

public class TestDataUtilities {
    public static SensorEntity createTestSensorEntityA() {
        return SensorEntity.builder()
                .sensorName("sensorA")
                .build();
    }

    public static SensorEntity createTestSensorEntityB() {
        return SensorEntity.builder()
                .sensorName("sensorB")
                .build();
    }

    public static SensorEntity createTestSensorEntityC() {
        return SensorEntity.builder()
                .sensorName("sensorC")
                .build();
    }

    public static SensorDto createTestSensorDtoA() {
        return SensorDto.builder()
                .sensorName("sensorA")
                .build();
    }

    public static SensorDto createTestSensorDtoB() {
        return SensorDto.builder()
                .sensorName("sensorB")
                .build();
    }

    public static SensorDto createTestSensorDtoC() {
        return SensorDto.builder()
                .sensorName("sensorC")
                .build();
    }

    public static SensorDataEntity createTestSensorDataEntityA() {
        return SensorDataEntity.builder()
                .sensorData(100)
                .sensorDataSendDate("2024-01-01")
                .build();
    }

    public static SensorDataEntity createTestSensorDataEntityB() {
        return SensorDataEntity.builder()
                .sensorData(200)
                .sensorDataSendDate("2024-02-02")
                .build();
    }

    public static SensorDataEntity createTestSensorDataEntityC() {
        return SensorDataEntity.builder()
                .sensorData(300)
                .sensorDataSendDate("2024-03-03")
                .build();
    }

}
