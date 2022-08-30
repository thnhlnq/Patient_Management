package com.patient.repository;

import com.patient.model.Patienter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IPatienterRepository extends JpaRepository<Patienter, Integer> {

    @Query(value = "select * from patienter", nativeQuery = true)
    List<Patienter> findAll();
    
    @Modifying
    @Query(value = "insert into patienter (patienter_id, patienter_name) values (:patienterId, :patienterName) ", nativeQuery = true)
    void save(@Param("patienterId") String patienterId, @Param("patienterName") String patienterName);

    @Modifying
    @Query(value = "update patienter set patienter_id = :patienterId, patienter_name = :patienterName where id = :id", nativeQuery = true)
    void edit(@Param("patienterId") String patienterId, @Param("patienterName") String patienterName, @Param("id") Integer id);
}
