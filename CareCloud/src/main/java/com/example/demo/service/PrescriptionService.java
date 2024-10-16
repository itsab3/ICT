package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Prescription;
import com.example.demo.repository.PrescriptionRepository;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    // Add a new prescription
    public Prescription addPrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    // Get all prescriptions
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    // Get a prescription by ID
    public Optional<Prescription> getPrescriptionById(Long id) {
        return prescriptionRepository.findById(id);
    }

    // Update a prescription
    public Prescription updatePrescription(Long id, Prescription prescriptionDetails) {
        Prescription prescription = prescriptionRepository.findById(id).orElseThrow(() -> new RuntimeException("Prescription not found"));
        prescription.setSymptoms(prescriptionDetails.getSymptoms());
        prescription.setDiagnosis(prescriptionDetails.getDiagnosis());
        prescription.setPrescriptionDetails(prescriptionDetails.getPrescriptionDetails());
        return prescriptionRepository.save(prescription);
    }

    // Delete a prescription
    public void deletePrescription(Long id) {
        prescriptionRepository.deleteById(id);
    }
}