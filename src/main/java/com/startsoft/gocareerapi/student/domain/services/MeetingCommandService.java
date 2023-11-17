package com.startsoft.gocareerapi.student.domain.services;

import com.startsoft.gocareerapi.student.domain.model.commands.CreateMeetingCommand;

public interface MeetingCommandService {
    Long handle(CreateMeetingCommand command);
}
