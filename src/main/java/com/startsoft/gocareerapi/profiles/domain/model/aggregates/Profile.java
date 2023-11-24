package com.startsoft.gocareerapi.profiles.domain.model.aggregates;

import com.startsoft.gocareerapi.profiles.domain.model.valueobjects.EmailAddress;
import com.startsoft.gocareerapi.profiles.domain.model.valueobjects.IsSpecialist;
import com.startsoft.gocareerapi.profiles.domain.model.valueobjects.PersonDescription;
import com.startsoft.gocareerapi.profiles.domain.model.valueobjects.PersonName;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Profile extends AbstractAggregateRoot<Profile> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Embedded
    private PersonName name;

    @Embedded
    private EmailAddress email;

    @Embedded
    private IsSpecialist specialist;

    @Embedded
    private PersonDescription description;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;


    public Profile(String fistName, String lastName, String email, String description, Boolean specialist){
        this.name = new PersonName(fistName,lastName);
        this.email = new EmailAddress(email);
        this.specialist = new IsSpecialist(specialist);
        this.description = new PersonDescription(description);
    }

    public Profile(){}

    public void updateName(String firstName, String lastName){
        this.name = new PersonName(firstName,lastName);
    }

    public void updateEmail(String email){
        this.email = new EmailAddress(email);
    }

    public void updateRole(Boolean role){
        this.specialist = new IsSpecialist(role);
    }

    public String getFullName(){
        return name.getPersonName();
    }

    public String getEmailAddress(){ return email.address();}

    public String getDescription(){
        return description.getPersonDescription();
    }

    public Boolean getRole(){
        return specialist.isSpecialist();
    }

}