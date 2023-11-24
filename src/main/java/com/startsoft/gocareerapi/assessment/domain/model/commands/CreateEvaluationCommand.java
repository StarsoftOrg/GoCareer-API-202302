package com.startsoft.gocareerapi.assessment.domain.model.commands;

public record CreateEvaluationCommand(String Title, String Description, int numberQuestions) {
}
