package com.patient.service;

import com.patient.model.Patienter;

import java.util.List;
import java.util.Optional;

public interface IPatienterService {

    List<Patienter> findAll();

    void save(Patienter patienter);

    Optional<Patienter> findById(Integer id);

    void edit(Patienter patienter);
}
