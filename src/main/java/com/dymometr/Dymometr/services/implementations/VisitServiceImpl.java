package com.dymometr.Dymometr.services.implementations;

import com.dymometr.Dymometr.domain.entity.DoctorEntity;
import com.dymometr.Dymometr.domain.entity.UserEntity;
import com.dymometr.Dymometr.domain.entity.VisitEntity;
import com.dymometr.Dymometr.repositories.VisitRepository;
import com.dymometr.Dymometr.services.interfaces.VisitService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VisitServiceImpl implements VisitService {
    private final VisitRepository visitRepository;

    public VisitServiceImpl(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public VisitEntity addVisit(UserEntity foundUser, DoctorEntity foundDoctor, String visitDate) {
        return visitRepository.save(
                VisitEntity.builder()
                        .user(foundUser)
                        .doctor(foundDoctor)
                        .visitDate(visitDate)
                        .build()
        );
    }
}
