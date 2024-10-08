package com.dymometr.Dymometr.domain.dto;

import com.dymometr.Dymometr.domain.entity.SensorEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SensorLocalizationDto {
    private Long sensorLocalizationId;
    private String sensorVoivodeship;
    private String sensorTown;
    private BigDecimal sensorLatitude;
    private BigDecimal sensorLongitude;
//    private List<SensorEntity> sensors;
}
