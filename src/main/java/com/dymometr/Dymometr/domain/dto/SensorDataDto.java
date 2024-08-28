package com.dymometr.Dymometr.domain.dto;

import com.dymometr.Dymometr.domain.entity.SensorEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SensorDataDto {
    private Long sensorDataId;
    private SensorEntity sensor;
    private Integer sensorData;
    private String sensorDataSendDate;
}
