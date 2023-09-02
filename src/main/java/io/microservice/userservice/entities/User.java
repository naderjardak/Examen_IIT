package io.microservice.userservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String UserName;

    private String address;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    private String email;

    private String PhoneNumber;

    private String password;

    private boolean TokenExpired;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfCreation;

    private String imageUrl;

    private String resetToken;

    @ManyToOne
    private Role role;

    @OneToOne
    private Detail detailU;

    @OneToMany
    private List<Appointment> appointment;

    @OneToMany
    private List<Education> educationlist;

    @OneToOne
    private  Experience experience;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Blog> blogList;

}


