package com.patient.controller;

import com.patient.model.Patienter;
import com.patient.service.IPatienterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/patienter")
public class PatienterController {

    @Autowired
    IPatienterService patienterService;

    @GetMapping()
    public ResponseEntity<List<Patienter>> getList() {
        List<Patienter> patienter = patienterService.findAll();
        if (patienter.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(patienter, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Patienter>> findById(@PathVariable Integer id) {
        Optional<Patienter> patienter = patienterService.findById(id);
        if (!patienter.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(patienter, HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity save(@RequestBody Patienter patienter) {
//        patienterService.save(patienter);
//        return new ResponseEntity(HttpStatus.OK);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Patienter> update(@PathVariable Integer id, @RequestBody Patienter patienter) {
//        Optional<Patienter> patienters = patienterService.findById(id);
//        if (!patienters.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        patienterService.edit(patienters);
//        return new ResponseEntity<>(patienters, HttpStatus.OK);
//    }
}
