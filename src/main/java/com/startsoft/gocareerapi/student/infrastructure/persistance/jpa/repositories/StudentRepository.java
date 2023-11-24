package com.startsoft.gocareerapi.student.infrastructure.persistance.jpa.repositories;

import com.startsoft.gocareerapi.student.domain.model.agreggates.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
