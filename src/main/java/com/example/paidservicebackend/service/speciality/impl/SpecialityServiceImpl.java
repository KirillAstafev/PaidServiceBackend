package com.example.paidservicebackend.service.speciality.impl;

import com.example.paidservicebackend.model.Speciality;
import com.example.paidservicebackend.repository.speciality.SpecialityRepository;
import com.example.paidservicebackend.service.speciality.SpecialityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityServiceImpl implements SpecialityService {
    private final SpecialityRepository specialityRepository;

    public SpecialityServiceImpl(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public List<Speciality> findAll() {
        return specialityRepository.findAll();
    }

    @Override
    public Integer save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public void update(Speciality speciality) {
        specialityRepository.update(speciality);
    }

    @Override
    public void delete(Integer specialityId) {
        specialityRepository.delete(specialityId);
    }
}
