package io.microservice.userservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.microservice.userservice.entities.enmus.TargetType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Targets implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TargetType targetType ;

    @JsonIgnore
    @ManyToOne
    private User user;
}
