package com.patient.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String patientId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Patienter patienter;

    private LocalDate hospitalize;
    private LocalDate discharge;
    private String reason;
    private String treatments;
    private String doctor;

    public Patient() {
    }

    public Patient(Integer id, String patientId, Patienter patienter, LocalDate hospitalize, LocalDate discharge, String reason, String treatments, String doctor) {
        this.id = id;
        this.patientId = patientId;
        this.patienter = patienter;
        this.hospitalize = hospitalize;
        this.discharge = discharge;
        this.reason = reason;
        this.treatments = treatments;
        this.doctor = doctor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Patienter getPatienter() {
        return patienter;
    }

    public void setPatienter(Patienter patienter) {
        this.patienter = patienter;
    }

    public LocalDate getHospitalize() {
        return hospitalize;
    }

    public void setHospitalize(LocalDate hospitalize) {
        this.hospitalize = hospitalize;
    }

    public LocalDate getDischarge() {
        return discharge;
    }

    public void setDischarge(LocalDate discharge) {
        this.discharge = discharge;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTreatments() {
        return treatments;
    }

    public void setTreatments(String treatments) {
        this.treatments = treatments;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}
