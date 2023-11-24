package com.startsoft.gocareerapi.assessment.application.internal.commandservices;

import com.startsoft.gocareerapi.assessment.domain.model.aggregates.Evaluation;
import com.startsoft.gocareerapi.assessment.domain.model.commands.CreateEvaluationCommand;
import com.startsoft.gocareerapi.assessment.domain.services.EvaluationCommandService;
import com.startsoft.gocareerapi.assessment.infrastructure.persistance.jpa.repositories.EvaluationRepository;
import org.springframework.stereotype.Service;

@Service
public class EvaluationCommandServiceImpl implements EvaluationCommandService {

    private final EvaluationRepository evaluationRepository;

    public EvaluationCommandServiceImpl(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    @Override
    public Long handle(CreateEvaluationCommand command) {
        var vocacionalTest = new Evaluation(command.Title(), command.Description(), command.numberQuestions());
        evaluationRepository.save(vocacionalTest);
        return vocacionalTest.getId();
    }
}
