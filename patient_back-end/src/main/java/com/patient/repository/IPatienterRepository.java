package com.patient.repository;

import com.patient.model.Patienter;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IPatienterRepository extends JpaRepository<Patienter, Integer> {
}
