package com.startsoft.gocareerapi.student.domain.services;

import com.startsoft.gocareerapi.student.domain.model.agreggates.Meeting;
import com.startsoft.gocareerapi.student.domain.model.queries.GetMeetingByIdQuery;

import java.util.Optional;

public interface MeetingQueryService {
    Optional<Meeting> handle(GetMeetingByIdQuery query);
}
