package com.startsoft.gocareerapi.iam.domain.model.commands;

import com.startsoft.gocareerapi.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String username, String password, List<Role> roles) {
}
