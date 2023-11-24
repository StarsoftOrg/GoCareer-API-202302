package com.startsoft.gocareerapi.assessment.infrastructure.persistance.jpa.repositories;

import com.startsoft.gocareerapi.assessment.domain.model.aggregates.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
}
