package com.startsoft.gocareerapi.assessment.domain.model.commands;

public record CreateVocacionalTestCommand(String Title, String Description, int numberQuestions) {
}
