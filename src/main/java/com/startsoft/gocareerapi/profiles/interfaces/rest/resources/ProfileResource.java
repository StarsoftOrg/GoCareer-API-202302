package com.startsoft.gocareerapi.profiles.interfaces.rest.resources;

public record ProfileResource(Long id, String fullName, String email, String description, Boolean isSpecialist) {
}
