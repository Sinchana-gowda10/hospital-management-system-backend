package com.hospital.management.controller;

import com.hospital.management.dto.PatientDTO;
import com.hospital.management.entity.Patient;
import com.hospital.management.service.PatientService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService service;

    // CREATE PATIENT (Using DTO + Validation)
    @PostMapping
    public Patient createPatient(@Valid @RequestBody PatientDTO dto) {

        Patient patient = new Patient();
        patient.setName(dto.getName());
        patient.setAge(dto.getAge());
        patient.setGender(dto.getGender());
        patient.setContactNumber(dto.getContactNumber());
        patient.setAddress(dto.getAddress());

        return service.createPatient(patient);
    }

    // GET ALL PATIENTS
    @GetMapping
    public List<Patient> getAllPatients() {
        return service.getAllPatients();
    }

    // GET PATIENT BY ID
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return service.getPatientById(id);
    }

    // UPDATE PATIENT (you can later convert this to DTO as well)
    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        return service.updatePatient(id, patient);
    }

    // DELETE PATIENT
    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Long id) {
        service.deletePatient(id);
        return "Patient deleted successfully";
    }
}