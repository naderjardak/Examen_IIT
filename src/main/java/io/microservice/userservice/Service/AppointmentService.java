package io.microservice.userservice.Service;

import io.microservice.userservice.entities.Appointment;
import io.microservice.userservice.entities.User;
import io.microservice.userservice.repositories.AppointmentRepository;
import io.microservice.userservice.repositories.UserrRepository;
import io.microservice.userservice.Service.interfaces.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService implements IAppointmentService {



    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    UserrRepository userrRepository;

    @Override
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public User affectAppointment(long idUser, long idAppointment) {
        User user = userrRepository.findById(idUser).get();
        Appointment appointment = appointmentRepository.findById(idAppointment).get();

        // Ajoutez le rendez-vous à la liste des rendez-vous de l'utilisateur
        user.getAppointment().add(appointment);

        // Sauvegardez l'utilisateur mis à jour
        return userrRepository.save(user);
    }

    @Override
   public List<Appointment> getAppointmentsByUserId(long userId) {
       return appointmentRepository.findByUserId(userId);
   }



}
