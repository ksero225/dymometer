package com.dymometr.Dymometr.domain.specification;

import com.dymometr.Dymometr.domain.entity.DoctorEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

public class DoctorSpecifications {
    public static Specification<DoctorEntity> hasDoctorName(String doctorName) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.get("doctorName"),
                        doctorName.toLowerCase())
        );
    }
    public static Specification<DoctorEntity> hasDoctorSpecialization(String doctorSpecialization) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.get("doctorSpecialization"),
                        doctorSpecialization.toLowerCase())
        );
    }
    public static Specification<DoctorEntity> hasDoctorTown(String doctorTown) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.get("doctorTown"),
                        doctorTown.toLowerCase())
        );
    }
}
