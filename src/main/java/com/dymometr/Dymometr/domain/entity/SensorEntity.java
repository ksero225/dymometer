package com.dymometr.Dymometr.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "sensor")
public class SensorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_id")
    private Long sensorId;

    @Column(name = "sensor_name")
    private String sensorName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "localization_id")
    private SensorLocalizationEntity sensorLocalization;

    @OneToMany(mappedBy = "sensor", fetch = FetchType.EAGER)
    private List<SensorDataEntity> sensorDataList;
}
