package com.startsoft.gocareerapi.student.domain.model.agreggates;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Getter;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    private String FirstName;

    @Getter
    private String LastName;

    @Getter
    @Email
    private String Email;


    public Student() {
    }


    public Student (String FirstName, String LastName, String Email){
        if (FirstName == null) {
            throw new IllegalArgumentException("FirstName can not be null");
        }

        if (LastName == null) {
            throw new IllegalArgumentException("LastName can not be null");
        }

        if (Email == null) {
            throw new IllegalArgumentException("Email can not be null");
        }

        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
    }

}
