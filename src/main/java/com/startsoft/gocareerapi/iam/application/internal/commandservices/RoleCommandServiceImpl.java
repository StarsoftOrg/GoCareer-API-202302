package com.startsoft.gocareerapi.iam.application.internal.commandservices;

import com.startsoft.gocareerapi.iam.domain.model.commands.SeedRolesCommand;
import com.startsoft.gocareerapi.iam.domain.model.entities.Role;
import com.startsoft.gocareerapi.iam.domain.model.valueobjects.Roles;
import com.startsoft.gocareerapi.iam.domain.services.RoleCommandService;
import com.startsoft.gocareerapi.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Implementation of {@link RoleCommandService}
 * <p>
 *     This class is responsible for handling the commands for {@link Role} entity
 * </p>
 */
@Service
public class RoleCommandServiceImpl implements RoleCommandService {

    private final RoleRepository roleRepository;

    public RoleCommandServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void handle(SeedRolesCommand command) {
        Arrays.stream(Roles.values()).forEach(role -> {
            if(!roleRepository.existsByName(role)) {
                roleRepository.save(new Role(Roles.valueOf(role.name())));
            }
        });
    }
}