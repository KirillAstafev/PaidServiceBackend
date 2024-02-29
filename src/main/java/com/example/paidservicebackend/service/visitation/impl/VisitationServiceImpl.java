package com.example.paidservicebackend.service.visitation.impl;

import com.example.paidservicebackend.model.Visitation;
import com.example.paidservicebackend.repository.visitation.VisitationRepository;
import com.example.paidservicebackend.service.visitation.VisitationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitationServiceImpl implements VisitationService {
    private final VisitationRepository visitationRepository;

    public VisitationServiceImpl(VisitationRepository visitationRepository) {
        this.visitationRepository = visitationRepository;
    }

    @Override
    public List<Visitation> findAll() {
        return visitationRepository.findAll();
    }

    @Override
    public Integer save(Visitation visitation) {
        return visitationRepository.save(visitation);
    }

    @Override
    public void update(Visitation visitation) {
        visitationRepository.update(visitation);
    }

    @Override
    public void delete(Integer visitationId) {
        visitationRepository.delete(visitationId);
    }
}
