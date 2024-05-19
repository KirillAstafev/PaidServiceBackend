package com.example.paidservicebackend.service.staff;

import com.example.paidservicebackend.model.Staff;

import java.util.List;

public interface StaffService {
    List<Staff> findAll();
    Staff findById(Integer id);
    Integer save(Staff staff);
    void delete(Integer staffId);
}
