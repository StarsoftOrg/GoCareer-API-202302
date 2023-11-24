package com.startsoft.gocareerapi.student.domain.services;

import com.startsoft.gocareerapi.student.domain.model.agreggates.Meeting;
import com.startsoft.gocareerapi.student.domain.model.queries.GetAllMeetingsQuery;
import com.startsoft.gocareerapi.student.domain.model.queries.GetMeetingByIdQuery;

import java.util.List;
import java.util.Optional;

public interface MeetingQueryService {
    Optional<Meeting> handle(GetMeetingByIdQuery query);
    List<Meeting> handle(GetAllMeetingsQuery query);
}
