package com.startsoft.gocareerapi.assessment.domain.services;

import com.startsoft.gocareerapi.assessment.domain.model.commands.CreateVocacionalTestCommand;

public interface VocacionalTestCommandService {
    Long handle(CreateVocacionalTestCommand command);
}
