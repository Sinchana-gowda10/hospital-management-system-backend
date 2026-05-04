package com.hospital.management.service;

import com.hospital.management.entity.*;
import com.hospital.management.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepo;

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private AppointmentRepository appointmentRepo;

    public Bill createBill(Long patientId, Long appointmentId, Bill bill) {

        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Appointment appointment = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        bill.setPatient(patient);
        bill.setAppointment(appointment);

        return billRepo.save(bill);
    }

    public List<Bill> getAllBills() {
        return billRepo.findAll();
    }

    public Bill getBillById(Long id) {
        return billRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found"));
    }

    public void deleteBill(Long id) {
        if (!billRepo.existsById(id)) {
            throw new RuntimeException("Bill not found");
        }
        billRepo.deleteById(id);
    }
}