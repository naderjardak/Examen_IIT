package io.microservice.userservice.entities;

import io.microservice.userservice.entities.enmus.DetailType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Detail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String speciality;

    private int yearsOfExperience;

    @Column(length = 1000)
    private String biography;

    @Enumerated(EnumType.STRING)
    private DetailType detailType;

    @OneToMany(mappedBy = "detail")
    private List<Experience> experiences;

    @OneToMany(mappedBy = "detailL")
    private List<Language> languages;

    @OneToMany(mappedBy = "detailE")
    private List<Education> educations;

    @JsonIgnore
    @OneToOne(mappedBy = "detailU")
    private User user;

    private String advantage;
}
