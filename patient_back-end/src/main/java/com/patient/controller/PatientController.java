package com.patient.controller;

import com.patient.model.Patient;
import com.patient.service.IPatientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/patient")
public class PatientController {

    @Autowired
    IPatientService patientService;

    @GetMapping("")
    public ResponseEntity<List<Patient>> getPatient() {
        List<Patient> patients = patientService.findAll();
        if (patients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Patient> create(@RequestBody Patient patient) {
        patientService.save(patient);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Patient>> findById(@PathVariable Integer id) {
        Optional<Patient> patient = patientService.findById(id);
        if (!patient.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> edit(@PathVariable Integer id, @RequestBody Patient patient) {
        Optional<Patient> patients = patientService.findById(id);
        if (!patients.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        BeanUtils.copyProperties(patient, patients.get());
        patientService.edit(patients.get());
        return new ResponseEntity<>(patients.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Patient> delete(@PathVariable Integer id) {
        Optional<Patient> patient = patientService.findById(id);
        if (!patient.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        patientService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
