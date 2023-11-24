package com.startsoft.gocareerapi.student.application.internal.queryservices;

import com.startsoft.gocareerapi.student.domain.model.agreggates.Meeting;
import com.startsoft.gocareerapi.student.domain.model.queries.GetAllMeetingsQuery;
import com.startsoft.gocareerapi.student.domain.model.queries.GetMeetingByIdQuery;
import com.startsoft.gocareerapi.student.domain.services.MeetingQueryService;
import com.startsoft.gocareerapi.student.infrastructure.persistance.jpa.repositories.MeetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeetingQueryServiceImpl implements MeetingQueryService {

    MeetingRepository meetingRepository;

    public MeetingQueryServiceImpl(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    @Override
    public Optional<Meeting> handle(GetMeetingByIdQuery query) {
        return  meetingRepository.findById(query.meetingId());
    }

    @Override
    public List<Meeting> handle(GetAllMeetingsQuery query) {
        return meetingRepository.findAll();
    }
}
