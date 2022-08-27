package com.patient.dto;

import com.patient.model.Patient;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class PatienterDto {

    private Integer id;

    private String patienterId;

    @NotBlank(message = "Can't Not Blank !!")
    @Pattern(regexp = "^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$", message = "Patienter Name Incorrect Format !!")
    private String patienterName;

    private Set<Patient> patient;

    public PatienterDto() {
    }

    public PatienterDto(Integer id, String patienterId, String patienterName, Set<Patient> patient) {
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
