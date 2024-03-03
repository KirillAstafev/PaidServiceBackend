package com.example.paidservicebackend.service.staff.impl;

import com.example.paidservicebackend.model.Staff;
import com.example.paidservicebackend.repository.staff.StaffRepository;
import com.example.paidservicebackend.service.staff.StaffService;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;

    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public Staff findById(Integer id) {
        return staffRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Integer save(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public void delete(Integer staffId) {
        staffRepository.delete(staffId);
    }
}
