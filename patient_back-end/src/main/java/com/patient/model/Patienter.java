package com.patient.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Patienter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String patienterId;
    private String patienterName;

    @JsonBackReference
    @OneToMany(mappedBy = "patienter")
    private Set<Patient> patient;

    public Patienter() {
    }

    public Patienter(Integer id, String patienterId, String patienterName, Set<Patient> patient) {
        this.id = id;
        this.patienterId = patienterId;
        this.patienterName = patienterName;
        this.patient = patient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatienterId() {
        return patienterId;
    }

    public void setPatienterId(String patienterId) {
        this.patienterId = patienterId;
    }

    public String getPatienterName() {
        return patienterName;
    }

    public void setPatienterName(String patienterName) {
        this.patienterName = patienterName;
    }

    public Set<Patient> getPatient() {
        return patient;
    }

    public void setPatient(Set<Patient> patient) {
        this.patient = patient;
    }
}
