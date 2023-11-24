package com.startsoft.gocareerapi.profiles.domain.model.queries;

import com.startsoft.gocareerapi.profiles.domain.model.valueobjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress emailAddress) {}
