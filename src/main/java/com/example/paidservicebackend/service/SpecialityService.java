package com.example.paidservicebackend.service;

import com.example.paidservicebackend.model.Speciality;

import java.util.List;

public interface SpecialityService {
    List<Speciality> findAll();
    Integer save(Speciality speciality);
    void update(Speciality speciality);
    void delete(Integer specialityId);
}
