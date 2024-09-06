package com.dymometr.Dymometr.repositoriesTests;

import com.dymometr.Dymometr.TestDataUtilities;
import com.dymometr.Dymometr.domain.entity.SensorDataEntity;
import com.dymometr.Dymometr.domain.entity.SensorEntity;
import com.dymometr.Dymometr.repositories.SensorDataRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class SensorDataRepositoryTests {
    private final SensorDataRepository sensorDataRepository;

    @Autowired
    public SensorDataRepositoryTests(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    @Test
    public void testThatSensorDataCanBeCreatedAndRecalled() {
        SensorDataEntity sensorDataEntity = TestDataUtilities.createTestSensorDataEntityA();
        sensorDataRepository.save(sensorDataEntity);

        Optional<SensorDataEntity> result = sensorDataRepository.findById(sensorDataEntity.getSensorDataId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(sensorDataEntity);
    }

    @Test
    public void testThatMultipleSensorDataCanBeCreatedAndRecalled() {
        SensorDataEntity sensorDataEntityA = TestDataUtilities.createTestSensorDataEntityA();
        SensorDataEntity sensorDataEntityB = TestDataUtilities.createTestSensorDataEntityB();
        SensorDataEntity sensorDataEntityC = TestDataUtilities.createTestSensorDataEntityC();

        List<SensorDataEntity> sensorDataEntityList = new ArrayList<>();

        sensorDataEntityList.add(sensorDataEntityA);
        sensorDataEntityList.add(sensorDataEntityB);
        sensorDataEntityList.add(sensorDataEntityC);

        sensorDataRepository.saveAll(sensorDataEntityList);

        Iterable<SensorDataEntity> result = sensorDataRepository.findAll();

        assertThat(result)
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        sensorDataEntityA,
                        sensorDataEntityB,
                        sensorDataEntityC
                );
    }

    @Test
    public void testThatSensorDataCanBeUpdatedAndRecalled() {
        SensorDataEntity sensorDataEntity = TestDataUtilities.createTestSensorDataEntityA();
        sensorDataRepository.save(sensorDataEntity);

        Optional<SensorDataEntity> result = sensorDataRepository.findById(sensorDataEntity.getSensorDataId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(sensorDataEntity);

        sensorDataEntity.setSensorData(999);
        sensorDataRepository.save(sensorDataEntity);

        result = sensorDataRepository.findById(sensorDataEntity.getSensorDataId());

        assertThat(result).isPresent();
        assertThat(result.get().getSensorData()).isEqualTo(999);
    }

    @Test
    public void testThatSensorDataCanBeDeleted() {
        SensorDataEntity sensorDataEntity = TestDataUtilities.createTestSensorDataEntityA();
        sensorDataRepository.save(sensorDataEntity);

        Optional<SensorDataEntity> result = sensorDataRepository.findById(sensorDataEntity.getSensorDataId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(sensorDataEntity);

        sensorDataRepository.delete(sensorDataEntity);

        result = sensorDataRepository.findById(sensorDataEntity.getSensorDataId());

        assertThat(result).isEmpty();
    }
}
