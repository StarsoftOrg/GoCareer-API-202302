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
    private Long Id;

    @Getter
    String Title;

    @Getter
    String Description;

    /**
     * The date of the metting.
     */
    @Getter
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date Date;

    public Meeting() {
    }


    public Meeting(String Title, String Description, Date Date){
        if (Title == null || Title.isBlank() ) {
            throw new IllegalArgumentException("Title can not be null");
        }

        if (Description == null || Description.isBlank() ) {
            throw new IllegalArgumentException("Description can not be null");
        }

        if (Date == null ) {
            throw new IllegalArgumentException("Date can not be null");
        }

        this.Title = Title;
        this.Description = Description;
        this.Date = Date;

    }
}
