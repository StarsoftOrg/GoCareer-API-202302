package com.startsoft.gocareerapi.student.interfaces.rest.transform;

import com.startsoft.gocareerapi.student.domain.model.commands.CreateMeetingCommand;
import com.startsoft.gocareerapi.student.interfaces.rest.resources.CreateMeetingResource;

public class CreateMeetingCommandFromResourceAssembler {
    public static CreateMeetingCommand toCommandFromResource(CreateMeetingResource resource) {
        return new CreateMeetingCommand(
                resource.Title(),
                resource.Description(),
                resource.Date());
    }

}
