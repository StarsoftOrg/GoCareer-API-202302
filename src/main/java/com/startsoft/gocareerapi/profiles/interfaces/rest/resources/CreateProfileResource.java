package com.startsoft.gocareerapi.profiles.interfaces.rest.resources;

public record CreateProfileResource(String firstName, String lastName, String email, String description, Boolean isSpecialist) {
}
