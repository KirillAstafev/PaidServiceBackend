package com.example.paidservicebackend.repository.service;

import com.example.paidservicebackend.model.MedicalService;

import java.util.List;

public interface MedicalServiceRepository {
    List<MedicalService> findAll();
    Integer save(MedicalService service);
    void update(MedicalService service);
    void delete(Integer serviceId);
}
