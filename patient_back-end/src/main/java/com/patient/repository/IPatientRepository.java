package com.patient.repository;

import com.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional
public interface IPatientRepository extends JpaRepository<Patient, Integer> {

    @Query(value = "select * from patient", nativeQuery = true)
    List<Patient> findAll();

    @Modifying
    @Query(value = "insert into patient (patient_id, patienter_id, hospitalize, discharge, reason, treatments, doctor) values (:patientId, :patienterId, :hospitalize, :discharge, :reason, :treatments, :doctor)", nativeQuery = true)
    void save(@Param("patientId") String patientId, @Param("patienterId") Integer patienterId, @Param("hospitalize") LocalDate hospitalize, @Param("discharge") LocalDate discharge, @Param("reason") String reason, @Param("treatments") String treatments, @Param("doctor") String doctor);

    @Query(value = "select * from patient where id = :id", nativeQuery = true)
    Optional<Patient> findById(@Param("id") Integer id);

    @Modifying
    @Query(value = "update patient set patient_id = :patientId, patienter_id = :patienterId, hospitalize = :hospitalize, discharge = :discharge, reason = :reason, treatments = :treatments, doctor = :doctor where id = :id", nativeQuery = true)
    void edit(@Param("patientId") String patientId, @Param("patienterId") Integer patienterId, @Param("hospitalize") LocalDate hospitalize, @Param("discharge") LocalDate discharge, @Param("reason") String reason, @Param("treatments") String treatments, @Param("doctor") String doctor, @Param("id") Integer id);

    @Modifying
    @Query(value = "delete from patient where id = :id", nativeQuery = true)
    void delete(@Param("id") Integer id);

    @Query(value = "select * from patient limit :page, 5", nativeQuery = true)
    List<Patient> page(@Param("page") Integer page);

    @Query(value = "select patient.* from patient join patienter on patient.patienter_id = patienter.id where patienter.patienter_name like :patienter_name or patient.reason like :reason or patient.treatments like :treatments or patient.doctor like :doctor limit :page, 5", nativeQuery = true)
    List<Patient> search(@Param("patienter_name") String patienter_name, @Param("reason") String reason, @Param("treatments") String treatments, @Param("doctor") String doctor, @Param("page") Integer page);

}
