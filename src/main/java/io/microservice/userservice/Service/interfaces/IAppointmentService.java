package io.microservice.userservice.Service.interfaces;

import io.microservice.userservice.entities.Appointment;
import io.microservice.userservice.entities.User;

import java.util.List;
import java.util.Optional;

public interface IAppointmentService {
    Appointment createAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
    Optional<Appointment> getAppointmentById(Long id);
    void updateAppointment(Appointment appointment);
    void deleteAppointment(Long id);


    User affectAppointment(long idUser, long idAppointment);

    List<Appointment> getAppointmentsByUserId(long userId);
}
