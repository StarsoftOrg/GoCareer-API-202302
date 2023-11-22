package com.startsoft.gocareerapi.iam.domain.services;

import com.startsoft.gocareerapi.iam.domain.model.entities.Role;
import com.startsoft.gocareerapi.iam.domain.model.queries.GetAllRolesQuery;
import com.startsoft.gocareerapi.iam.domain.model.queries.GetRoleByNameQuery;

import java.util.List;
import java.util.Optional;

/**
 * This interface represents the query service for the {@link Role} entity.
 * <p>
 *     The query service is responsible for handling the queries related to the role domain entity.
 * </p>
 */
public interface RoleQueryService {

    /**
     * Handle the get all roles query.
     * <p>
     *     This method is responsible for retrieving all the roles from the database.
     * </p>
     * @param query The get all roles query.
     * @return The list of roles.
     * @see GetAllRolesQuery
     */
    List<Role> handle(GetAllRolesQuery query);
    Optional<Role> handle(GetRoleByNameQuery query);
}