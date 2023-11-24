package com.startsoft.gocareerapi.assessment.infrastructure.persistance.jpa.repositories;

import com.startsoft.gocareerapi.assessment.domain.model.aggregates.VocacionalTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VocacionalTestRepository extends JpaRepository<VocacionalTest, Long> {
}
