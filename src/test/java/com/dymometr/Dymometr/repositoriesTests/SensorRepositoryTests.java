package com.dymometr.Dymometr.repositoriesTests;

import com.dymometr.Dymometr.TestDataUtilities;
import com.dymometr.Dymometr.domain.entity.SensorEntity;
import com.dymometr.Dymometr.repositories.SensorRepository;
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
public class SensorRepositoryTests {
    private final SensorRepository sensorRepository;

    @Autowired
    public SensorRepositoryTests(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Test
    public void testThatSensorCanBeCreatedAndRecalled(){
        SensorEntity sensorEntity = TestDataUtilities.createTestSensorEntityA();
        sensorRepository.save(sensorEntity);

        Optional<SensorEntity> result = sensorRepository.findById(sensorEntity.getSensorId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(sensorEntity);
    }

    @Test
    public void testThatMultipleSensorsCanBeCreatedAndRecalled(){
        SensorEntity sensorEntityA = TestDataUtilities.createTestSensorEntityA();
        SensorEntity sensorEntityB = TestDataUtilities.createTestSensorEntityB();
        SensorEntity sensorEntityC = TestDataUtilities.createTestSensorEntityC();

        List<SensorEntity> sensorEntityList = new ArrayList<>();

        sensorEntityList.add(sensorEntityA);
        sensorEntityList.add(sensorEntityB);
        sensorEntityList.add(sensorEntityC);

        sensorRepository.saveAll(sensorEntityList);

        Iterable<SensorEntity> result = sensorRepository.findAll();
        assertThat(result).hasSize(3).containsExactlyInAnyOrder(sensorEntityA,sensorEntityB,sensorEntityC);
    }

    @Test
    public void testThatSensorCanBeUpdatedAndRecalled(){
        SensorEntity sensorEntity = TestDataUtilities.createTestSensorEntityA();
        sensorRepository.save(sensorEntity);

        Optional<SensorEntity> result = sensorRepository.findById(sensorEntity.getSensorId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(sensorEntity);

        sensorEntity.setSensorName("UPDATED");

        sensorRepository.save(sensorEntity);
        result = sensorRepository.findById(sensorEntity.getSensorId());

        assertThat(result).isPresent();
        assertThat(result.get().getSensorName()).isEqualTo("UPDATED");
    }

    @Test
    public void testThatSensorCanBeDeleted(){
        SensorEntity sensorEntity = TestDataUtilities.createTestSensorEntityA();
        sensorRepository.save(sensorEntity);

        Optional<SensorEntity> result = sensorRepository.findById(sensorEntity.getSensorId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(sensorEntity);

        sensorRepository.delete(sensorEntity);

        result = sensorRepository.findById(sensorEntity.getSensorId());

        assertThat(result).isEmpty();

    }
}
