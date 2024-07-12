package com.startsoft.gocareerapi.assessment.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Question {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "voacational_test_id")
//    private VocacionalTest vocacionalTest;

    @Getter
    private String title;

    public Question() {
    }

    public Question(String title) {
        if (title == null || title.isBlank() ) {
            throw new IllegalArgumentException("Title can not be null");
        }
        this.title = title;
    }

}
