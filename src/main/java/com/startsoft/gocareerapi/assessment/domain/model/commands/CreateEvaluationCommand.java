package com.startsoft.gocareerapi.assessment.domain.model.commands;

public record CreateEvaluationCommand(String title, String description, int numberQuestions) {
}
