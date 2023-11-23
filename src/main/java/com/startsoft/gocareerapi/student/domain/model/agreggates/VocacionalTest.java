package com.startsoft.gocareerapi.student.domain.model.agreggates;

import com.startsoft.gocareerapi.student.domain.model.entities.Question;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;


@Entity
public class VocacionalTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    private String Title;

    @Getter
    @OneToMany(mappedBy = "vocacionalTest")
    private List<Question> Questions;

}
