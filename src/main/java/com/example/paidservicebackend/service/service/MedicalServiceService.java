package com.example.paidservicebackend.service.service;

import com.example.paidservicebackend.model.MedicalService;

import java.util.List;

public interface MedicalServiceService {
    List<MedicalService> findAll();
    Integer save(MedicalService service);
    void update(MedicalService service);
    void delete(Integer serviceId);
}
