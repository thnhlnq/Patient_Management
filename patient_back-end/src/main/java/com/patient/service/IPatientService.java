package com.patient.service;

import com.patient.model.Patient;

import java.util.List;
import java.util.Optional;

public interface IPatientService {

    List<Patient> findAll();

    void save(Patient patient);

    Optional<Patient> findById(Integer id);

    void edit(Patient patient);

    void delete(Integer id);

    List<Patient> page(Integer page);

    List<Patient> search(String patienter, String reason, String treatments, String doctor, Integer page);
}
