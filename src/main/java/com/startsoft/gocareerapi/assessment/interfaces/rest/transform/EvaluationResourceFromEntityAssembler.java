package com.startsoft.gocareerapi.assessment.interfaces.rest.transform;

import com.startsoft.gocareerapi.assessment.domain.model.aggregates.Evaluation;
import com.startsoft.gocareerapi.assessment.interfaces.rest.resources.EvaluationResource;

public class EvaluationResourceFromEntityAssembler {
    public static EvaluationResource toResourceFromEntity(Evaluation evaluation) {
        return new EvaluationResource(
                evaluation.getId(),
                evaluation.getTitle(),
                evaluation.getDescription(),
                evaluation.getNumberQuestions());
    }
}
