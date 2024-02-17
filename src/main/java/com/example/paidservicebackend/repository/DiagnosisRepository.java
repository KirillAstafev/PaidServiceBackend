package com.example.paidservicebackend.repository;

import com.example.paidservicebackend.model.Diagnosis;

import java.util.List;

public interface DiagnosisRepository {
    List<Diagnosis> findAll();

    Integer save(Diagnosis diagnosis);

    void update(Diagnosis diagnosis);

    void delete(Integer diagnosisId);
}
