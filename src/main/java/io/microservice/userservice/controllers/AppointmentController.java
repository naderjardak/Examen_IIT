package io.microservice.userservice.controllers;


import io.microservice.userservice.Service.interfaces.IAppointmentService;
import io.microservice.userservice.entities.Appointment;
import io.microservice.userservice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    IAppointmentService iAppointmentService;

    @PostMapping("/createAppointment")
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        Appointment createdAppointment = iAppointmentService.createAppointment(appointment);
        return ResponseEntity.ok(createdAppointment);
    }

    @GetMapping("/getAllAppointments")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = iAppointmentService.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/getAppointmentById")
    public ResponseEntity<Appointment> getAppointmentById(@RequestParam long id) {
        return iAppointmentService.getAppointmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/updateAppointment")
    public ResponseEntity<Void> updateAppointment(@RequestParam long id, @RequestBody Appointment appointment) {
        appointment.setId(id); // Ensure the correct ID is set
        iAppointmentService.updateAppointment(appointment);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deleteAppointment")
    public ResponseEntity<Void> deleteAppointment(@RequestParam long id) {
        iAppointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/affectAppointment") // Utilisez "Appointment" au lieu de "Oppoitment"
    public User affectAppointment(@RequestParam long idUser, @RequestParam long idAppointment) {
        return iAppointmentService.affectAppointment(idUser, idAppointment); // Utilisez "affectAppointment"
    }

    @GetMapping("/getAppointmentsByUserId")
    public ResponseEntity<List<Appointment>> getAppointmentsByUserId(@RequestParam long userId) {
        List<Appointment> appointmentList = iAppointmentService.getAppointmentsByUserId(userId);
        return ResponseEntity.ok(appointmentList);
    }

}
