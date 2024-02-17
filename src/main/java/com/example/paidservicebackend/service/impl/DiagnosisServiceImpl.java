package com.example.paidservicebackend.service.impl;

import com.example.paidservicebackend.model.Diagnosis;
import com.example.paidservicebackend.repository.DiagnosisRepository;
import com.example.paidservicebackend.service.DiagnosisService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {
    private final DiagnosisRepository diagnosisRepository;

    public DiagnosisServiceImpl(DiagnosisRepository diagnosisRepository) {
        this.diagnosisRepository = diagnosisRepository;
    }

    @Override
    public List<Diagnosis> findAll() {
        return diagnosisRepository.findAll();
    }

    @Override
    public Integer save(Diagnosis diagnosis) {
        return diagnosisRepository.save(diagnosis);
    }

    @Override
    public void update(Diagnosis diagnosis) {
        diagnosisRepository.update(diagnosis);
    }

    @Override
    public void delete(Integer diagnosisId) {
        diagnosisRepository.delete(diagnosisId);
    }
}
