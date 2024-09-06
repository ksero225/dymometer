package com.dymometr.Dymometr.controllersTests;

import com.dymometr.Dymometr.TestDataUtilities;
import com.dymometr.Dymometr.domain.dto.SensorDto;
import com.dymometr.Dymometr.domain.entity.SensorEntity;
import com.dymometr.Dymometr.services.interfaces.SensorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class SensorControllerTests {
    private final SensorService sensorService;
    private final ObjectMapper objectMapper;
    private final MockMvc mockMvc;

    @Autowired
    public SensorControllerTests(SensorService sensorService, ObjectMapper objectMapper, MockMvc mockMvc) {
        this.sensorService = sensorService;
        this.objectMapper = objectMapper;
        this.mockMvc = mockMvc;
    }

    @Test
    public void testThatCreateSensorSuccessfullyReturnsHttpStatus201Created() throws Exception {
        SensorEntity sensorEntity = TestDataUtilities.createTestSensorEntityA();

        String sensorEntityJson = objectMapper.writeValueAsString(sensorEntity);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/sensor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(sensorEntityJson)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        );
    }

    @Test
    public void testThatCreateSensorSuccessfullyReturnsCreatedSensor() throws Exception {
        SensorDto sensorDto = TestDataUtilities.createTestSensorDtoA();

        String sensorDtoJson = objectMapper.writeValueAsString(sensorDto);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/sensor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(sensorDtoJson)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.sensorName").value("sensorA")
        );
    }

    @Test
    public void testThatGetOneSensorByIdSuccessfullyReturnsHttpStatus200Ok() throws Exception {
        SensorEntity sensorEntity = TestDataUtilities.createTestSensorEntityA();
        sensorService.save(sensorEntity);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/sensor/" + sensorEntity.getSensorId())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.sensorName").value("sensorA")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

    @Test
    public void testThatGetOneSensorByIdReturnsHttpStatus404NotFound() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/sensor/999")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isNotFound()
        );
    }

    @Test
    public void testThatListSensorReturnsSensor() throws Exception {
        SensorEntity sensorEntityA = TestDataUtilities.createTestSensorEntityA();
        sensorService.save(sensorEntityA);
        SensorEntity sensorEntityB = TestDataUtilities.createTestSensorEntityB();
        sensorService.save(sensorEntityB);
        SensorEntity sensorEntityC = TestDataUtilities.createTestSensorEntityC();
        sensorService.save(sensorEntityC);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/sensor")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.[0].sensorName").value("sensorA")
        );
    }

    @Test
    public void testThatFullUpdateSensorReturnsUpdatedSensor() throws Exception {
        SensorEntity sensorEntity = TestDataUtilities.createTestSensorEntityA();
        sensorService.save(sensorEntity);

        SensorDto sensorDto = TestDataUtilities.createTestSensorDtoA();
        sensorDto.setSensorName("UPDATED");
        String sensorDtoJson = objectMapper.writeValueAsString(sensorDto);

        mockMvc.perform(
                MockMvcRequestBuilders.put("/sensor/" + sensorEntity.getSensorId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(sensorDtoJson)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.sensorName").value("UPDATED")
        );
    }

    @Test
    public void testThatPartialUpdateSensorReturnsUpdatedSensor() throws Exception {
        SensorEntity sensorEntity = TestDataUtilities.createTestSensorEntityA();
        sensorService.save(sensorEntity);

        SensorDto sensorDto = TestDataUtilities.createTestSensorDtoA();
        sensorDto.setSensorName("UPDATED");
        String sensorDtoJson = objectMapper.writeValueAsString(sensorDto);

        mockMvc.perform(
                MockMvcRequestBuilders.patch("/sensor/" + sensorEntity.getSensorId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(sensorDtoJson)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.sensorName").value("UPDATED")
        );
    }

    @Test
    public void testThatDeleteSensorReturnsHttpStatus204NoContent() throws Exception {
        SensorEntity sensorEntity = TestDataUtilities.createTestSensorEntityA();
        sensorService.save(sensorEntity);

        mockMvc.perform(
                MockMvcRequestBuilders.delete("/sensor/" + sensorEntity.getSensorId())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isNoContent()
        );
    }
}
