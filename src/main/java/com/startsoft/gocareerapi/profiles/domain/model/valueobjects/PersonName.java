package com.startsoft.gocareerapi.profiles.domain.model.valueobjects;

public record PersonName(String firstName, String lastName) {
    public PersonName(){
        this(null,null);
    }

    public PersonName {
        if(firstName == null || firstName.isBlank()){
            throw new IllegalArgumentException("First name cannot be blank");
        }

        if(lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be blank");
        }
    }

    public String getPersonName(){
        return firstName + " " + lastName;
    }
}