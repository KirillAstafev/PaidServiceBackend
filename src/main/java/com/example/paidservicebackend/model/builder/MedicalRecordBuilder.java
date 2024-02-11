package com.example.paidservicebackend.model.builder;

import com.example.paidservicebackend.model.Diagnosis;
import com.example.paidservicebackend.model.MedicalRecord;
import com.example.paidservicebackend.model.Person;
import com.example.paidservicebackend.model.Staff;

import java.time.LocalDate;

public final class MedicalRecordBuilder {
    private Integer id;
    private Person patient;
    private Staff staff;
    private LocalDate date;
    private Diagnosis diagnosis;
    private String note;

    private MedicalRecordBuilder() {
    }

    public static MedicalRecordBuilder builder() {
        return new MedicalRecordBuilder();
    }

    public MedicalRecordBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public MedicalRecordBuilder patient(Person patient) {
        this.patient = patient;
        return this;
    }

    public MedicalRecordBuilder staff(Staff staff) {
        this.staff = staff;
        return this;
    }

    public MedicalRecordBuilder date(LocalDate date) {
        this.date = date;
        return this;
    }

    public MedicalRecordBuilder diagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
        return this;
    }

    public MedicalRecordBuilder note(String note) {
        this.note = note;
        return this;
    }

    public MedicalRecord build() {
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setId(id);
        medicalRecord.setPatient(patient);
        medicalRecord.setStaff(staff);
        medicalRecord.setDate(date);
        medicalRecord.setDiagnosis(diagnosis);
        medicalRecord.setNote(note);
        return medicalRecord;
    }
}
