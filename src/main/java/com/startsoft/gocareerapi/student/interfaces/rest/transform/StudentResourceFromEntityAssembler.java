package com.startsoft.gocareerapi.student.interfaces.rest.transform;

import com.startsoft.gocareerapi.student.domain.model.agreggates.Student;
import com.startsoft.gocareerapi.student.interfaces.rest.resources.StudentResource;

public class StudentResourceFromEntityAssembler {
    public static StudentResource toResourceFromEntity(Student entity) {
        return new StudentResource(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getEmail());
    }
}
