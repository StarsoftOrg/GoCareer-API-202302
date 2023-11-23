package com.startsoft.gocareerapi.student.infrastructure.persistance.jpa.repositories;

import com.startsoft.gocareerapi.student.domain.model.agreggates.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}
