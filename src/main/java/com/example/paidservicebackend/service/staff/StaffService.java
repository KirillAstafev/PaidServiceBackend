package com.example.paidservicebackend.service.staff;

import com.example.paidservicebackend.model.Staff;

public interface StaffService {
    Staff findById(Integer id);
    Integer save(Staff staff);
    void delete(Integer staffId);
}
