package com.patient.dto;

import com.patient.model.Patienter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class PatientDto {

    private Integer id;

    @NotBlank(message = "Can't Not Blank !!")
    private String patientId;

    @NotBlank(message = "Can't Not Blank !!")
    private Patienter patienter;

    @NotBlank(message = "Can't Not Blank !!")
    private LocalDate hospitalize;

    @NotBlank(message = "Can't Not Blank !!")
    private LocalDate discharge;

    @NotBlank(message = "Can't Not Blank !!")
    private String reason;

    @NotBlank(message = "Can't Not Blank !!")
    private String treatments;

    @NotBlank(message = "Can't Not Blank !!")
    private String doctor;

    public PatientDto() {
    }

    public PatientDto(Integer id, String patientId, Patienter patienter, LocalDate hospitalize, LocalDate discharge, String reason, String treatments, String doctor) {
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
