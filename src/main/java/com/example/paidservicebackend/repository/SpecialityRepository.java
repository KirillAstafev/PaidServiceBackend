package com.example.paidservicebackend.repository;

import com.example.paidservicebackend.model.Speciality;

import java.util.List;

public interface SpecialityRepository {
    List<Speciality> findAll();
    Integer save(Speciality speciality);
    void update(Speciality speciality);
    void delete(Integer specialityId);
}
