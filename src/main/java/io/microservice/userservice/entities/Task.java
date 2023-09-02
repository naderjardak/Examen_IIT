package io.microservice.userservice.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String taskName;

        private String taskType;

        @Temporal(TemporalType.TIMESTAMP)
        private Date creationDate;

        @Temporal(TemporalType.TIMESTAMP)
        private Date terminationDate;

        @OneToMany(mappedBy = "task")
        private List<ToDo> toDos;

        @OneToMany(mappedBy = "task")
        private List<Tests> tests;

        @OneToMany
        private List<Games> games;

        @ManyToOne
        private User userToTask;

    }
