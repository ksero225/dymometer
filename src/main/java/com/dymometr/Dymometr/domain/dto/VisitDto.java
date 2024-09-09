package com.dymometr.Dymometr.domain.dto;

import com.dymometr.Dymometr.domain.entity.DoctorEntity;
import com.dymometr.Dymometr.domain.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VisitDto {
    private Long visitId;
    private UserEntity user;
    private DoctorEntity doctor;
    private String visitDate;
}
