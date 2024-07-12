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
    private String firstName;

    @Getter
    private String lastName;

    @Getter
    @Email
    private String email;


    public Student() {
    }


    public Student (String firstName, String lastName, String email){
        if (firstName == null) {
            throw new IllegalArgumentException("FirstName can not be null");
        }

        if (lastName == null) {
            throw new IllegalArgumentException("LastName can not be null");
        }

        if (email == null) {
            throw new IllegalArgumentException("Email can not be null");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}
