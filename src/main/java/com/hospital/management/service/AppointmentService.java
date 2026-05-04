package com.hospital.management.service;

import com.hospital.management.entity.Appointment;
import com.hospital.management.entity.Patient;
import com.hospital.management.entity.Doctor;

import com.hospital.management.repository.AppointmentRepository;
import com.hospital.management.repository.PatientRepository;
import com.hospital.management.repository.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepo;

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private DoctorRepository doctorRepo;

    // CREATE APPOINTMENT
    public Appointment createAppointment(Long patientId, Long doctorId, Appointment appointment) {

        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Doctor doctor = doctorRepo.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        return appointmentRepo.save(appointment);
    }

    // GET ALL APPOINTMENTS
    public List<Appointment> getAllAppointments() {
        return appointmentRepo.findAll();
    }

    // GET APPOINTMENT BY ID
    public Appointment getAppointmentById(Long id) {
        return appointmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    // DELETE APPOINTMENT
    public void deleteAppointment(Long id) {
        if (!appointmentRepo.existsById(id)) {
            throw new RuntimeException("Appointment not found");
        }
        appointmentRepo.deleteById(id);
    }
}