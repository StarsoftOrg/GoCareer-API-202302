package com.startsoft.gocareerapi.assessment.application.internal.queryservices;

import com.startsoft.gocareerapi.assessment.domain.model.aggregates.Evaluation;
import com.startsoft.gocareerapi.assessment.domain.model.queries.GetAllEvaluationsQuery;
import com.startsoft.gocareerapi.assessment.domain.model.queries.GetEvaluationByIdQuery;
import com.startsoft.gocareerapi.assessment.domain.services.EvaluationQueryService;
import com.startsoft.gocareerapi.assessment.infrastructure.persistance.jpa.repositories.EvaluationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluationQueryServiceImpl implements EvaluationQueryService {

    private final EvaluationRepository evaluationRepository;

    public EvaluationQueryServiceImpl(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    @Override
    public Optional<Evaluation> handle(GetEvaluationByIdQuery query) {
        return evaluationRepository.findById(query.id());
    }

    @Override
    public List<Evaluation> handle(GetAllEvaluationsQuery query) {
        return evaluationRepository.findAll();
    }
}
