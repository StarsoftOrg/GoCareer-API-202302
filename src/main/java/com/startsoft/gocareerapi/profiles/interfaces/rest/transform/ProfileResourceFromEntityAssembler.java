package com.startsoft.gocareerapi.profiles.interfaces.rest.transform;

import com.startsoft.gocareerapi.profiles.domain.model.aggregates.Profile;
import com.startsoft.gocareerapi.profiles.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(Profile entity){
        return new ProfileResource(entity.getId(), entity.getFullName(), entity.getEmailAddress(), entity.getDescription(), entity.getRole());
    }
}
