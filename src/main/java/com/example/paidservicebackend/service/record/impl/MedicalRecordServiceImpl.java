package com.example.paidservicebackend.service.record.impl;

import com.example.paidservicebackend.model.MedicalRecord;
import com.example.paidservicebackend.repository.record.MedicalRecordRepository;
import com.example.paidservicebackend.service.record.MedicalRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {
    private final MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordServiceImpl(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    @Override
    public List<MedicalRecord> findByPatientId(Integer patientId) {
        return medicalRecordRepository.findByPatientId(patientId);
    }

    @Override
    public Integer save(MedicalRecord record) {
        return medicalRecordRepository.save(record);
    }

    @Override
    public void update(MedicalRecord record) {
        medicalRecordRepository.update(record);
    }

    @Override
    public void delete(Integer recordId) {
        medicalRecordRepository.delete(recordId);
    }
}
