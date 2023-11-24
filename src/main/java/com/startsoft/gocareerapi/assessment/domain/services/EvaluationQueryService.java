package com.startsoft.gocareerapi.assessment.domain.services;

import com.startsoft.gocareerapi.assessment.domain.model.aggregates.Evaluation;
import com.startsoft.gocareerapi.assessment.domain.model.queries.GetAllEvaluationsQuery;
import com.startsoft.gocareerapi.assessment.domain.model.queries.GetEvaluationByIdQuery;

import java.util.List;
import java.util.Optional;

public interface EvaluationQueryService {
    Optional<Evaluation> handle(GetEvaluationByIdQuery query);

    List<Evaluation> handle(GetAllEvaluationsQuery query);
}
