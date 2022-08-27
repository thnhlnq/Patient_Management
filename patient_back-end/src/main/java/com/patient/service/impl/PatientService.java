package com.patient.service.impl;

import com.patient.model.Patient;
import com.patient.repository.IPatientRepository;
import com.patient.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {

    @Autowired
    IPatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Optional<Patient> findById(Integer id) {
        return patientRepository.findById(id);
    }

    @Override
    public void edit(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void delete(Integer id) {
        patientRepository.deleteById(id);
    }

}
