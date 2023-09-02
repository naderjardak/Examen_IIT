package io.microservice.userservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




    @Temporal(TemporalType.TIMESTAMP)
    private Date appointmentDate;

    private boolean isOnline;

    private boolean isFree;

    private String url;

    @JsonIgnore
    @ManyToOne
    private User user;

}
