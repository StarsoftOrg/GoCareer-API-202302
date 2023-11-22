package com.startsoft.gocareerapi.profiles.domain.model.valueobjects;

import jakarta.validation.constraints.Email;

public record EmailAddress(@Email String address) {
    public EmailAddress(){
        this(null);
    }
}
