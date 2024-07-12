package com.startsoft.gocareerapi.student.domain.model.commands;
import java.util.Date;

public record CreateMeetingCommand(String title, String description, Date date) {
}
