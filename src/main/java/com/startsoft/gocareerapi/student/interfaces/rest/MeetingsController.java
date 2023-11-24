package com.startsoft.gocareerapi.student.interfaces.rest;

import com.startsoft.gocareerapi.student.application.internal.commandservices.MeetingCommandServiceImpl;
import com.startsoft.gocareerapi.student.domain.model.queries.GetAllMeetingsQuery;
import com.startsoft.gocareerapi.student.domain.model.queries.GetMeetingByIdQuery;
import com.startsoft.gocareerapi.student.domain.services.MeetingCommandService;
import com.startsoft.gocareerapi.student.domain.services.MeetingQueryService;
import com.startsoft.gocareerapi.student.interfaces.rest.resources.CreateMeetingResource;
import com.startsoft.gocareerapi.student.interfaces.rest.resources.MeetingResource;
import com.startsoft.gocareerapi.student.interfaces.rest.transform.CreateMeetingCommandFromResourceAssembler;
import com.startsoft.gocareerapi.student.interfaces.rest.transform.MeetingResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/meetings",produces = APPLICATION_JSON_VALUE)
@Tag(name = "Meetings", description = "Meetings Management Endpoints")
public class MeetingsController {
    public MeetingCommandService meetingCommandService;
    public MeetingQueryService meetingQueryService;

    public MeetingsController(MeetingCommandService meetingCommandService, MeetingQueryService meetingQueryService) {
        this.meetingCommandService = meetingCommandService;
        this.meetingQueryService = meetingQueryService;
    }


    @GetMapping
    public ResponseEntity<List<MeetingResource>> getAllMeetings(){
        var getAllMeetingsQuery = new GetAllMeetingsQuery();
        var meetings = meetingQueryService.handle(getAllMeetingsQuery);
        var meetingResources = meetings.stream().map(MeetingResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(meetingResources);
    }


    @GetMapping("/{meetingId}")
    public ResponseEntity<MeetingResource> getMeetingById(@PathVariable Long meetingId){

        var getMeetingByIdQuery = new GetMeetingByIdQuery(meetingId);
        var meeting = meetingQueryService.handle(getMeetingByIdQuery);
        if (meeting.isEmpty()) return ResponseEntity.notFound().build();

        var meetingResource = MeetingResourceFromEntityAssembler.toResourceFromEntity(meeting.get());

        return ResponseEntity.ok(meetingResource);
    }



    @PostMapping
    public ResponseEntity<MeetingResource> createMeeting(@RequestBody CreateMeetingResource createMeetingResource) {
        var createMeetingCommand = CreateMeetingCommandFromResourceAssembler.toCommandFromResource(createMeetingResource);
        var meetingId = meetingCommandService.handle(createMeetingCommand);
        if (meetingId == 0L) return ResponseEntity.badRequest().build();


        var getMeetingbyIdQuery = new GetMeetingByIdQuery(meetingId);
        var meeting = meetingQueryService.handle(getMeetingbyIdQuery);
        if (meeting.isEmpty()) return ResponseEntity.notFound().build();

        var meetingResource = MeetingResourceFromEntityAssembler.toResourceFromEntity(meeting.get());

        return new ResponseEntity<>(meetingResource, HttpStatus.CREATED);
    }

}
