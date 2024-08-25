package com.dymometr.Dymometr.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SensorLocalizationDto {
    private Long sensorLocalizationId;
    private String sensorVoivodeship;
    private String sensorTown;
}
