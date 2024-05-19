package com.example.paidservicebackend.repository.staff;

import com.example.paidservicebackend.model.Staff;

import java.util.List;
import java.util.Optional;

public interface StaffRepository {
    List<Staff> findAll();
    Optional<Staff> findById(Integer id);
    Integer save(Staff staff);
    void delete(Integer staffId);
}
