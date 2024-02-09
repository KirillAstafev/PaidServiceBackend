package com.example.paidservicebackend.model;

import java.util.Date;

public class Visitation {
    private Integer id;
    private Person patient;
    private Staff staff;
    private MedicalService medicalService;
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPatient() {
        return patient;
    }

    public void setPatient(Person patient) {
        this.patient = patient;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public MedicalService getMedicalService() {
        return medicalService;
    }

    public void setMedicalService(MedicalService medicalService) {
        this.medicalService = medicalService;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
