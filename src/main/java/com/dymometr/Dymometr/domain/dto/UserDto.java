package com.dymometr.Dymometr.domain.dto;

import com.dymometr.Dymometr.domain.entity.VisitEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long userId;
    private String userLogin;
    private String userPassword;
    private String userEmail;
    private List<VisitEntity> userVisits = new ArrayList<>();
}
