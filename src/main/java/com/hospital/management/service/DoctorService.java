package com.hospital.management.service;

import com.hospital.management.entity.Doctor;
import com.hospital.management.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    public Doctor createDoctor(Doctor doctor) {
        return repository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return repository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        Doctor doctor = repository.findById(id).orElse(null);

        if (doctor != null) {
            doctor.setName(updatedDoctor.getName());
            doctor.setSpecialization(updatedDoctor.getSpecialization());
            doctor.setContactNumber(updatedDoctor.getContactNumber());
            doctor.setEmail(updatedDoctor.getEmail());
            return repository.save(doctor);
        }
        return null;
    }

    public void deleteDoctor(Long id) {
        repository.deleteById(id);
    }
}