package com.example.paidservicebackend.repository.staff;

import com.example.paidservicebackend.model.Staff;

import java.util.Optional;

public interface StaffRepository {
    Optional<Staff> findById(Integer id);
    Integer save(Staff staff);
    void delete(Integer staffId);
}
