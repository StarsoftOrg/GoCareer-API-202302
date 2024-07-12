package com.startsoft.gocareerapi.assessment.domain.model.aggregates;
import jakarta.persistence.*;
import lombok.Getter;



@Entity
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    private String title;

    @Getter
    private String description;

    @Getter
    private int numberQuestions;

//    @Getter
//    @OneToMany(mappedBy = "vocacionalTest")
//    private List<Question> Questions;


    public Evaluation(String title, String description, int numberQuestions) {
        if (title == null || title.isBlank() ) {
            throw new IllegalArgumentException("Title can not be null");
        }
        if (description == null || description.isBlank() ) {
            throw new IllegalArgumentException("Description can not be null");
        }
        if (numberQuestions <= 0 ) {
            throw new IllegalArgumentException("numberQuestions can not be null");
        }

        this.title = title;
        this.description = description;
        this.numberQuestions = numberQuestions;
    }

    public Evaluation() {

    }
}
