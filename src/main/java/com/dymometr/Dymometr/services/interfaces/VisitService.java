package com.dymometr.Dymometr.services.interfaces;

import com.dymometr.Dymometr.domain.entity.DoctorEntity;
import com.dymometr.Dymometr.domain.entity.UserEntity;
import com.dymometr.Dymometr.domain.entity.VisitEntity;

import java.util.Optional;

public interface VisitService {
    VisitEntity addVisit(UserEntity foundUser, DoctorEntity foundDoctor, String visitDate);
}
