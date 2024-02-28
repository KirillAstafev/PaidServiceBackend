package com.example.paidservicebackend.repository.record;

import com.example.paidservicebackend.model.MedicalRecord;

import java.util.List;

public interface MedicalRecordRepository {
    List<MedicalRecord> findByPatientId(Integer patientId);

    Integer save(MedicalRecord record);

    void update(MedicalRecord record);

    void delete(Integer recordId);
}
