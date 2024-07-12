package com.startsoft.gocareerapi.student.domain.model.agreggates;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;


@Entity
public class Meeting {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    String title;

    @Getter
    String description;

    /**
     * The date of the metting.
     */
    @Getter
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date date;

    public Meeting() {
    }


    public Meeting(String title, String description, Date date){
        if (title == null || title.isBlank() ) {
            throw new IllegalArgumentException("Title can not be null");
        }

        if (description == null || description.isBlank() ) {
            throw new IllegalArgumentException("Description can not be null");
        }

        if (date == null ) {
            throw new IllegalArgumentException("Date can not be null");
        }

        this.title = title;
        this.description = description;
        this.date = date;

    }
}
