package com.startsoft.gocareerapi.assessment.interfaces.rest.transform;

import com.startsoft.gocareerapi.assessment.domain.model.commands.CreateVocacionalTestCommand;
import com.startsoft.gocareerapi.assessment.interfaces.rest.resources.CreateVocacionalTestResource;

public class CreateVocacionalTestCommandFromResourceAssembler {
    public static CreateVocacionalTestCommand toCommandFromResource(CreateVocacionalTestResource resource) {
        return new CreateVocacionalTestCommand(
                resource.Title(),
                resource.Description(),
                resource.numberQuestions());
    }

}
