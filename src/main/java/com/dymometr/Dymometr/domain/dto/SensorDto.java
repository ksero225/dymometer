package com.dymometr.Dymometr.domain.dto;

import com.dymometr.Dymometr.domain.entity.SensorDataEntity;
import com.dymometr.Dymometr.domain.entity.SensorLocalizationEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SensorDto {
    private Long sensorId;
    private String sensorName;
    private SensorLocalizationEntity sensorLocalization;
    private List<SensorDataEntity> sensorDataList;
}
