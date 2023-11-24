package com.startsoft.gocareerapi.assessment.application.internal.commandservices;

import com.startsoft.gocareerapi.assessment.domain.model.aggregates.VocacionalTest;
import com.startsoft.gocareerapi.assessment.domain.model.commands.CreateVocacionalTestCommand;
import com.startsoft.gocareerapi.assessment.domain.services.VocacionalTestCommandService;
import com.startsoft.gocareerapi.assessment.infrastructure.persistance.jpa.repositories.VocacionalTestRepository;
import org.springframework.stereotype.Service;

@Service
public class VocacionalTestCommandServiceImpl implements VocacionalTestCommandService {

    private final VocacionalTestRepository vocacionalTestRepository;

    public VocacionalTestCommandServiceImpl(VocacionalTestRepository vocacionalTestRepository) {
        this.vocacionalTestRepository = vocacionalTestRepository;
    }

    @Override
    public Long handle(CreateVocacionalTestCommand command) {
        var vocacionalTest = new VocacionalTest(command.Title(), command.Description(), command.numberQuestions());
        vocacionalTestRepository.save(vocacionalTest);
        return vocacionalTest.getId();
    }
}
