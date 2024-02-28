package com.example.paidservicebackend.service.impl;

import com.example.paidservicebackend.model.Staff;
import com.example.paidservicebackend.repository.StaffRepository;
import com.example.paidservicebackend.service.StaffService;
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
    public void update(Staff staff) {
        staffRepository.update(staff);
    }

    @Override
    public void delete(Integer staffId) {
        staffRepository.delete(staffId);
    }
}
