package com.startsoft.gocareerapi.student.domain.services;

import com.startsoft.gocareerapi.student.domain.model.agreggates.Student;
import com.startsoft.gocareerapi.student.domain.model.queries.GetStudentByIdQuery;

import java.util.Optional;

public interface StudentQueryService {
    Optional<Student> handle(GetStudentByIdQuery query);
}
