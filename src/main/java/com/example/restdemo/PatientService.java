package com.example.restdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public void saveOrUpdate(Patient patient) {
        patientRepository.save(patient);
    }

    public void delete(Long id) {
        patientRepository.deleteById(id);
    }
}
