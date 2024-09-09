package com.dymometr.Dymometr.repositories;

import com.dymometr.Dymometr.domain.entity.VisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<VisitEntity, Long> {

}
