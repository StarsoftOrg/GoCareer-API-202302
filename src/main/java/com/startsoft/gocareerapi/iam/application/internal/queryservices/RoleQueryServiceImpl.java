package com.startsoft.gocareerapi.iam.application.internal.queryservices;

import com.startsoft.gocareerapi.iam.domain.model.entities.Role;
import com.startsoft.gocareerapi.iam.domain.model.queries.GetAllRolesQuery;
import com.startsoft.gocareerapi.iam.domain.model.queries.GetRoleByNameQuery;
import com.startsoft.gocareerapi.iam.domain.services.RoleQueryService;
import com.startsoft.gocareerapi.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Role query service implementation
 * <p>
 *     This class is used to handle the role queries.
 * </p>
 * @see RoleQueryService
 * @see RoleRepository
 */
@Service
public class RoleQueryServiceImpl implements RoleQueryService {
    private final RoleRepository roleRepository;

    public RoleQueryServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * Handle the get all roles query
     */
    @Override
    public List<Role> handle(GetAllRolesQuery query) {
        return roleRepository.findAll();
    }

    /**
     * Handle the get role by name query
     */
    @Override
    public Optional<Role> handle(GetRoleByNameQuery query) {
        return roleRepository.findByName(query.name());
    }
}