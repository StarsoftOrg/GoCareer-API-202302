package com.startsoft.gocareerapi.profiles.domain.model.valueobjects;

public record PersonDescription(String description) {

    public PersonDescription(){
        this(null);
    }

    public String getPersonDescription(){
        return description;
    }
}
