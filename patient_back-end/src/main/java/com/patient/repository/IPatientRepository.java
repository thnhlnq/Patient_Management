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
    void save(@Param("patientId") String patientId, @Param("patienterId") String patienterId, @Param("hospitalize") LocalDate hospitalize, @Param("discharge") LocalDate discharge, @Param("reason") String reason, @Param("treatments") String treatments, @Param("doctor") String doctor);

    @Query(value = "select * from patient where id = :id", nativeQuery = true)
    Optional<Patient> findById(@Param("id") Integer id);

    @Modifying
    @Query(value = "update patient set patient_id = :patientId, patienter_id = :patienterId, hospitalize = :hospitalize, discharge = :discharge, reason = :reason, treatments = :treatments, doctor = :doctor where id = :id", nativeQuery = true)
    void edit(@Param("patientId") String patientId, @Param("patienterId") String patienterId, @Param("hospitalize") LocalDate hospitalize, @Param("discharge") LocalDate discharge, @Param("reason") String reason, @Param("treatments") String treatments, @Param("doctor") String doctor, @Param("id") Integer id);

    @Modifying
    @Query(value = "delete from patient where id = :id", nativeQuery = true)
    void delete(@Param("id") Integer id);
//
//    @Query(value = "select * from blog where name like :nameFind", nativeQuery = true)
//    Page<Blog> findByNameContaining(@Param("nameFind") String nameFind, Pageable pageable);

//    @Query(value = "select * from patient", nativeQuery = true)
//    List<Patient> findAll();
//
//    @Query(value = "select * from patient where id = :id", nativeQuery = true)
//    Optional<Patient> findById(@Param("id") Integer id);
//
//    @Modifying
//    @Transactional
//    @Query(value = "insert into patient(patienter_id, day_in, day_out, reason, method, doctor) values (:patienterId, :dayIn, :dayOut, :reason, :method, :doctor );", nativeQuery = true)
//    void save(@Param("patienterId") Integer patienterId, @Param("dayIn") LocalDate dayIn, @Param("dayOut") LocalDate dayOut, @Param("reason") String reason, @Param("method") String method, @Param("doctor") String doctor);
//
//    @Transactional
//    @Modifying
//    @Query(value = "update patient set day_in = :dayIn, day_out = :dayOut, reason = :reason, method = :method, doctor = :doctor where id = :id", nativeQuery = true)
//    void update(@Param("dayIn") LocalDate dayIn, @Param("dayOut") LocalDate dayOut, @Param("reason") String reason, @Param("method") String method, @Param("doctor") String doctor, @Param("id") Integer id);
//
//    @Modifying
//    @Transactional
//    @Query(value = "delete from patient where id = :id", nativeQuery = true)
//    void delete(@Param("id") Integer id);
}
