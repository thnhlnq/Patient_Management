package com.patient.service.impl;

import com.patient.model.Patienter;
import com.patient.repository.IPatienterRepository;
import com.patient.service.IPatienterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatienterService implements IPatienterService {

    @Autowired
    IPatienterRepository patienterRepository;

    @Override
    public List<Patienter> findAll() {
        return patienterRepository.findAll();
    }

    @Override
    public Optional<Patienter> findById(Integer id) {
        return patienterRepository.findById(id);
    }
}
