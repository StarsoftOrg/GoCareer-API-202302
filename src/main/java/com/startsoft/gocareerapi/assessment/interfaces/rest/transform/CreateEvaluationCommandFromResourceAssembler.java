package com.startsoft.gocareerapi.assessment.interfaces.rest.transform;

import com.startsoft.gocareerapi.assessment.domain.model.commands.CreateEvaluationCommand;
import com.startsoft.gocareerapi.assessment.interfaces.rest.resources.CreateEvaluationResource;

public class CreateEvaluationCommandFromResourceAssembler {
    public static CreateEvaluationCommand toCommandFromResource(CreateEvaluationResource resource) {
        return new CreateEvaluationCommand(
                resource.title(),
                resource.description(),
                resource.numberQuestions());
    }

}
