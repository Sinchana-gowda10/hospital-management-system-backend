package com.hospital.management.service;

import com.hospital.management.entity.Patient;
import com.hospital.management.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public Patient createPatient(Patient patient) {
        return repository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return repository.findAll();
    }

    public Patient getPatientById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Patient updatePatient(Long id, Patient updatedPatient) {
        Patient patient = repository.findById(id).orElse(null);

        if (patient != null) {
            patient.setName(updatedPatient.getName());
            patient.setAge(updatedPatient.getAge());
            patient.setGender(updatedPatient.getGender());
            patient.setContactNumber(updatedPatient.getContactNumber());
            patient.setAddress(updatedPatient.getAddress());
            return repository.save(patient);
        }
        return null;
    }

    public void deletePatient(Long id) {
        repository.deleteById(id);
    }
}