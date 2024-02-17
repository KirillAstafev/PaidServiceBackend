package com.example.paidservicebackend.service;

import com.example.paidservicebackend.model.Diagnosis;

import java.util.List;

public interface DiagnosisService {
    List<Diagnosis> findAll();
    Integer save(Diagnosis diagnosis);
    void update(Diagnosis diagnosis);
    void delete(Integer diagnosisId);
}
