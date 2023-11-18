package com.startsoft.gocareerapi.student.domain.model.commands;
import java.util.Date;

public record CreateMeetingCommand(String Title, String Description, Date Date) {
}
