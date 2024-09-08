package com.dymometr.Dymometr.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DoctorDto {
    private Long doctorId;
    private String doctorName;
//    private String doctorSpecialization;
//    private String doctorAddress;

    //lista dostępnych wizyt
}
