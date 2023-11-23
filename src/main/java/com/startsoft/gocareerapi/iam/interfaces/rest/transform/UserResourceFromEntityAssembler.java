package com.startsoft.gocareerapi.iam.interfaces.rest.transform;

import com.startsoft.gocareerapi.iam.domain.model.aggregates.User;
import com.startsoft.gocareerapi.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        var roles = user.getRoles().stream().map(role -> role.getStringName()).toList();
        return new UserResource(user.getId(), user.getUsername(), roles);
    }
}
