package com.startsoft.gocareerapi.profiles.interfaces.rest.transform;

import com.startsoft.gocareerapi.profiles.domain.model.commands.CreateProfileCommand;
import com.startsoft.gocareerapi.profiles.interfaces.rest.resources.CreateProfileResource;

public class CreateProfileCommandFromResourceAssembler {

    public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource){
        return new CreateProfileCommand(
                resource.firstName(),
                resource.lastName(),
                resource.email(),
                resource.description(),
                resource.isSpecialist()
        );
    }
}
