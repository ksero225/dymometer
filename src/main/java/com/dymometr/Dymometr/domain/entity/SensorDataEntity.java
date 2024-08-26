package com.dymometr.Dymometr.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "sensor_data")
public class SensorDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_data_id")
    private Long sensorDataId;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sensor_id")
    private SensorEntity sensor;

    @Column(name = "sensor_data")
    private Integer sensorData;

    @Column(name = "sensor_data_send_date")
    private String sensorDataSendDate;
}
