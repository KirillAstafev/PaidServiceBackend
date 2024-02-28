package com.example.paidservicebackend.service.record;

import com.example.paidservicebackend.model.MedicalRecord;

import java.util.List;

public interface MedicalRecordService {
    List<MedicalRecord> findByPatientId(Integer patientId);
    Integer save(MedicalRecord record);
    void update(MedicalRecord record);
    void delete(Integer recordId);
}
