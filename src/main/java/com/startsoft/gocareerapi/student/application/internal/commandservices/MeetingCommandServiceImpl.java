package com.startsoft.gocareerapi.student.application.internal.commandservices;

import com.startsoft.gocareerapi.student.domain.model.agreggates.Meeting;
import com.startsoft.gocareerapi.student.domain.model.commands.CreateMeetingCommand;
import com.startsoft.gocareerapi.student.domain.services.MeetingCommandService;
import com.startsoft.gocareerapi.student.infrastructure.persistance.jpa.repositories.MeetingRepository;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link MeetingCommandService} interface.
 */
@Service
public class MeetingCommandServiceImpl implements MeetingCommandService {

    MeetingRepository meetingRepository;

    public MeetingCommandServiceImpl(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    @Override
    public Long handle(CreateMeetingCommand command) {
        var meeting = new Meeting(command.Title(),command.Description(),command.Date());
        meetingRepository.save(meeting);
        return meeting.getId();
    }
}
