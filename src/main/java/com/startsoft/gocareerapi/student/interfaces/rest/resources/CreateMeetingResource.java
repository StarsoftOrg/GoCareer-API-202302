package com.startsoft.gocareerapi.student.interfaces.rest.resources;


import java.util.Date;

public record CreateMeetingResource(String title, String description, Date date) {
}
