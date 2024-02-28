package com.example.paidservicebackend.repository;

import com.example.paidservicebackend.model.Staff;

import java.util.Optional;

public interface StaffRepository {
    Optional<Staff> findById(Integer id);
    Integer save(Staff staff);
    void update(Staff staff);
    void delete(Integer staffId);
}
