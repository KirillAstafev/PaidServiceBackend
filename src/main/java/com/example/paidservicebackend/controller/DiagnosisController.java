package com.example.paidservicebackend.controller;

import com.example.paidservicebackend.model.Diagnosis;
import com.example.paidservicebackend.service.diagnosis.DiagnosisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diagnoses")
public class DiagnosisController {
    private final DiagnosisService diagnosisService;

    public DiagnosisController(DiagnosisService diagnosisService) {
        this.diagnosisService = diagnosisService;
    }

    @GetMapping
    public List<Diagnosis> findAll() {
        return diagnosisService.findAll();
    }

    @PostMapping
    public Integer save(@RequestBody Diagnosis diagnosis) {
        return diagnosisService.save(diagnosis);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Diagnosis diagnosis) {
        diagnosisService.update(diagnosis);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        diagnosisService.delete(id);
    }
}
