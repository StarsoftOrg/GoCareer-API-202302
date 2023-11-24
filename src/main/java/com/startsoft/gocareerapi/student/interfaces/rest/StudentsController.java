package com.startsoft.gocareerapi.student.interfaces.rest;

import com.startsoft.gocareerapi.student.domain.model.queries.GetStudentByIdQuery;
import com.startsoft.gocareerapi.student.domain.services.StudentQueryService;
import com.startsoft.gocareerapi.student.interfaces.rest.resources.StudentResource;
import com.startsoft.gocareerapi.student.interfaces.rest.transform.StudentResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/students", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Students", description = "Student Management Endpoints")
public class StudentsController {
    private final StudentQueryService studentQueryService;

    public StudentsController(StudentQueryService studentQueryService) {
        this.studentQueryService = studentQueryService;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentResource> getStudentBydId(@PathVariable Long studentId) {
        var getStudentByIdQuery = new GetStudentByIdQuery(studentId);
        var student = studentQueryService.handle(getStudentByIdQuery);
        if (student.isEmpty()) return ResponseEntity.notFound().build();
        var studentResource = StudentResourceFromEntityAssembler.toResourceFromEntity(student.get());
        return ResponseEntity.ok(studentResource);
    }


}
