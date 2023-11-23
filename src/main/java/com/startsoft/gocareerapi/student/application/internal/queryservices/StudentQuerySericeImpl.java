package com.startsoft.gocareerapi.student.application.internal.queryservices;

import com.startsoft.gocareerapi.student.domain.model.agreggates.Student;
import com.startsoft.gocareerapi.student.domain.model.queries.GetStudentByIdQuery;
import com.startsoft.gocareerapi.student.domain.services.StudentQueryService;
import com.startsoft.gocareerapi.student.infrastructure.persistance.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentQuerySericeImpl implements StudentQueryService {

    private final StudentRepository _studentRepository;

    public StudentQuerySericeImpl(StudentRepository studentRepository) {
        _studentRepository = studentRepository;
    }

    @Override
    public Optional<Student> handle(GetStudentByIdQuery query) {
        return _studentRepository.findById(query.studentId());
    }
}
