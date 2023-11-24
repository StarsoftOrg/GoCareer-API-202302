package com.startsoft.gocareerapi.assessment.domain.services;

import com.startsoft.gocareerapi.assessment.domain.model.commands.CreateEvaluationCommand;

public interface EvaluationCommandService {
    Long handle(CreateEvaluationCommand command);
}
