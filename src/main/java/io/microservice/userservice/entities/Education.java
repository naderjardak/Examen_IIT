package io.microservice.userservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.microservice.userservice.entities.enmus.EducationType;
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
public class Education implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EducationType educationType;

    @JsonIgnore
    @ManyToOne
    private Detail detailE;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
