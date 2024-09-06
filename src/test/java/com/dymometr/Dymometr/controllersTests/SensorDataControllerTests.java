package com.dymometr.Dymometr.controllersTests;

import com.dymometr.Dymometr.TestDataUtilities;
import com.dymometr.Dymometr.domain.entity.SensorDataEntity;
import com.dymometr.Dymometr.domain.entity.SensorEntity;
import com.dymometr.Dymometr.services.interfaces.SensorDataService;
import com.dymometr.Dymometr.services.interfaces.SensorService;
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
public class SensorDataControllerTests {
    private final SensorDataService sensorDataService;
    private final SensorService sensorService;
    private final ObjectMapper objectMapper;
    private final MockMvc mockMvc;

    @Autowired
    public SensorDataControllerTests(SensorDataService sensorDataService, SensorService sensorService, ObjectMapper objectMapper, MockMvc mockMvc) {
        this.sensorDataService = sensorDataService;
        this.sensorService = sensorService;
        this.objectMapper = objectMapper;
        this.mockMvc = mockMvc;
    }

    @Test
    public void testThatCreateSensorDataSuccessfullyReturnsHttpStatus201Created() throws Exception {
        SensorEntity sensorEntity = TestDataUtilities.createTestSensorEntityA();
        sensorService.save(sensorEntity);

        SensorDataEntity sensorDataEntity = TestDataUtilities.createTestSensorDataEntityA();
        String sensorDataEntityJson = objectMapper.writeValueAsString(sensorDataEntity);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/sensorData?sensorId=1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(sensorDataEntityJson)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        );

    }
}
