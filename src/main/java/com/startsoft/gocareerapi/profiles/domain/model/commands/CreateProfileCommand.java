package com.startsoft.gocareerapi.profiles.domain.model.commands;

public record CreateProfileCommand(String firstName, String lastName,String email, String description, Boolean isSpecialist ) {}
