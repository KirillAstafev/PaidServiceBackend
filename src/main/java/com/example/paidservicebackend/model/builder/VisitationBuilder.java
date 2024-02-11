package com.example.paidservicebackend.model.builder;

import com.example.paidservicebackend.model.MedicalService;
import com.example.paidservicebackend.model.Person;
import com.example.paidservicebackend.model.Staff;
import com.example.paidservicebackend.model.Visitation;

import java.time.LocalDateTime;

public final class VisitationBuilder {
    private Integer id;
    private Person patient;
    private Staff staff;
    private MedicalService medicalService;
    private LocalDateTime dateTime;

    private VisitationBuilder() {
    }

    public static VisitationBuilder builder() {
        return new VisitationBuilder();
    }

    public VisitationBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public VisitationBuilder patient(Person patient) {
        this.patient = patient;
        return this;
    }

    public VisitationBuilder staff(Staff staff) {
        this.staff = staff;
        return this;
    }

    public VisitationBuilder medicalService(MedicalService medicalService) {
        this.medicalService = medicalService;
        return this;
    }

    public VisitationBuilder dateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public Visitation build() {
        Visitation visitation = new Visitation();
        visitation.setId(id);
        visitation.setPatient(patient);
        visitation.setStaff(staff);
        visitation.setMedicalService(medicalService);
        visitation.setDateTime(dateTime);
        return visitation;
    }
}
