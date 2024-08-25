package com.dymometr.Dymometr.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SensorDataDto {
    private Long sensorDataId;
    private Long sensorId;

    private Integer sensorData;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime sensorDataSendDate;
}
