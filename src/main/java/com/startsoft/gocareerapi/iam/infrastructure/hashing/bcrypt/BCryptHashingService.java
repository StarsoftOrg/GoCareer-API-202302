package com.startsoft.gocareerapi.iam.infrastructure.hashing.bcrypt;

import com.startsoft.gocareerapi.iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Hashing service implementation.
 * Implementation of {@link HashingService} using BCrypt algorithm.
 * Implementation of {@link PasswordEncoder} using BCrypt algorithm.
 */
public interface BCryptHashingService extends HashingService, PasswordEncoder {
}