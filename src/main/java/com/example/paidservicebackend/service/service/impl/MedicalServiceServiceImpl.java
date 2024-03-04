package com.example.paidservicebackend.service.service.impl;

import com.example.paidservicebackend.model.MedicalService;
import com.example.paidservicebackend.repository.service.MedicalServiceRepository;
import com.example.paidservicebackend.service.service.MedicalServiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalServiceServiceImpl implements MedicalServiceService {
    private final MedicalServiceRepository serviceRepository;

    public MedicalServiceServiceImpl(MedicalServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<MedicalService> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Integer save(MedicalService service) {
        return serviceRepository.save(service);
    }

    @Override
    public void update(MedicalService service) {
        serviceRepository.update(service);
    }

    @Override
    public void delete(Integer serviceId) {
        serviceRepository.delete(serviceId);
    }
}
