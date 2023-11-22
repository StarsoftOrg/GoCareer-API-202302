package com.startsoft.gocareerapi.iam.interfaces.rest.transform;

import com.startsoft.gocareerapi.iam.domain.model.entities.Role;
import com.startsoft.gocareerapi.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role role) {
        return new RoleResource(role.getId(), role.getStringName());
    }
}
