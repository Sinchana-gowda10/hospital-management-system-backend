package com.hospital.management.controller;

import com.hospital.management.entity.Appointment;
import com.hospital.management.service.AppointmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping
    public Appointment createAppointment(
            @RequestParam Long patientId,
            @RequestParam Long doctorId,
            @RequestBody Appointment appointment) {

        return service.createAppointment(patientId, doctorId, appointment);
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return service.getAllAppointments();
    }

    @GetMapping("/{id}")
    public Appointment getAppointment(@PathVariable Long id) {
        return service.getAppointmentById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        service.deleteAppointment(id);
        return "Appointment deleted";
    }
}