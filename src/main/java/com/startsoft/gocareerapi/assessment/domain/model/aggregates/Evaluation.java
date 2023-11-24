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
    private String Title;

    @Getter
    private String Description;

    @Getter
    private int numberQuestions;

//    @Getter
//    @OneToMany(mappedBy = "vocacionalTest")
//    private List<Question> Questions;


    public Evaluation(String Title, String Description, int numberQuestions) {
        if (Title == null || Title.isBlank() ) {
            throw new IllegalArgumentException("Title can not be null");
        }
        if (Description == null || Description.isBlank() ) {
            throw new IllegalArgumentException("Description can not be null");
        }
        if (numberQuestions <= 0 ) {
            throw new IllegalArgumentException("numberQuestions can not be null");
        }

        this.Title = Title;
        this.Description = Description;
        this.numberQuestions = numberQuestions;
    }

    public Evaluation() {

    }
}
