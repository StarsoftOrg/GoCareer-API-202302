package com.startsoft.gocareerapi.assessment.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Question {
    @jakarta.persistence.Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

//    @ManyToOne
//    @JoinColumn(name = "voacational_test_id")
//    private VocacionalTest vocacionalTest;

    @Getter
    private String Title;

    public Question() {
    }

    public Question(String Title) {
        if (Title == null || Title.isBlank() ) {
            throw new IllegalArgumentException("Title can not be null");
        }
        this.Title = Title;
    }

}
