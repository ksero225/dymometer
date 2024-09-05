package com.dymometr.Dymometr.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Entity
@Table(name = "sensor_localization")
public class SensorLocalizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "localization_id")
    private Long sensorLocalizationId;

    @Column(name = "voivodeship")
    private String sensorVoivodeship;

    @Column(name = "town")
    private String sensorTown;

//    @JsonManagedReference
//    @OneToMany(mappedBy = "sensorLocalization", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    private List<SensorEntity> sensors;
}
