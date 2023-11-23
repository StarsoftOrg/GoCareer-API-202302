package com.startsoft.gocareerapi.profiles.domain.services;

import com.startsoft.gocareerapi.profiles.domain.model.commands.CreateProfileCommand;

public interface ProfileCommandService {

    Long handle(CreateProfileCommand command);
}
