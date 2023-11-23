package com.startsoft.gocareerapi.student.interfaces.rest.transform;

import com.startsoft.gocareerapi.student.domain.model.agreggates.Meeting;
import com.startsoft.gocareerapi.student.interfaces.rest.resources.MeetingResource;

public class MeetingResourceFromEntityAssembler {
    public static MeetingResource toResourceFromEntity(Meeting entity) {
        return new MeetingResource(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getDate());
    }
}
