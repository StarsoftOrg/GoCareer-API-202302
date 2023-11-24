package com.startsoft.gocareerapi.profiles.application.internal.commandservices;

import com.startsoft.gocareerapi.profiles.domain.model.aggregates.Profile;
import com.startsoft.gocareerapi.profiles.domain.model.commands.CreateProfileCommand;
import com.startsoft.gocareerapi.profiles.domain.model.valueobjects.EmailAddress;
import com.startsoft.gocareerapi.profiles.domain.services.ProfileCommandService;
import com.startsoft.gocareerapi.profiles.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {

    private final ProfileRepository profileRepository;

    public ProfileCommandServiceImpl(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }


    @Override
    public Long handle(CreateProfileCommand command){
        var email = new EmailAddress(command.email());
        profileRepository.findByEmail(email).map(profile -> {
            throw new IllegalArgumentException("Profile with" + command.email() + "already exists");
        });
        var profile = new Profile(command.firstName(), command.lastName(), command.email(),command.description(), command.isSpecialist());
        profileRepository.save(profile);
        return profile.getId();
    }


}
