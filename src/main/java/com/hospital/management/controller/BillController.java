package com.hospital.management.controller;

import com.hospital.management.entity.Bill;
import com.hospital.management.service.BillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private BillService service;

    @PostMapping
    public Bill createBill(
            @RequestParam Long patientId,
            @RequestParam Long appointmentId,
            @RequestBody Bill bill) {

        return service.createBill(patientId, appointmentId, bill);
    }

    @GetMapping
    public List<Bill> getAllBills() {
        return service.getAllBills();
    }

    @GetMapping("/{id}")
    public Bill getBill(@PathVariable Long id) {
        return service.getBillById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteBill(@PathVariable Long id) {
        service.deleteBill(id);
        return "Bill deleted";
    }
}