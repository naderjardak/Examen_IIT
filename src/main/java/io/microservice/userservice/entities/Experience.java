package io.microservice.userservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.microservice.userservice.entities.enmus.ExperienceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Experience implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ExperienceType experienceType;

    @JsonIgnore
    @ManyToOne
    private Detail detail;

    @JsonIgnore
    @OneToOne
    private User user;

}
