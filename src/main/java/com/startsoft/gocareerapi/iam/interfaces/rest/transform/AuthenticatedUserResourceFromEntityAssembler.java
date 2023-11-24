package com.startsoft.gocareerapi.iam.interfaces.rest.transform;

import com.startsoft.gocareerapi.iam.domain.model.aggregates.User;
import com.startsoft.gocareerapi.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(user.getId(), user.getUsername(), token);
    }
}
